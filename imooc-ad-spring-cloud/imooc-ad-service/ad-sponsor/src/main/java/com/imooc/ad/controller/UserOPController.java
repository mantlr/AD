package com.imooc.ad.controller;

import com.alibaba.fastjson.JSON;
import com.imooc.ad.entity.Creative;
import com.imooc.ad.exception.AdException;
import com.imooc.ad.service.IUserService;
import com.imooc.ad.vo.CreateUserRequest;
import com.imooc.ad.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther BoHanMa
 * @date 2020/4/20 14:07
 */
@Slf4j
@RestController
public class UserOPController {

    private final IUserService userService;

    @Autowired
    public UserOPController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("create/user")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) throws AdException{
        log.info("ad-sponsor: createUser -> {}", JSON.toJSONString(request));

        return userService.createUser(request);
    }

    @PostMapping("get/adUserIfo")
    public CreateUserResponse getAdUserInfo(
            @RequestBody CreateUserRequest request) throws AdException{
        log.info("ad-sponsor: getAdUserInfo -> {}",JSON.toJSONString(request));

        log.info("ad-sponsor: response -> {}",JSON.toJSONString(userService.getUser(request)));
        return userService.getUser(request);
    }

}
