package com.mywuwu.yingsanzhang.protocolData.response;

import com.mywuwu.yingsanzhang.player.YingSanZhangPlayer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 下注操作
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class A1007Response {
    YingSanZhangPlayer player;
    String type;
    double chip;

    public A1007Response(YingSanZhangPlayer player, String type, double chip) {
        this.player = player;
        this.type = type;
        this.chip = chip;
    }
}
