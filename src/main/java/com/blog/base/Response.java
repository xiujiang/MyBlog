package com.blog.base;

import lombok.Data;

/**
 * author:xiujiang.liu
 * Date:2018/12/16
 * Time:10:06
 */

@Data
public class Response<T> {
    private String code;
    private String msg;
    private T data;

    public Response(String code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Response(){
    }

    public Response success(T data){
        return new Response("00","success",data);
    }

    @Override
    public String toString() {
        return "Response{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
