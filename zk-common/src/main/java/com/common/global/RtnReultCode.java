package com.common.global;

public enum RtnReultCode {

	FAIL(0,"Fail"),/* 失败状态码 */
    SUCCESS(1, "Success"),/* 成功状态码 */
    NOT_LOGIN(2,"Not login"),//未登录
    LOGIN_ERROR(3,"Login error,Please login again."),//登录异常，请重新登录
    USEER_COMPANY_ERROR(4,"No facotry information now."),//登录异常，请重新登录 当前用户无工厂信息
    /*	===========通用======================================*/

    PARAMETER_IS_NULL(1000,"Parameter Error"),   //参数为空
    GET_USERINFO_FIAL(1008,"Invalid Ssession"),    //获取用户信息失败（UserManagerUtil.getSessionUser(session) 该方法获取用户信息失败的时候可以用这个错误代码）
    INVALID_SESSION(1009,"Invalid Session"),    //无效session
    /* 用户信息状态码 */
    PASSWORD_WRONG(1001,"Password is wrong"),	//密码错误
    USER_NOT_EXIST(1002,"User not exist"),		//用户不存在
	CURRENT_EMAIL_ALREADY_EXISTS(1003,"Current email already exist");	//当前账号已存在
	
	
	private Integer code;

    private String message;
    
    
    
    public Integer getCode() {
		return code;
	}



	public void setCode(Integer code) {
		this.code = code;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	RtnReultCode(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	
}
