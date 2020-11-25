package com.springboot.entity;


/*** @author: zhangjiajun
* @date: ----
* @version: 1.3.0
* @deion: 还书日志类
*/
public class ReturnBook {
	String userId;
	String bookId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
}
