package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
public class UserLoginLogVO implements Serializable {

    private long loginId;

    private String userName ;

    private Date loginTime;

    private String loginIp;

    public UserLoginLogVO(long loginId,String userName,Date loginTime,String loginIp){
        this.loginIp = loginIp;
        this.loginTime = loginTime;
        this.userName = userName;
        this.loginId = loginId;
    }
}
