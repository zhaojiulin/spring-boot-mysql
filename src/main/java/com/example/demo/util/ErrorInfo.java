package com.example.demo.util;

public class ErrorInfo<T> {

	public static final Integer OK = 0;
	public static final Integer ERROR = -1;

	private Integer code;
	private String message;
	private T data;

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return this.code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}


	public void setData(T data) {
		this.data = data;
	}

	public T getData() {
		return this.data;
	}
}