package com.mywuwu.yingsanzhang.player;

import com.mywuwu.card.poker.YingSanZhang.YingSanZhang;
import com.mywuwu.core.network.websocket.GameWebSocketSession;
import com.mywuwu.core.player.Player;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 15:50
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class YingSanZhangPlayer extends Player implements Comparable<YingSanZhangPlayer> {

    private YingSanZhang yingSanZhang;
    private YingSanZhangPlayerState state;

    public YingSanZhangPlayer(int score,
                              Boolean isReady,
                              GameWebSocketSession session) {
        super(score, isReady, session);
        this.setState(YingSanZhangPlayerState.none);
        this.setReady(true);
    }

    private YingSanZhang getYingSanZhang() {
        return yingSanZhang;
    }

    public void setYingSanZhang(YingSanZhang yingSanZhang) {
        this.yingSanZhang = yingSanZhang;
    }


    @Override
    public int compareTo(YingSanZhangPlayer o) {
        return this.getYingSanZhang().compareTo(o.getYingSanZhang());
    }

    public YingSanZhangPlayerState getState() {
        return state;
    }

    public void setState(YingSanZhangPlayerState state) {
        this.state = state;
    }
}
