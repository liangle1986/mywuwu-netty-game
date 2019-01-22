package com.mywuwu.YingSanZhang;

import com.linkflywind.gameserver.cardlib.poker.PokerManager;

public class YingSanZhangPoker extends PokerManager {
    public YingSanZhang getPocker(){
        return new YingSanZhang(this.get(),this.get(),this.get());
    }

}
