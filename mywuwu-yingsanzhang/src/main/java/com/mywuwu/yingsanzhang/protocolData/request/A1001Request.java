package com.mywuwu.yingsanzhang.protocolData.request;

import com.mywuwu.core.annotation.Protocol;
import com.mywuwu.core.message.baseMessage.RoomMessage;
import com.mywuwu.core.network.websocket.GameWebSocketSession;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Protocol(1001)
public class A1001Request implements RoomMessage {
    private GameWebSocketSession session;
    private String roomNumber;

    public GameWebSocketSession getSession() {
        return session;
    }

    public void setSession(GameWebSocketSession session) {
        this.session = session;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public A1001Request(GameWebSocketSession session, String roomNumber) {
        this.session = session;
        this.roomNumber = roomNumber;
    }
}
