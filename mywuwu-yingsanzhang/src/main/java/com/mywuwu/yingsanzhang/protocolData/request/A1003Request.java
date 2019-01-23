package com.mywuwu.yingsanzhang.protocolData.request;


import com.mywuwu.core.annotation.Protocol;
import com.mywuwu.core.message.baseMessage.RoomMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Protocol(1003)
public class A1003Request implements RoomMessage {
    private int playerLowerlimit;
    private int playerUpLimit;
    private  int xiaZhuTop;
    private int juShu;

    public int getPlayerLowerlimit() {
        return playerLowerlimit;
    }

    public void setPlayerLowerlimit(int playerLowerlimit) {
        this.playerLowerlimit = playerLowerlimit;
    }

    public int getPlayerUpLimit() {
        return playerUpLimit;
    }

    public void setPlayerUpLimit(int playerUpLimit) {
        this.playerUpLimit = playerUpLimit;
    }

    public int getXiaZhuTop() {
        return xiaZhuTop;
    }

    public void setXiaZhuTop(int xiaZhuTop) {
        this.xiaZhuTop = xiaZhuTop;
    }

    public int getJuShu() {
        return juShu;
    }

    public void setJuShu(int juShu) {
        this.juShu = juShu;
    }

    public A1003Request(int playerLowerlimit, int playerUpLimit, int xiaZhuTop, int juShu) {
        this.playerLowerlimit = playerLowerlimit;
        this.playerUpLimit = playerUpLimit;
        this.xiaZhuTop = xiaZhuTop;
        this.juShu = juShu;
    }
}