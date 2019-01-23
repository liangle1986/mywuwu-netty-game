package com.mywuwu.core.room;

/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 13:54
 * @Description: 房间消息处理
 */
public interface RoomAction<T,D> {
    /**
     * 房间消息处理类
     * @param message 消息
     * @param context 当前房间上下文
     * @return
     */
    void roomAction(T message, D context);
}
