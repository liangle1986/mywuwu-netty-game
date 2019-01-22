package com.mywuwu;

import com.mywuwu.websocket.GameWebSocketSession;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferData implements Serializable {
    private GameWebSocketSession gameWebSocketSession;
    private String channel;
    private int protocol;
    private byte[] data;

    public GameWebSocketSession getGameWebSocketSession() {
        return gameWebSocketSession;
    }

    public void setGameWebSocketSession(GameWebSocketSession gameWebSocketSession) {
        this.gameWebSocketSession = gameWebSocketSession;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public int getProtocol() {
        return protocol;
    }

    public void setProtocol(int protocol) {
        this.protocol = protocol;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public TransferData(GameWebSocketSession gameWebSocketSession, String channel, int protocol, byte[] data) {
        this.gameWebSocketSession = gameWebSocketSession;
        this.channel = channel;
        this.protocol = protocol;
        this.data = data;
    }
}
