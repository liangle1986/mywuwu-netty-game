package com.mywuwu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Poker {
    private PokerNumber number;
    private PokerType cardType;

    public Poker(PokerNumber pokerNumber, PokerType pokerType) {
        this.number = pokerNumber;
        this.cardType = pokerType;
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
