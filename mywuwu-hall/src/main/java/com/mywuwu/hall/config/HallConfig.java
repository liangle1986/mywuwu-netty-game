package com.mywuwu.hall.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 14:46
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "hall")
public class HallConfig {

    private Map<String, String> routes = new HashMap<>(); //接收prop1里面的属性值
    private Map<String, String> reverseRoutes = new HashMap<>();

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getRoutes() {
        return routes;
    }

    public void setRoutes(Map<String, String> routes) {
        this.routes = routes;
    }

    public Map<String, String> getReverseRoutes() {
        return reverseRoutes;
    }

    public void setReverseRoutes(Map<String, String> reverseRoutes) {
        this.reverseRoutes = reverseRoutes;
    }

    @PostConstruct
    public void init() {
        for (Map.Entry<String, String> entry : routes.entrySet()) {
            reverseRoutes.put(entry.getValue(),entry.getKey());
        }
    }
}