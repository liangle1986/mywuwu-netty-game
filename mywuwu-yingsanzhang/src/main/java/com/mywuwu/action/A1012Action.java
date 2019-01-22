package com.mywuwu.action;


import akka.actor.ActorRef;
import com.linkflywind.gameserver.core.TransferData;
import com.linkflywind.gameserver.core.action.BaseAction;
import com.linkflywind.gameserver.core.annotation.Protocol;
import com.linkflywind.gameserver.core.player.Player;
import com.linkflywind.gameserver.core.room.RoomAction;
import com.linkflywind.gameserver.yingsanzhangserver.protocolData.request.A1012Request;
import com.linkflywind.gameserver.yingsanzhangserver.protocolData.response.A1012Response;
import com.linkflywind.gameserver.yingsanzhangserver.room.YingSanZhangRoomActorManager;
import com.linkflywind.gameserver.yingsanzhangserver.room.YingSanZhangRoomContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@Protocol(1012)
public class A1012Action extends BaseAction implements RoomAction<A1012Request, YingSanZhangRoomContext> {


    @Autowired
    private YingSanZhangRoomActorManager roomActorManager;

    @Override
    public void requestAction(TransferData optionalTransferData) {

        if (optionalTransferData.getData() != null) {
            try {
                Map<String,String> map = new HashMap<>();
                A1012Request a1009Request = unPackJson(optionalTransferData.getData(), A1012Request.class);

                ActorRef actorRef = roomActorManager.getRoomActorRef(a1009Request.getRoomId());
                actorRef.tell(a1009Request, null);
            } catch (IOException e) {

            }
        }
    }

    @Override
    public void roomAction(A1012Request message, YingSanZhangRoomContext context) {
        context.sendAll(new A1012Response(message.getName(), context.getRoomNumber()), 1012);
        int person = context.getPlayerList().size() / 2;
        if (context.getPlayerList().stream().filter(p -> ((Player) p).isDisbanded()).count() >= person) {
            context.clearRoom();
        }
    }
}
