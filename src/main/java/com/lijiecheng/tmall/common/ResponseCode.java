package com.lijiecheng.tmall.common;

/**
 * 状态码枚举
 */
public enum  ResponseCode {
    //状态码以及对应的意思
    SUCCESS(0,"SUCCESxS"),
    ERROR(1,"ERROR"),
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT"),
    NEED_LOGIN(10,"NEED_LOGIN");
    private final int code;
    private final String desc;
    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }
    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

}

