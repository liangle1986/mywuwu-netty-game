/*
 * @author   作者: qugang
 * @E-mail   邮箱: qgass@163.com
 * @date     创建时间：2018/11/19
 * 类说明     加入房间
 */
package com.mywuwu.action;

import akka.actor.ActorRef;
import com.mywuwu.TransferData;
import com.mywuwu.annotation.Protocol;
import com.mywuwu.player.YingSanZhangPlayer;
import com.mywuwu.protocolData.request.A1004Request;
import com.mywuwu.protocolData.response.A1004Response;
import com.mywuwu.protocolData.response.ErrorResponse;
import com.mywuwu.room.RoomAction;
import com.mywuwu.room.YingSanZhangRoomActorManager;
import com.mywuwu.room.YingSanZhangRoomContext;
import com.mywuwu.websocket.GameWebSocketSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

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

            context.sendAll(new A1004Response(context.getPlayerList().toArray(new YingSanZhangPlayer[0]), context.getRoomNumber()), 1004);

            if (context.getPlayerList().size() >= context.getPlayerLowerlimit()) {
                context.beginGame();
            }
        } else {
            context.send(new ErrorResponse("房间已满"), new TransferData(session, context.getServerName(), 9999, null));
        }
    }
}
