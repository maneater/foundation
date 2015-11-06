package com.maneater.foundation.vo;

public class Result<T> {
	public int code = 1;
	public String msg;
	public T data;

	public static <T> Result<T> result(int code, String msg, T data) {
		Result<T> result = new Result<T>();
		result.code = code;
		result.msg = msg;
		result.data = data;
		return result;
	}
}
