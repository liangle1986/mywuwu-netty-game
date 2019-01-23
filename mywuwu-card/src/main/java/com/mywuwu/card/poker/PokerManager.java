package com.mywuwu.card.poker;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 13:30
 * @Description: 牌信息
 */
public class PokerManager {
    private LinkedList<Poker> pokers = new LinkedList();

    public PokerManager() {
        PokerNumber[] pokerNumber = PokerNumber.values();
        PokerType[] pokerTypes = PokerType.values();

        for (int i = 0; i < pokerTypes.length; i++) {
            for (int j = 0; j < pokerTypes.length; j++) {
                pokers.add(new Poker(pokerNumber[i], pokerTypes[j]));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(pokers);
    }

    protected Poker get() {
        return pokers.pollFirst();
    }

}
