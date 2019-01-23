package com.mywuwu.card.poker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 13:29
 * @Description: 牌对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Poker {
    private PokerNumber number;
    private PokerType cardType;

    public Poker(PokerNumber number, PokerType cardType) {
        this.number = number;
        this.cardType = cardType;
    }

    public Poker() {
    }

    public PokerNumber getNumber() {
        return number;
    }

    public void setNumber(PokerNumber number) {
        this.number = number;
    }

    public PokerType getCardType() {
        return cardType;
    }

    public void setCardType(PokerType cardType) {
        this.cardType = cardType;
    }
}
