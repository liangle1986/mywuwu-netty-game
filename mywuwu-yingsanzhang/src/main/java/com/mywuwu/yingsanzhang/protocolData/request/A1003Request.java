package com.mywuwu.yingsanzhang.protocolData.request;


import com.mywuwu.core.annotation.Protocol;
import com.mywuwu.core.message.baseMessage.RoomMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Protocol(1003)
public class A1003Request implements RoomMessage {
    private int playerLowerlimit;
    private int playerUpLimit;
    private  int xiaZhuTop;
    private int juShu;
}
