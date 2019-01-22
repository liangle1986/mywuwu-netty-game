package com.mywuwu.protocolData.response;

import com.mywuwu.player.YingSanZhangPlayer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 加入房间
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class A1004Response {
    private YingSanZhangPlayer yingSanZhangPlayers;
    private String roomNumber;

    public A1004Response(YingSanZhangPlayer yingSanZhangPlayers, String roomNumber) {
        this.yingSanZhangPlayers = yingSanZhangPlayers;
        this.roomNumber = roomNumber;
    }

    public YingSanZhangPlayer getYingSanZhangPlayers() {
        return yingSanZhangPlayers;
    }

    public void setYingSanZhangPlayers(YingSanZhangPlayer yingSanZhangPlayers) {
        this.yingSanZhangPlayers = yingSanZhangPlayers;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }


}
