package com.mywuwu.yingsanzhang.protocolData.request;

import com.mywuwu.core.annotation.Protocol;
import com.mywuwu.core.message.baseMessage.RoomMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Protocol(1004)
public class A1004Request implements RoomMessage {
    private String name;
    private String roomId;
}
