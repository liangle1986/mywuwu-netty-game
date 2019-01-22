package com.mywuwu.player;

import com.mywuwu.YingSanZhang.YingSanZhang;
import com.mywuwu.websocket.GameWebSocketSession;
import lombok.Data;
import lombok.EqualsAndHashCode;

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

    public YingSanZhangPlayerState getState() {
        return state;
    }

    public void setState(YingSanZhangPlayerState state) {
        this.state = state;
    }

    @Override
    public int compareTo(YingSanZhangPlayer o) {
        return this.getYingSanZhang().compareTo(o.getYingSanZhang());
    }
}
