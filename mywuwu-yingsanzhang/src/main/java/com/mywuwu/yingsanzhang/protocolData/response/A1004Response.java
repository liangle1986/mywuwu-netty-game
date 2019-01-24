package com.mywuwu.yingsanzhang.protocolData.response;

import com.mywuwu.yingsanzhang.player.YingSanZhangPlayer;
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
}
