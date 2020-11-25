package com.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.springboot.entity.BookLog;

/*** @author: zhangjiajun
* @date: ----
* @version: 1.3.0
* @deion: 处理图书归还
*/
@Mapper
public interface ReturnBookDao {
	
	/** * 用户归还图书
	* @param userId 用户id
	* @param bookId 图书id
	* @return 返回结果
	*/
	int ReturnBook(@Param("userId") String userId, @Param("bookId") String bookId);
	/** * 查询用户是否归还过书籍
	* @param userId 用户id
	* @param bookId 图书id
	* @return 返回结果
	*/
	List<BookLog> getReturnBook(@Param("userId") String userId, @Param("bookId") String bookId);
}
