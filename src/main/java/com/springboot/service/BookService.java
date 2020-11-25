package com.springboot.service;

import java.io.IOException;
import java.util.List;

import com.springboot.entity.Book;
import com.springboot.entity.Rental;
import com.springboot.entity.UploadedFile;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author lvzong.fei and haotian.zhou
 *
 */
public interface BookService {
	/** 根据图书ID 或者 作者名 或者 书名  或者 出版社名查新图书 什么都不填时返回所有图书
	 * @param bookId
	 * @param authorName
	 * @param bookName
	 * @param educationName
	 * @return
	 */
	public List<Book> queryBooks(String bookId, String authorName, String bookName, String educationName);

	/**点击借阅后更新书的数目(图书数目减一)
	 * @param rental
	 * @return
	 */
	public boolean updateBookCount(Rental rental);
	
	/** 看当前用户是否可以借书 如果结果了同一本书 在归还之前就不可以再借
	 * @param rental
	 * @return
	 */
	public boolean checkRental(Rental rental);

	public boolean addBook(Book book);

	public boolean updateBook(Book book);

	public boolean deleteBook(String bookId);

	public UploadedFile uploadBookImg(MultipartFile bookImg) throws IllegalStateException, IOException;
}
