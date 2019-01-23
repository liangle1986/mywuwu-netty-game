package com.mywuwu.yingsanzhang.action;

import akka.actor.ActorRef;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mywuwu.core.TransferData;
import com.mywuwu.core.action.BaseAction;
import com.mywuwu.core.annotation.Protocol;
import com.mywuwu.core.network.websocket.GameWebSocketSession;
import com.mywuwu.core.player.Player;
import com.mywuwu.core.room.RoomAction;
import com.mywuwu.yingsanzhang.player.YingSanZhangPlayer;
import com.mywuwu.yingsanzhang.protocolData.request.A1001Request;
import com.mywuwu.yingsanzhang.protocolData.response.A1011Response;
import com.mywuwu.yingsanzhang.room.YingSanZhangRoomActorManager;
import com.mywuwu.yingsanzhang.room.YingSanZhangRoomContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;
/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 15:39
 * @Description:
 */
@Component
@Protocol(1002)
public class ConnectAction extends BaseAction implements RoomAction<A1001Request, YingSanZhangRoomContext> {

    @Autowired
    private YingSanZhangRoomActorManager roomActorManager;


    @Override
    public void requestAction(TransferData optionalTransferData) {


        GameWebSocketSession session = optionalTransferData.getGameWebSocketSession();

        ActorRef actorRef = roomActorManager.getRoomActorRef(session.getRoomNumber());
        actorRef.tell(new A1001Request(session, session.getRoomNumber()), null);
    }

    @Override
    public void roomAction(A1001Request message, YingSanZhangRoomContext context) {

        Optional<Player> optionalPlayer = context.getPlayer(message.getSession().getId());
        if (optionalPlayer.isPresent()) {
            Player player = optionalPlayer.get();
            player.setGameWebSocketSession(player.getGameWebSocketSession());
            player.setDisConnection(false);
            context.send(new A1011Response(context.deskChip, context.getPlayerList().toArray(new YingSanZhangPlayer[0])),
                    new TransferData(message.getSession(),
                            context.getServerName(), 1011, null));
        }
    }
}