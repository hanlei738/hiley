package com.example.demo.service;

import com.example.demo.dao.UserLoginLogRepository;
import com.example.demo.model.UserLoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginLogService {

    @Autowired
    private UserLoginLogRepository userLoginLogDao;

    public List<UserLoginLog> list(){
        return userLoginLogDao.list();
    }
}
