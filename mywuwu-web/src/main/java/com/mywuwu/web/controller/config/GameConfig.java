package com.mywuwu.web.controller.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 15:01
 * @Description:
 */
@Component
@ConfigurationProperties(prefix="game")
public class GameConfig {
    private List<GameServerList> servers = new ArrayList<>();

    public List<GameServerList> getServers() {
        return servers;
    }

    public void setServers(List<GameServerList> servers) {
        this.servers = servers;
    }
}