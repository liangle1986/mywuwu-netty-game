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
public class GuestResponse {
    private Long id;
    private String name;
    private String nickName;
    private String token;
    private double balance;
    private int cardNumber;

    private List<GameServerList> gameServerLists;

    public GuestResponse(Long id, String name, String nickName, String token, double balance, int cardNumber, List<GameServerList> gameServerLists) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.token = token;
        this.balance = balance;
        this.cardNumber = cardNumber;
        this.gameServerLists = gameServerLists;
    }
}