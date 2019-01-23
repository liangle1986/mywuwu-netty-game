package com.mywuwu.yingsanzhang.room;


import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.routing.RoundRobinPool;
import com.mywuwu.core.redistool.RedisTool;
import com.mywuwu.core.room.Room;
import com.mywuwu.core.room.RoomManager;
import com.mywuwu.yingsanzhang.player.YingSanZhangPlayer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 15:34
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Component
public class YingSanZhangRoomActorManager extends RoomManager {

    @Autowired
    private ApplicationContext context;


    @Value("${logicserver.connector}")
    private String logicserverConnector;

    @Value("${logicserver.name}")
    private String logicserverName;

    @Autowired
    public YingSanZhangRoomActorManager(
            RedisTemplate redisTemplate,
            ActorSystem actorSystem,
            ApplicationContext context) {
        super(redisTemplate, actorSystem, context);

        this.connectorName = this.logicserverConnector;
        this.serverName = this.logicserverName;
    }


    public String createRoomActor(YingSanZhangPlayer player,
                                  int playerLowerlimit,
                                  int playerUpLimit,
                                  RedisTemplate redisTemplate,
                                  int xiaZhuTop,
                                  int juShu) {
        String roomNumber = RedisTool.inc(this.redisTemplate, "room", -1);

        YingSanZhangRoomContext yingSanZhangRoomContext = (YingSanZhangRoomContext) context.getBean("YingSanZhangRoomContext", roomNumber,
                playerUpLimit,
                playerLowerlimit,
                redisTemplate,
                player,
                serverName,
                connectorName,
                this);

        ActorRef actorRef = actorSystem.actorOf(new RoundRobinPool(1).props(Props.create(Room.class,
                yingSanZhangRoomContext
        )));
        map.put(roomNumber, actorRef);
        return roomNumber;
    }

    public ActorRef getRoomActorRef(String roomId) {
        return map.getOrDefault(roomId, null);
    }

    public void clearRoom(String roomId) {
        ActorRef actorRef = map.remove(roomId);
        actorSystem.stop(actorRef);
    }
}