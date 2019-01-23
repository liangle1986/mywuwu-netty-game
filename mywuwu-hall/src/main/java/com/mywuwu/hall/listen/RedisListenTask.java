package com.mywuwu.hall.listen;

import com.mywuwu.core.TransferData;
import com.mywuwu.hall.GameServer;
import com.mywuwu.hall.config.HallConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 14:50
 * @Description:
 */
@Component
public class RedisListenTask {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private HallConfig hallConfig;

    @Async
    public void doMessageTask(Message message, byte[] bytes) {
        TransferData transferData = (TransferData) this.redisTemplate.getDefaultSerializer().deserialize(message.getBody());
        if (transferData.getData() != null) {
            logger.info(new String(transferData.getData()));

            GameServer.send(Integer.valueOf(hallConfig.getReverseRoutes().get(transferData.getChannel())),
                    Integer.valueOf(transferData.getProtocol()),
                    transferData.getGameWebSocketSession().getSessionId(),
                    transferData.getData());
        }
    }
}
