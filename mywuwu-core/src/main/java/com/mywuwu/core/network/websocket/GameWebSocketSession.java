package com.mywuwu.core.network.websocket;


import io.netty.channel.ChannelId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.yeauty.pojo.Session;

import java.io.Serializable;
import java.util.Optional;

/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 14:02
 * @Description: 游戏信息对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameWebSocketSession implements Serializable {
    @Id
    private String id;
    private ChannelId sessionId;
    private String token;
    private String lastLoginTime;
    private String lastLogoutTime;
    //0: 登陆 1:退出
    private String state;
    private String address;
    private String channel;
    private String roomNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ChannelId getSessionId() {
        return sessionId;
    }

    public void setSessionId(ChannelId sessionId) {
        this.sessionId = sessionId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLogoutTime() {
        return lastLogoutTime;
    }

    public void setLastLogoutTime(String lastLogoutTime) {
        this.lastLogoutTime = lastLogoutTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public GameWebSocketSession(String id, ChannelId sessionId, String token, String lastLoginTime, String lastLogoutTime, String state, String address, String channel, String roomNumber) {
        this.id = id;
        this.sessionId = sessionId;
        this.token = token;
        this.lastLoginTime = lastLoginTime;
        this.lastLogoutTime = lastLogoutTime;
        this.state = state;
        this.address = address;
        this.channel = channel;
        this.roomNumber = roomNumber;
    }
}
