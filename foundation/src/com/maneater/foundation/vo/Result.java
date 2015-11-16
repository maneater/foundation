package com.maneater.foundation.vo;

public class Result<T> {
    public int code = 1;
    public String msg;
    public T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static <T> Result<T> result(int code, String msg, T data) {
        Result<T> result = new Result<T>();
        result.code = code;
        result.msg = msg;
        result.data = data;
        return result;
    }
}
