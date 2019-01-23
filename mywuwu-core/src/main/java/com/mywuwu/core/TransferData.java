package com.mywuwu.core;

import com.mywuwu.core.network.websocket.GameWebSocketSession;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 13:51
 * @Description:
 */
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