package com.mywuwu.yingsanzhang.protocolData.response;

import com.mywuwu.yingsanzhang.player.YingSanZhangPlayer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 比牌
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class A1008Response {
    YingSanZhangPlayer player;
    YingSanZhangPlayer toPlayer;

    public A1008Response(YingSanZhangPlayer player, YingSanZhangPlayer toPlayer) {
        this.player = player;
        this.toPlayer = toPlayer;
    }
}
