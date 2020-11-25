package com.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.ReturnBook;
import com.springboot.service.ReturnBookService;
import com.springboot.service.UserService;

/*** @author: zhangjiajun
* @date: ----
* @version: ----
* @deion: 处理图书归还
*/
@CrossOrigin(origins = { "http://localhost:4200", "null" })
@RestController
public class ReturnBookController {
	@Autowired
	private ReturnBookService rbService;

	
	/** * 用户归还图书
	* @param 
	* @return 返回结果
	*/
	@PostMapping("/returnbook")
	@ResponseBody
	public boolean returnbook(@RequestBody ReturnBook returnBook) {

		boolean result = rbService.returnBookCheck(returnBook.getUserId(), returnBook.getBookId());
		if (result) {
			return result;
		}
		return false;
	}
}
