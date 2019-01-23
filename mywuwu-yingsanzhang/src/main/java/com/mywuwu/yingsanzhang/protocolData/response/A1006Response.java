package com.mywuwu.yingsanzhang.protocolData.response;


import com.mywuwu.yingsanzhang.player.YingSanZhangPlayer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 下一个玩家操作
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class A1006Response {
    private YingSanZhangPlayer yingSanZhangPlayer;

    public A1006Response(YingSanZhangPlayer yingSanZhangPlayer) {
        this.yingSanZhangPlayer = yingSanZhangPlayer;
    }
}
