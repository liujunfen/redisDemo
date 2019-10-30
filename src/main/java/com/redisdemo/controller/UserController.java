package com.redisdemo.controller;

import com.redisdemo.entity.User;
import com.redisdemo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {
    @Autowired
    RedisUtil redisUtil;

    @RequestMapping("/set")
    public String set() {
        User user = new User(1, "admin", "123");
        redisUtil.set("user", user);
        return "success saved user !";
    }

    @RequestMapping("/get")
    public String get() {
        User user = (User) redisUtil.get("user");
        return user.toString();
    }
}