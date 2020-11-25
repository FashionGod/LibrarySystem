package com.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.BookLog;
import com.springboot.entity.LoginLog;
import com.springboot.service.LogService;


/*** @author: zhangjiajun
* @date: ----
* @version: ----
* @deion: 处理日志
*/
@CrossOrigin(origins = { "http://localhost:4200", "null" })
@RestController
public class LogController {

	@Autowired
	private LogService logService;

	/** * 获取图书借还日志
	* @param 
	* @return 图书借还日志
	*/
	@PostMapping("/getBookLog")
	@ResponseBody
	public List<BookLog> getBookLog(HttpServletRequest request) {

		List<BookLog> result = this.logService.getBookLog();

		return result;
	}

	/** * 获取登录日志
	* @param 
	* @return 获取登录日志
	*/
	@PostMapping("/getLoginLog")
	@ResponseBody
	public List<LoginLog> getLoginLog(HttpServletRequest request) {

		List<LoginLog> result = this.logService.getLoginLog();

		return result;
	}
}
