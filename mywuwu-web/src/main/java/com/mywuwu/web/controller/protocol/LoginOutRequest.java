package com.mywuwu.web.controller.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 15:18
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginOutRequest {
    private String name;
    private String token;
}