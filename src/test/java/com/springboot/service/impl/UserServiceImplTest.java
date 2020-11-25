package com.springboot.service.impl;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;

import com.springboot.dao.AnotationUserDao;
import com.springboot.dao.MyBatisXMLUserDao;
import com.springboot.entity.Rental;
import com.springboot.entity.User;
import com.springboot.service.BookService;

import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mock;
import mockit.MockUp;
import mockit.Tested;
import mockit.Verifications;

/**
 * @author shishang
 *
 */

public class UserServiceImplTest {
	@Tested
	UserServiceImpl userServiceImpl;

	@Injectable
	AnotationUserDao userDao;
	
	@Injectable
	MyBatisXMLUserDao userMbDao;
	
	@Test
	public void testCheckPasswordForNull() {
		String userName = "user2";
		String password = "user2";
		
		MockUp<AnotationUserDao> userDao = new MockUp<AnotationUserDao>() {
			@Mock
			public User findByUsername(String userid) {
				return null;
			}
		};
		
		// record
		new Expectations() {
			{
				Deencapsulation.setField(userServiceImpl, "userDao", userDao.getMockInstance());
			}
		};
		
		// replay
		String authorityString = userServiceImpl.checkPassword(userName, password);
		
		// assert
		assertEquals(null, authorityString);
	}
	
	@Test
	public void testCheckPasswordForNotNullAndPasswordForTrue() {
		String userName = "user2";
		String password = "user2";
		
		MockUp<AnotationUserDao> userDao = new MockUp<AnotationUserDao>() {
			@Mock
			public User findByUsername(String userid) {
				User user = new User();
				user.setUserid(111);
				user.setAuthority("user");
				user.setPassword("user2");
				return user;
			}
		};
		
		// record
		new Expectations() {
			{
				Deencapsulation.setField(userServiceImpl, "userDao", userDao.getMockInstance());
			}
			{
				userServiceImpl.checkPassword("user2", "user2");
				result = "user";
			}
		};
		
		// replay
		String authorityString = userServiceImpl.checkPassword(userName, password);
		
		// assert
		assertEquals("user", authorityString);
	}
	
	@Test
	public void testCheckPasswordForNotNullAndPasswordForFalse() {
		String userName = "user2";
		String password = "user2";
		
		MockUp<AnotationUserDao> userDao = new MockUp<AnotationUserDao>() {
			@Mock
			public User findByUsername(String userid) {
				User user = new User();
				user.setUserid(111);
				user.setAuthority("user");
				user.setPassword("user");
				return user;
			}
		};
		
		// record
		new Expectations() {
			{
				Deencapsulation.setField(userServiceImpl, "userDao", userDao.getMockInstance());
			}
			{
				userServiceImpl.checkPassword("user2", "user2");
				result = "user";
			}
		};
		
		// replay
		String authorityString = userServiceImpl.checkPassword(userName, password);
		
		// assert
		assertEquals(null, authorityString);
	}
	
	@Test
	public void testGetUser() {
		String userId = "user2";
		
		MockUp<AnotationUserDao> userDao = new MockUp<AnotationUserDao>() {
			@Mock
			public User findById(@Param("userid") String userid) {
				return null;
			}
		};
		
		// record
		new Expectations() {
			{
				Deencapsulation.setField(userServiceImpl, "userDao", userDao.getMockInstance());
			}
		};
		
		// replay
		User user1 = userServiceImpl.getUser(userId);
		
		// assert
		assertEquals(null, user1);
	}
	
	
	@Test
	public void testAddUserForTrue() {
		User user = new User();
		user.setUserid(111);
		user.setUsername("username");
		user.setPassword("password");
		user.setDescription("description");
		user.setAuthority("user");
		user.setEmail("2668376926@qq.com");
		String str = "2020-07-15";
        //指定转换格式
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");    
        //进行转换 
        LocalDate date = LocalDate.parse(str, fmt);
		user.setBirthday(date);
		user.setGrade("大一");
		user.setInterest("唱跳rap篮球");
		user.setComment("asdasdasd");
		MockUp<AnotationUserDao> userDao = new MockUp<AnotationUserDao>() {
			@Mock
			public boolean addUser(int userid,String username,
					String password, String description,
					String authority, String email, LocalDate birthday,
					String sex, String grade, String interest,
					String comment) {
				return true;
			}
		};
		
		// record
		new Expectations() {
			{
				Deencapsulation.setField(userServiceImpl, "userDao", userDao.getMockInstance());
			}
		};
		
		// replay
		Boolean addUser = userServiceImpl.addUser(user);

		// assert
		assertEquals(true, addUser);
	}
	
