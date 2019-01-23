package com.mywuwu.yingsanzhang.protocolData.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * 解散房间
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class A1012Response {
    private String name;
    private String roomId;

    public A1012Response(String name, String roomId) {
        this.name = name;
        this.roomId = roomId;
    }
}
