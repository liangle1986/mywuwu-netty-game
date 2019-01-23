package com.mywuwu.yingsanzhang.listen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;


/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 15:45
 * @Description:
 */

@Component
public class RedisListen extends MessageListenerAdapter {


    @Autowired
    private RedisListenTask redisListenTask;


    @Override
    public void onMessage(Message message, byte[] bytes) {
        redisListenTask.doMessageTask(message,bytes);
    }


}