package com.mywuwu.yingsanzhang.action;



import akka.actor.ActorRef;
import com.mywuwu.core.TransferData;
import com.mywuwu.core.action.BaseAction;
import com.mywuwu.core.annotation.Protocol;
import com.mywuwu.core.network.websocket.GameWebSocketSession;
import com.mywuwu.core.room.RoomAction;
import com.mywuwu.yingsanzhang.player.YingSanZhangPlayer;
import com.mywuwu.yingsanzhang.protocolData.request.A1004Request;
import com.mywuwu.yingsanzhang.protocolData.response.A1004Response;
import com.mywuwu.yingsanzhang.protocolData.response.ErrorResponse;
import com.mywuwu.yingsanzhang.room.YingSanZhangRoomActorManager;
import com.mywuwu.yingsanzhang.room.YingSanZhangRoomContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 15:38
 * @Description: 加入房间
 */
@Component
@Protocol(1004)
public class A1004Action extends BaseAction implements RoomAction<A1004Request, YingSanZhangRoomContext> {


    @Autowired
    private YingSanZhangRoomActorManager roomActorManager;


    @Override
    public void requestAction(TransferData optionalTransferData) throws IOException {

        if (optionalTransferData.getData() != null) {
            try {
                A1004Request a1004Request = unPackJson(optionalTransferData.getData(), A1004Request.class);
                ActorRef actorRef = roomActorManager.getRoomActorRef(a1004Request.getRoomId());
                actorRef.tell(a1004Request, null);
            } catch (IOException ioException) {

            }
        }
    }

    @Override
    public void roomAction(A1004Request message, YingSanZhangRoomContext context) {
        GameWebSocketSession session = this.valueOperationsByGameWebSocketSession.get(message.getName());
        YingSanZhangPlayer player = new YingSanZhangPlayer(1000, true, session);
        if (context.getPlayerList().size() <= context.getPlayerUpLimit()) {
            context.getPlayerList().add(player);
            session.setRoomNumber(context.getRoomNumber());
            session.setChannel(context.getServerName());

            this.valueOperationsByGameWebSocketSession.set(player.getGameWebSocketSession().getId(), session);
            YingSanZhangPlayer yingSanZhangPlayer = context.getPlayerList().toArray(new YingSanZhangPlayer[0])[0];
            context.sendAll(new A1004Response(yingSanZhangPlayer, context.getRoomNumber()), 1004);

            if (context.getPlayerList().size() >= context.getPlayerLowerlimit()) {
                context.beginGame();
            }
        } else {
            context.send(new ErrorResponse("房间已满"), new TransferData(session, context.getServerName(), 9999, null));
        }
    }
}
