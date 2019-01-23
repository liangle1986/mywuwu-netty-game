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
@Protocol(1002)
public class A1002Request implements RoomMessage {
    private String name;
    GameWebSocketSession session;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameWebSocketSession getSession() {
        return session;
    }

    public void setSession(GameWebSocketSession session) {
        this.session = session;
    }

    public A1002Request(String name, GameWebSocketSession session) {
        this.name = name;
        this.session = session;
    }
}
