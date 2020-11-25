package com.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.entity.BookLog;
import com.springboot.entity.LoginLog;

/*** @author: zhangjiajun
* @date: ----
* @version: ----
* @deion: 处理日志
*/
@Mapper
public interface LogDao {

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
