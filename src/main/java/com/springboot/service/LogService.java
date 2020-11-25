package com.springboot.service;

import java.util.List;

import com.springboot.entity.BookLog;
import com.springboot.entity.LoginLog;

/*** @author: zhangjiajun
* @date: ----
* @version: 1.3.0
* @deion: 处理日志
*/
public interface LogService {

	/** * 获取图书借还日志
	* @param 
	* @return 图书借还日志
	*/
	List<BookLog> getBookLog();
	
	/** * 获取登录日志
	* @param 
	* @return 获取登录日志
	*/
	List<LoginLog> getLoginLog();
}
