package com.example.demo.service;

import com.example.demo.base.MD5Utils;
import com.example.demo.dao.UserLoginLogRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;
import com.example.demo.model.UserLoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserRepository userDao;

    @Autowired
    private UserLoginLogRepository userLoginLogDao;

    @Transactional
    public boolean add(User user){
        User user1 = userDao.getUserByName(user.getUserName());
        if(null != user1){
            return false;
        }
        userDao.save(user);
        return true;
    }

    @Transactional
    public User login(String userName,String password,String ip){
        User user = userDao.getUserByName(userName);
        if (null == user){
            return null;
        }

        String pwd = MD5Utils.md5(password+"@"+user.getSalt());

        if(pwd.equals(user.getPassword())){
            UserLoginLog userLoginLog = new UserLoginLog();
            userLoginLog.setLoginIp(ip);
            userLoginLog.setLoginTime(new Date());
            userLoginLog.setUserId(user.getId());
            userLoginLogDao.save(userLoginLog);
            return user;
        }else {
            return null;
        }
    }
}
