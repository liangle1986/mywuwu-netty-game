package com.mywuwu.yingsanzhang.protocolData.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 断线
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CloseResponse {
    String name;

    public CloseResponse(String name) {
        this.name = name;
    }
}
