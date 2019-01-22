package com.mywuwu.protocolData.response;

import com.linkflywind.gameserver.yingsanzhangserver.player.YingSanZhangPlayer;
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
}
