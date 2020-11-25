package com.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.LogDao;
import com.springboot.entity.BookLog;
import com.springboot.entity.LoginLog;
import com.springboot.service.LogService;


/*** @author: zhangjiajun
* @date: ----
* @version: 1.3.0
* @deion: 处理日志
*/
@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogDao lDao;

	/** * 获取图书借还日志
	* @param 
	* @return 图书借还日志
	*/
	@Override
	public List<BookLog> getBookLog() {
		// TODO Auto-generated method stub
		return lDao.getBookLog();
	}

	/** * 获取登录日志
	* @param 
	* @return 获取登录日志
	*/
	@Override
	public List<LoginLog> getLoginLog() {
		// TODO Auto-generated method stub
		return lDao.getLoginLog();
	}

}
