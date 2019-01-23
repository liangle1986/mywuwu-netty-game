package com.mywuwu.yingsanzhang.action;

import akka.actor.ActorRef;
import com.mywuwu.core.TransferData;
import com.mywuwu.core.action.BaseAction;
import com.mywuwu.core.annotation.Protocol;
import com.mywuwu.core.player.Player;
import com.mywuwu.core.room.RoomAction;
import com.mywuwu.yingsanzhang.player.YingSanZhangPlayer;
import com.mywuwu.yingsanzhang.protocolData.request.A1009Request;
import com.mywuwu.yingsanzhang.protocolData.response.A1009Response;
import com.mywuwu.yingsanzhang.room.YingSanZhangRoomActorManager;
import com.mywuwu.yingsanzhang.room.YingSanZhangRoomContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;
/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 15:38
 * @Description: 准备
 */
@Component
@Protocol(1009)
public class A1009Action extends BaseAction implements RoomAction<A1009Request, YingSanZhangRoomContext> {

    @Autowired
    private YingSanZhangRoomActorManager roomActorManager;

    @Override
    public void requestAction(TransferData optionalTransferData) throws IOException {
        A1009Request a1009Request = unPackJson(optionalTransferData.getData(), A1009Request.class);


        ActorRef actorRef = roomActorManager.getRoomActorRef(a1009Request.getRoomId());

        actorRef.tell(a1009Request, null);
    }

    @Override
    public void roomAction(A1009Request message, YingSanZhangRoomContext context) {

        Optional<Player> optionalPlayer = context.getPlayer(message.getName());

        if(optionalPlayer.isPresent())
        {
            YingSanZhangPlayer player = (YingSanZhangPlayer) optionalPlayer.get();
            player.setReady(true);
            context.sendAll(new A1009Response(player), 1009);
            if (context.getPlayerList().stream().anyMatch(p -> ((Player) p).isReady())) {
                context.beginGame();
            }
        }
    }
}
