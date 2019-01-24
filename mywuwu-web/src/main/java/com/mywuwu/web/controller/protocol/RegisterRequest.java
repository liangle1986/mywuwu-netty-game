package com.mywuwu.web.controller.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 15:19
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String name;
    private String nickName;
    private String password;
    private String sex;
    private String confirmPassword;
    private String mobileNumber;
    private String verificationCode;
    private String sponsor;

}
