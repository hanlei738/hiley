package com.example.demo.controller;

import com.example.demo.base.IpUtils;
import com.example.demo.base.MD5Utils;
import com.example.demo.base.Response;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/register")
    @ResponseBody
    public Response register(User user){
        String salt = RandomStringUtils.random(8,true,false);
        user.setSalt(salt);
        String encodeStr = MD5Utils.md5(user.getPassword()+"@"+salt);
        user.setPassword(encodeStr);
        user.setState(1);
        user.setCreateTime(new Date());
        boolean flag = userService.add(user);
        if(flag){
            return Response.builder().success();
        }else {
            return Response.builder().error();
        }
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public Response login(String userName, String password, HttpServletRequest request){
        String ip = IpUtils.getIpAddress(request);
        User user = userService.login(userName,password,ip);

        if(null != user){
            return Response.builder().success();
        }else {
            return Response.builder().error();
        }
    }
}
