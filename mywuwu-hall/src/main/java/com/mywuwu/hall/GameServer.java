package com.mywuwu.hall;

import com.mywuwu.core.TransferData;
import com.mywuwu.core.action.DispatcherAction;
import com.mywuwu.core.network.websocket.GameWebSocket;
import com.mywuwu.core.network.websocket.GameWebSocketSession;
import com.mywuwu.hall.config.HallConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.yeauty.annotation.ServerEndpoint;

import java.util.Optional;
/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 14:52
 * @Description:
 */
@Component
@ServerEndpoint (prefix = "netty-websocket")
public class GameServer extends GameWebSocket {

    @Autowired
    private DispatcherAction dispatcherAction;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HallConfig hallConfig;

    @Override
    protected boolean receiveHandle(GameWebSocketSession session, int channel, int protocol, byte[] buffer) {
        String channelString = hallConfig.getRoutes().get(String.valueOf(channel));
        if (channelString.equals(hallConfig.getName())) {
            dispatcherAction.createAction(protocol);
        } else {
            this.redisTemplate.convertAndSend(channelString, new TransferData(session, channelString, protocol, buffer));
        }
        return true;
    }

    @Override
    protected void openHandle(GameWebSocketSession session) {

        if(session.getChannel() != null && !session.getChannel().isEmpty())
        {
            this.redisTemplate.convertAndSend(session.getChannel(), new TransferData(session, "", 1001, null));
        }
    }

    @Override
    protected void closeHandle(GameWebSocketSession session) {
        if(session.getChannel() != null && !session.getChannel().isEmpty()){
            this.redisTemplate.convertAndSend(session.getChannel(), new TransferData(session, "", 1002, null));
        }
    }
}
