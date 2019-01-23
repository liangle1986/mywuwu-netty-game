package com.mywuwu.yingsanzhang.action;

import akka.actor.ActorRef;
import com.mywuwu.core.TransferData;
import com.mywuwu.core.action.BaseAction;
import com.mywuwu.core.annotation.Protocol;
import com.mywuwu.core.network.websocket.GameWebSocketSession;
import com.mywuwu.core.player.Player;
import com.mywuwu.core.room.RoomAction;
import com.mywuwu.yingsanzhang.protocolData.request.A1002Request;
import com.mywuwu.yingsanzhang.protocolData.response.CloseResponse;
import com.mywuwu.yingsanzhang.room.YingSanZhangRoomActorManager;
import com.mywuwu.yingsanzhang.room.YingSanZhangRoomContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;
/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 15:38
 * @Description:
 */
@Component
@Protocol(1001)
public class CloseAction extends BaseAction implements RoomAction<A1002Request, YingSanZhangRoomContext> {


    @Autowired
    private YingSanZhangRoomActorManager roomActorManager;


    @Override
    public void requestAction(TransferData optionalTransferData) {
        GameWebSocketSession gameWebSocketSession = this.valueOperationsByGameWebSocketSession.get(optionalTransferData.getGameWebSocketSession().getId());


        if(gameWebSocketSession.getRoomNumber() != null)
        {
            ActorRef actorRef = roomActorManager.getRoomActorRef(gameWebSocketSession.getRoomNumber());

            actorRef.tell(new A1002Request(gameWebSocketSession.getId(), gameWebSocketSession), null);
        }
    }

    @Override
    public void roomAction(A1002Request message, YingSanZhangRoomContext context) {
        Optional<Player> p = context.getPlayer(message.getName());
        p.ifPresent(player -> {
            player.setDisConnection(true);
            player.setGameWebSocketSession(message.getSession());
            context.sendAll(new CloseResponse(player.getGameWebSocketSession().getId()), 1001);
        });
    }
}