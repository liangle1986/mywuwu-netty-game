package com.mywuwu.protocolData.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建房间
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class A1003Response {
    private String roomId;

    public A1003Response(String roomId) {
        this.roomId = roomId;
    }
}
