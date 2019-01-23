package com.mywuwu.core.room;


import akka.actor.AbstractActor;
import com.mywuwu.core.annotation.Protocol;
import com.mywuwu.core.message.baseMessage.RoomMessage;

/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 13:54
 * @Description: 房间
 */

public class Room extends AbstractActor {

    private RoomContext roomContext;

    Room(RoomContext roomContext) {
        this.roomContext = roomContext;
    }


    @Override
    public Receive createReceive() {
        return receiveBuilder().match(RoomMessage.class, message -> {
            Integer protocol = message.getClass().getAnnotation(Protocol.class).value();
            roomContext.getRoomManager().getCacheMap().get(protocol).roomAction(message, roomContext);
        }).build();
    }
}
