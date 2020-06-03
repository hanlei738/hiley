package com.example.demo.controller;

import com.example.demo.base.Response;
import com.example.demo.service.UserLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/userLoginLog")
@CrossOrigin
public class UserLoginLogController {

    @Autowired
    private UserLoginLogService userLoginLogService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public Response list(){
        return Response.builder().success().data(userLoginLogService.list());
    }
}
