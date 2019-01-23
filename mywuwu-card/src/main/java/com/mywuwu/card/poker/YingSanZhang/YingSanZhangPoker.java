package com.mywuwu.card.poker.YingSanZhang;

import com.mywuwu.card.poker.PokerManager;

/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 13:39
 * @Description: 获取三张牌信息
 */
public class YingSanZhangPoker extends PokerManager {
    public YingSanZhang getPocker() {
        return new YingSanZhang(this.get(), this.get(), this.get());
    }

}