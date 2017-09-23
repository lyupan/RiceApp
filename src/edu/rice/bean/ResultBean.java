package edu.rice.bean;

public class ResultBean<T> {
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	public static <T> ResultBean<T> success(T data) {
		ResultBean<T> resultBean = new ResultBean<T>();
		resultBean.setCode(ErrorCode.SUCCESS.getCode());
		resultBean.setData(data);
		return resultBean;
	}
	
	public static <T> ResultBean<T> success() {
		ResultBean<T> resultBean = new ResultBean<T>();
		resultBean.setCode(ErrorCode.SUCCESS.getCode());
		return resultBean;
	}
	
	public static <T> ResultBean<T> failure(ErrorCode errorCode) {
		ResultBean<T> resultBean = new ResultBean<T>();
		resultBean.setCode(errorCode.getCode());
		return resultBean;
	}
	
	public static <T> ResultBean<T> failure(String code) {
		ErrorCode errorCode = ErrorCode.getErrorCode(code);
		return failure(errorCode);
	}
	
	private String code;
	private T data;
}