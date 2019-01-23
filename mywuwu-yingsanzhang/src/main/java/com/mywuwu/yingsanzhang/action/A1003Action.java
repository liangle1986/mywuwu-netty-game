package com.mywuwu.yingsanzhang.action;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mywuwu.core.TransferData;
import com.mywuwu.core.action.BaseAction;
import com.mywuwu.core.annotation.Protocol;
import com.mywuwu.core.network.websocket.GameWebSocketSession;
import com.mywuwu.core.room.RoomAction;
import com.mywuwu.core.room.RoomContext;
import com.mywuwu.data.monoModel.UserModel;
import com.mywuwu.data.monoRepository.UserRepository;
import com.mywuwu.yingsanzhang.player.YingSanZhangPlayer;
import com.mywuwu.yingsanzhang.protocolData.request.A1003Request;
import com.mywuwu.yingsanzhang.protocolData.response.A1003Response;
import com.mywuwu.yingsanzhang.protocolData.response.ErrorResponse;
import com.mywuwu.yingsanzhang.room.YingSanZhangRoomActorManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;
/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 15:38
 * @Description: 创建房间
 */
@Component
@Protocol(1003)
public class A1003Action extends BaseAction implements RoomAction<A1003Request, RoomContext> {

    @Value("${logicserver.connector}")
    private String connectorName;

    @Value("${logicserver.name}")
    private String serverName;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private YingSanZhangRoomActorManager roomActorManager;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void requestAction(TransferData optionalTransferData) throws IOException {
        A1003Request a1003Request = unPackJson(optionalTransferData.getData(), A1003Request.class);
        String id = optionalTransferData.getGameWebSocketSession().getId();

        GameWebSocketSession session = optionalTransferData.getGameWebSocketSession();

        Optional<UserModel> optionalUserModel = this.userRepository.findById(Long.valueOf(id));


        if (session.getRoomNumber() == null || session.getRoomNumber().isEmpty()) {
            optionalUserModel.ifPresent(userModel -> {
                if (userModel.getUserType() > 0) {
                    YingSanZhangPlayer p = new YingSanZhangPlayer(1000, true, session);
                    p.setGameWebSocketSession(session);
                    session.setChannel(serverName);
                    String roomNumber = roomActorManager.createRoomActor(p,
                            a1003Request.getPlayerLowerlimit(),
                            a1003Request.getPlayerUpLimit(),
                            redisTemplate,
                            a1003Request.getXiaZhuTop(),
                            a1003Request.getJuShu());

                    session.setRoomNumber(roomNumber);
                    this.valueOperationsByGameWebSocketSession.set(id, session);

                    try {
                        send(new A1003Response(roomNumber), optionalTransferData, connectorName);
                    } catch (JsonProcessingException e) {
                        logger.error("json error:", e);
                    }
                } else {
                    try {
                        optionalTransferData.setProtocol(9999);
                        send(new ErrorResponse("房卡不足"), optionalTransferData, connectorName);
                    } catch (JsonProcessingException e) {
                        logger.error("json error:", e);
                    }
                }
            });
        } else {
            send(new A1003Response(session.getRoomNumber()), optionalTransferData, connectorName);
        }
    }

    @Override
    public void roomAction(A1003Request message, RoomContext context) {

    }
}