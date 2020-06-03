package com.example.demo.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Response {

    private Object data;

    private String resultDesc;

    private Integer ResultCode;

    public static Response builder(){
        return new Response();
    }

    public Response success(){
        this.setResultDesc("执行成功");
        this.setResultCode(1);
        return this;
    }

    public Response error(){
        this.setResultDesc("执行失败");
        this.setResultCode(0);
        return this;
    }

    public Response data(Object data){
        this.setData(data);
        return this;
    }
}
