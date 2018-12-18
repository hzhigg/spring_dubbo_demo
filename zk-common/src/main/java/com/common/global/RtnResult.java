package com.common.global;

public class RtnResult {

	private Integer code; //状态码
	private String msg; //返回消息
	private Object data; //返回数据

	
	public RtnResult(Integer code) {
		super();
		this.code = code;
	}
	public RtnResult(Integer code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public RtnResult() {
		super();
	}
	public Integer getCode() {
		return code;
	}
	public RtnResult setCode(RtnReultCode code) {
		this.code = code.getCode();
		this.msg=code.getMessage();
		return this;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public RtnResult setData(Object data) {
		this.data = data;
		return this;
	}
	
	public static RtnResult Default(){
		return new RtnResult();
	}
	
	public static RtnResult Success(){
		return new RtnResult().Default().setCode(RtnReultCode.SUCCESS);
	}
	
	public static RtnResult Success(Object data){
		return new RtnResult().Success().setData(data);
	}
	public static RtnResult Fail(){
		return new RtnResult().Default().setCode(RtnReultCode.FAIL);
	}
	public static RtnResult Fail(RtnReultCode code){
		return new RtnResult().Default().setCode(code);
	}
	public static RtnResult Fail(Object data){
		return RtnResult.Fail().setData(data);
	}
	public static RtnResult Fail(Object data,RtnReultCode code){
		return new RtnResult().Fail(data).setCode(code);
	}
}
