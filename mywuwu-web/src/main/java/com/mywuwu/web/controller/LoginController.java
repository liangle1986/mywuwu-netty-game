package com.mywuwu.web.controller;

import com.mywuwu.core.network.websocket.GameWebSocketSession;
import com.mywuwu.core.security.JwtTokenUtil;
//import com.mywuwu.data.monoModel.UserModel;
//import com.mywuwu.data.monoRepository.UserRepository;
import com.mywuwu.mysql.entity.Test;
import com.mywuwu.mysql.service.TestService;
import com.mywuwu.web.controller.config.GameConfig;
import com.mywuwu.web.controller.protocol.GuestResponse;
import com.mywuwu.web.controller.protocol.LoginRequest;
import com.mywuwu.web.controller.protocol.LoginResponse;
import com.mywuwu.web.controller.protocol.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 14:59
 * @Description:
 */
@RestController
@CrossOrigin
public class LoginController {

//    private final UserRepository userRepository;

    private final TestService testService;
    private final GameConfig config;

    protected final ValueOperations<String, GameWebSocketSession> valueOperationsByGameWebSocketSession;

    private final RedisTemplate redisTemplate;

    private final JwtTokenUtil jwtTokenUtil;


    @Autowired
    public LoginController(
            TestService testService,
            GameConfig config,
            RedisTemplate redisTemplate,
            JwtTokenUtil jwtTokenUtil
    ) {
        this.testService = testService;
        this.config = config;
        this.redisTemplate = redisTemplate;
        this.jwtTokenUtil = jwtTokenUtil;
        this.valueOperationsByGameWebSocketSession = this.redisTemplate.opsForValue();
    }


    @PostMapping("api/login1")
    public Optional<LoginResponse> login(@RequestBody LoginRequest loginForm) {
        List<Test> test = testService.getFindAll();
//        UserModel userModel = userRepository.findByNameAndPassword(loginForm.getName(), loginForm.getPassword());
        if (test != null && test.size() > 0) {
            String token = "";
//                    jwtTokenUtil.generateToken(test.get(0).getName());
//            LoginResponse loginResponse = new LoginResponse(test.get(0).getName(),
//                    test.get(0).getName(),
//                    token,
//                    0,
//                    0,
//                    config.getServers()
//            );

            return Optional.of(new LoginResponse());
        }
        return Optional.empty();
    }

    @GetMapping("api/login")
    public Optional<LoginResponse> getTest() {
        List<Test> test = testService.getFindAll();
        if (test != null && test.size() > 0) {
            String token = jwtTokenUtil.generateToken(test.get(0).getName());
            LoginResponse loginResponse = new LoginResponse<Test>(0, null, 0, 0,
                    config.getServers(), test.get(0)
            );

            return Optional.of(loginResponse);
        }
        return Optional.empty();
    }

//    @GetMapping("api/guest")
//    public GuestResponse guest(String deviceId) {
//        UserModel userModel = userRepository.findByNameAndUserType(deviceId, 1);
//        if (userModel == null) {
//            userModel = new UserModel();
//            userModel.setName(deviceId);
//            userModel.setNickName("访客");
//            userModel.setBalance(0);
//            userModel.setCardNumber(3);
//            userModel.setMobileNumber("");
//            userModel.setPassword("");
//            userModel.setSex("0");
//            userModel.setSponsor("");
//            userModel.setUserType(1);
//            userRepository.save(userModel);
//        }


//        String token = jwtTokenUtil.generateToken(String.valueOf(userModel.getId()));
//        return new GuestResponse();
//                new GuestResponse(userModel.getId()
//                ,userModel.getName(),
//                userModel.getNickName(),
//                token,
//                0,
//                3,
//                config.getServers()
//        );
//    }

//    @PostMapping("api/register")
//    public UserModel register(@RequestBody RegisterRequest registerForm) {
//        //todo 验证码
//        UserModel userModel = new UserModel();
//
//        userModel.setName( registerForm.getName());
//        userModel.setNickName( registerForm.getNickName());
//        userModel.setBalance(0);
//        userModel.setCardNumber(3);
//        userModel.setMobileNumber( registerForm.getMobileNumber());
//        userModel.setPassword( registerForm.getPassword());
//        userModel.setSex("0");
//        userModel.setSponsor("");
//        userModel.setUserType(0);
//        userRepository.save(userModel);
//        return userModel;
//    }
}