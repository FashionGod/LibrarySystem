package com.springboot.entity;

/*** @author: zhangjiajun
* @date: ----
* @version: 1.3.0
* @deion: 图书日志类
*/
public class BookLog {

	String userId;
    String bookId;
    String rentalDatetime;
    String returnDatetime;
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
	public String getRentalDatetime() {
		return rentalDatetime;
	}
	public void setRentalDatetime(String rentalDatetime) {
		this.rentalDatetime = rentalDatetime;
	}
	public String getReturnDatetime() {
		return returnDatetime;
	}
	public void setReturnDatetime(String returnDatetime) {
		this.returnDatetime = returnDatetime;
	}
	
}
