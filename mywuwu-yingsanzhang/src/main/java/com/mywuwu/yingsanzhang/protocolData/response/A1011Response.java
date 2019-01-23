package com.mywuwu.yingsanzhang.protocolData.response;


import com.mywuwu.yingsanzhang.player.YingSanZhangPlayer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 重新连接
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class A1011Response {
    private double zhuoMain;
    YingSanZhangPlayer[] players;

    public A1011Response(double zhuoMain, YingSanZhangPlayer[] players) {
        this.zhuoMain = zhuoMain;
        this.players = players;
    }
}
