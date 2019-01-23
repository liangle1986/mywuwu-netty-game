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
public class LoginRequest {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
