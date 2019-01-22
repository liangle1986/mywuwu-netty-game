/*
* @author   作者: lianglele
* @E-mail   邮箱: liangle1986@126.com
* @date     创建时间：2018/11/21
* 类说明     请求父类
*/
package com.mywuwu.action;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mywuwu.TransferData;
import com.mywuwu.websocket.GameWebSocketSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Async;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public abstract class BaseAction {

    @Autowired
    protected  RedisTemplate redisTemplate;
    protected  ValueOperations<String,GameWebSocketSession> valueOperationsByGameWebSocketSession;

    @PostConstruct
    protected void init(){
        this.valueOperationsByGameWebSocketSession = this.redisTemplate.opsForValue();
    }


    /**
     * 请求消息处理
     * @param optionalTransferData 请求报文
     */
    public abstract void requestAction(TransferData optionalTransferData) throws IOException;


    protected <T> T unPackJson(byte[] array, Class<T> tClass) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(array, tClass);
    }

    protected Map<String, String> unPackJson(byte[] array) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(array, new HashMap<String, String>().getClass());
    }

    private byte[] packJson(Object o) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsBytes(o);
    }


    @Async
    protected void send(Object o, TransferData transferData, String connector) throws JsonProcessingException {
        byte[] data = packJson(o);
        transferData.setData(data);
        this.redisTemplate.convertAndSend(connector, transferData);
    }




}
