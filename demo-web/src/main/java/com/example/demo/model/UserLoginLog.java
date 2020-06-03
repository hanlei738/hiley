package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
@Entity
@Table(name = "userLoginLog")
public class UserLoginLog implements Serializable {

    @Id
    @Column(name = "login_id")
    private long longId;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "login_time")
    private Date loginTime;

    @Column(name = "login_ip")
    private String loginIp;
}
