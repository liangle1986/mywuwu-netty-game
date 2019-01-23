package com.mywuwu.web.controller.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 15:01
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameServerList {
    private String ip;
    private String port;
    private String name;
    private String path;
}