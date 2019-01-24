package com.mywuwu.web.controller.protocol;

import com.mywuwu.web.controller.config.GameServerList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 15:18
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse<T> {
//    private String name;
//    private String nickName;
//    private String token;
//    private double balance;
//    private int cardNumber;
    private int code;
    private String desc;
    private int gameType;
    private int msgType;
    private List<GameServerList> gameServerLists;
    private T data;

}
