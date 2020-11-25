package com.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.springboot.entity.Book;
import com.springboot.entity.BookLog;
import com.springboot.entity.Rental;

/**
 * @author lvzong.fei and haotian.zhou
 *
 */
@Mapper
public interface BookDao {
	/** 用户可以通过图书ID 或者 作者名  或者 书名 或者 出版社查询图书 默认返回书库所有图书
	 * @param bookId
	 * @param authorName
	 * @param bookName
	 * @param educationName
	 * @return List<Book> 
	 */
	List<Book> findBooksByUser(@Param("bookId") String bookId, @Param("authorName") String authorName,
			@Param("bookName") String bookName, @Param("educationName") String educationName);

	/** 点击借阅后更新书的数目(图书数目减一)
	 * @param bookId
	 * @return
	 */
	int updateBookQuantity(@Param("bookId") String bookId);

	/** 点击借阅后向借阅表插入一条借阅信息
	 * @param rental
	 * @return
	 */
	int insertRental(@Param("rental") Rental rental);

	/** 根据图书ID查找书库剩余图书数目
	 * @param bookId
	 * @return
	 */
	int findQuantityByBookId(@Param("bookId") String bookId);
	
	/** 根据userId和bookId查询当前用户是否可以租借当前图书
	 * @param userId
	 * @param bookId
	 * @return
	 */
	BookLog findRentalStatu(@Param("rental") Rental rental);

	int addBook(@Param("book") Book book);

	int updateBook(@Param("book") Book book);

	int deleteBook(@Param("bookId") String bookId);
}
