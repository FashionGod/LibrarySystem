package com.springboot.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.dao.BookDao;
import com.springboot.entity.Book;
import com.springboot.entity.BookLog;
import com.springboot.entity.Rental;
import com.springboot.entity.UploadedFile;
import com.springboot.service.BookService;

/**
 * @author lvzong.fei
 *
 */
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;

	@Override
	public List<Book> queryBooks(String bookId, String authorName, String bookName, String educationName) {
		List<Book> books = bookDao.findBooksByUser(bookId, authorName, bookName, educationName);
		return books;
	}

	@Override
	public boolean updateBookCount(Rental rental) {
		int bookCount = bookDao.findQuantityByBookId(rental.getBookId());
		// 剩余书的数目>0
		if (bookCount > 0) {
			int updateNumber = bookDao.updateBookQuantity(rental.getBookId());
			// 减一成功
			if (updateNumber != 0) {
				int insertNumber = bookDao.insertRental(rental);
				// 插入数据库借阅时间成功
				if (insertNumber != 0) {
					return true;
				// 插入数据库借阅时间失败
				} else {
					return false;
				}
			// 减一失败
			} else {
				return false;
			}
		// 剩余书的数目<0
		} else {
			return false;
		}
	}

	@Override
	public boolean addBook(Book book) {
		try {
			return bookDao.addBook(book) > 0;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean updateBook(Book book) {
		try {
			return bookDao.updateBook(book) > 0;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean deleteBook(String bookId) {
		return this.bookDao.deleteBook(bookId) > 0;
	}

	@Override
	public UploadedFile uploadBookImg(MultipartFile bookImg) throws IllegalStateException, IOException {
		// 上传图片的本来名字
		String filename = bookImg.getOriginalFilename();
		// 图片后缀名
		String suffixName = filename.substring(filename.lastIndexOf(".")); 
		// 图片重命名 防止重复
		filename = UUID.randomUUID().toString() + suffixName;
		// String filePath = System.getProperty("user.dir") +
		// "/src/main/resources/images/"; // src下的resources文件夹
		String filePath = "D:/bookImages/";

//		try {
			String uploadDir = ResourceUtils.getURL("classpath:").getPath() + "images/"; // target下的resources文件夹
			System.out.println(uploadDir);
			File destFile = new File(filePath + filename);
			bookImg.transferTo(destFile);
			System.out.println(destFile.getAbsolutePath());
//		} catch (IOException e) {
//			System.err.println(e);
//		}
		return new UploadedFile(bookImg.getOriginalFilename(), "done",
				"http://localhost:8080/" + bookImg.getOriginalFilename());
	}

	@Override
	public boolean checkRental(Rental rental) {
		BookLog bookLog = this.bookDao.findRentalStatu(rental);
		if(bookLog != null) {
			// 表示借过这本书
			return true;
		} else {
			// 表示未借过这本书
			return false;
		}
	}
}
