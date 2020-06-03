package com.example.demo.dao;

import com.example.demo.model.User;
import com.example.demo.model.UserLoginLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserLoginLogRepository extends JpaRepository<User,Integer> {

    UserLoginLog save(UserLoginLog userLoginLog);

    @Query("select new com.example.demo.model.UserLoginLogVO(u.id,u.userName,ull.loginTime,ull.loginIp)from UserLoginLog ull left join User u on ull.userId = u.id")
    List<UserLoginLog> list();
}
