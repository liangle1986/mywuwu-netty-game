package com.mywuwu.yingsanzhang.action;

import akka.actor.ActorRef;
import com.mywuwu.core.TransferData;
import com.mywuwu.core.action.BaseAction;
import com.mywuwu.core.annotation.Protocol;
import com.mywuwu.core.player.Player;
import com.mywuwu.core.room.RoomAction;
import com.mywuwu.yingsanzhang.protocolData.request.A1012Request;
import com.mywuwu.yingsanzhang.protocolData.response.A1012Response;
import com.mywuwu.yingsanzhang.room.YingSanZhangRoomActorManager;
import com.mywuwu.yingsanzhang.room.YingSanZhangRoomContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 15:38
 * @Description:
 */
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
