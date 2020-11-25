package com.springboot.entity;


/*** @author: zhangjiajun
* @date: ----
* @version: 1.3.0
* @deion: 登录日志类
*/
public class LoginLog {

	String userId;
    String userName;
    String registerDatetime;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRegisterDatetime() {
		return registerDatetime;
	}
	public void setRegisterDatetime(String registerDatetime) {
		this.registerDatetime = registerDatetime;
	}
}
