package com.blog.base;

import lombok.Data;

/**
 * author:xiujiang.liu
 * Date:2018/12/16
 * Time:10:06
 */

@Data
public class Response {
    private String code;
    private String msg;
    private Object data;

    public Response(String code,String msg,Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Response(){
    }

    public Response success(Object data){
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
