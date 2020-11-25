package com.springboot.service;


/*** @author: zhangjiajun
* @date: ----
* @version: 1.3.0
* @deion: 处理图书归还
*/
public interface ReturnBookService {
	
	/** * 用户归还图书
	* @param userId 用户id
	* @param bookId 图书id
	* @return 返回结果
	*/
	public boolean returnBookCheck(String userId,String bookId);
}