	@Test
	public void testAddUserForFalse() {
		User user = new User();
		user.setUserid(111);
		user.setUsername("username");
		user.setPassword("password");
		user.setDescription("description");
		user.setAuthority("user");
		user.setEmail("2668376926@qq.com");
		String str = "2020-07-15";
        //指定转换格式
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");    
        //进行转换 
        LocalDate date = LocalDate.parse(str, fmt);
		user.setBirthday(date);
		user.setGrade("大一");
		user.setInterest("唱跳rap篮球");
		user.setComment("asdasdasd");
		MockUp<AnotationUserDao> userDao = new MockUp<AnotationUserDao>() {
			@Mock
			public boolean addUser(int userid,String username,
					String password, String description,
					String authority, String email, LocalDate birthday,
					String sex, String grade, String interest,
					String comment) {
				return false;
			}
		};
		
		// record
		new Expectations() {
			{
				Deencapsulation.setField(userServiceImpl, "userDao", userDao.getMockInstance());
			}
		};
		
		// replay
		Boolean addUser = userServiceImpl.addUser(user);
		
		// assert
		assertEquals(false, addUser);
	}
	
	@Test
	public void testGetUserId() {
		String userName = "user2";
		
		MockUp<AnotationUserDao> userDao = new MockUp<AnotationUserDao>() {
			@Mock
			public User findByUsername(String userName) {
				User user = new User();
				user.setUserid(1111);
				return user;
			}
		};
		
		// record
		new Expectations() {
			{
				Deencapsulation.setField(userServiceImpl, "userDao", userDao.getMockInstance());
			}
		};
		
		// replay
		int userId = userServiceImpl.getUserId(userName);
		
		// assert
		assertEquals(1111, userId);
	}
	
	@Test
	public void testCheckUserThereForTrue() {
		String userName = "user2";
		
		MockUp<AnotationUserDao> userDao = new MockUp<AnotationUserDao>() {
			@Mock
			public User findByUsername(String userName) {
				User user = new User();
				user.setAuthority("user");
				return user;
			}
		};
		
		// record
		new Expectations() {
			{
				Deencapsulation.setField(userServiceImpl, "userDao", userDao.getMockInstance());
			}
		};
		
		// replay
		Boolean userThere = userServiceImpl.checkUserThere(userName);
		
		// assert
		assertEquals(true, userThere);
	}
	
	@Test
	public void testCheckUserThereForFalse() {
		String userName = "user2";
		
		MockUp<AnotationUserDao> userDao = new MockUp<AnotationUserDao>() {
			@Mock
			public User findByUsername(String userName) {
				return null;
			}
		};
		
		// record
		new Expectations() {
			{
				Deencapsulation.setField(userServiceImpl, "userDao", userDao.getMockInstance());
			}
		};
		
		// replay
		Boolean userThere = userServiceImpl.checkUserThere(userName);
		
		// assert
		assertEquals(false, userThere);
	}
	
	@Test
	public void testRegisterLogForTrue() {
		int userId = 111;
		String time = "2020-07-15";
		
		MockUp<AnotationUserDao> userDao = new MockUp<AnotationUserDao>() {
			@Mock
			public boolean registerLogById( int userId, String registerDatetime) {
				return true;
			}
		};
		
		// record
		new Expectations() {
			{
				Deencapsulation.setField(userServiceImpl, "userDao", userDao.getMockInstance());
			}
		};
		
		// replay
		Boolean registerLog = userServiceImpl.registerLog(userId, time);
		
		// assert
		assertEquals(true, registerLog);
	}
	
	@Test
	public void testRegisterLogForFalse() {
		int userId = 111;
		String time = "2020-07-15";
		
		MockUp<AnotationUserDao> userDao = new MockUp<AnotationUserDao>() {
			@Mock
			public boolean registerLogById( int userId, String registerDatetime) {
				return false;
			}
		};
		
		// record
		new Expectations() {
			{
				Deencapsulation.setField(userServiceImpl, "userDao", userDao.getMockInstance());
			}
		};
		
		// replay
		Boolean registerLog = userServiceImpl.registerLog(userId, time);
		
		// assert
		assertEquals(false, registerLog);
	}
	
	@Test
	public void testGetUserInfo() {
		String userName = "user2";
		
		MockUp<AnotationUserDao> userDao = new MockUp<AnotationUserDao>() {
			@Mock
			public User getUserInfo(String userName) {
				User user = new User();
				user.setUserid(666);
				return user;
			}
		};
		
		// record
		new Expectations() {
			{
				Deencapsulation.setField(userServiceImpl, "userDao", userDao.getMockInstance());
			}
		};
		
		// replay
		User user = userServiceImpl.getUserInfo(userName);
		
		// assert
		assertEquals(666, user.getUserid());
	}
	
	@Test
	public void testUpdateUserInfo() {
		User user = new User();
		user.setUserid(666);
		
		MockUp<AnotationUserDao> userDao = new MockUp<AnotationUserDao>() {
			@Mock
			public boolean updateUserInfo(User user) {
				return true;
			}
		};
		
		// record
		new Expectations() {
			{
				Deencapsulation.setField(userServiceImpl, "userDao", userDao.getMockInstance());
			}
		};
		
		// replay
		Boolean userInfo = userServiceImpl.updateUserInfo(user);
		
		// assert
		assertEquals(true, userInfo);
	}
}
