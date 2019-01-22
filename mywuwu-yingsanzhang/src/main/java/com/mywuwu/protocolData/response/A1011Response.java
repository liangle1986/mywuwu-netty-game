package com.mywuwu.protocolData.response;


import com.linkflywind.gameserver.yingsanzhangserver.player.YingSanZhangPlayer;
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
}
