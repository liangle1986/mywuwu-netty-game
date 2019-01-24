package com.mywuwu.yingsanzhang.protocolData.response;

import com.mywuwu.yingsanzhang.player.YingSanZhangPlayer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 开始游戏
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class A1005Response {
    private YingSanZhangPlayer[] gameWebSocketSessions;
    private YingSanZhangPlayer yingSanZhangPlayer;

}
