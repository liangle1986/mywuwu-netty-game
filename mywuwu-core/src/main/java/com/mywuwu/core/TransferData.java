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


}