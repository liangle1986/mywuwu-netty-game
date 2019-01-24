package com.mywuwu.yingsanzhang.protocolData.request;

import com.mywuwu.core.annotation.Protocol;
import com.mywuwu.core.message.baseMessage.RoomMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Protocol(1006)
public class A1008Request implements RoomMessage {
    String roomId;
    String toName;

}
