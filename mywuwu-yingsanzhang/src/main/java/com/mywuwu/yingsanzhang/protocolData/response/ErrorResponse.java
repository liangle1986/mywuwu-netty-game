package com.mywuwu.yingsanzhang.protocolData.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 错误
 */
@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
}
