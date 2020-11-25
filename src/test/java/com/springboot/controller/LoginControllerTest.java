package com.springboot.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.entity.Rental;
import com.springboot.service.BookService;
import com.springboot.service.UserService;
import com.springboot.util.JwtUtil;

import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mock;
import mockit.MockUp;
import mockit.Tested;
import net.sf.json.JSONObject;

/**
 * @author shang.shi
 *
 */
public class LoginControllerTest {

	@Tested
	public LoginController loginController;

	@Injectable
	UserService userService;

	@Test
	public void testLoginForNull() {
		String body = "{\"userName\": \"user1\", \"password\": \"user1\"}";
		JSONObject obj = JSONObject.fromObject(body);
		String userName = obj.get("userName").toString();
		String password = obj.get("password").toString();
		String authority = "admin";
		MockUp<UserService> userService = new MockUp<UserService>() {
			@Mock
			public String checkPassword(String name, String password) {
				return null;
			}
		};
		new Expectations() {
			{
				Deencapsulation.setField(loginController, "userService", userService.getMockInstance());
			}
		};
		String loginResult = loginController.login(body);
		JSONObject obj2 = JSONObject.fromObject(loginResult);
		// 断言
		assertEquals("null", obj2.get("authority"));
	}
	
	@Test
	public void testLoginForNotNull() {
		String body = "{\"userName\": \"user1\", \"password\": \"user1\"}";
		JSONObject obj = JSONObject.fromObject(body);
		String userName = obj.get("userName").toString();
		String password = obj.get("password").toString();
		String authority = "admin";
		
		MockUp<UserService> userService = new MockUp<UserService>() {
			@Mock
			public String checkPassword(String name, String password) {
				return "admin";
			}
			@Mock
			public int getUserId(String userName) {
				return 10001;
			}
		};
		
		new Expectations() {
			{
				Deencapsulation.setField(loginController, "userService", userService.getMockInstance());
			}
		};
		String loginResult = loginController.login(body);
		JSONObject obj2 = JSONObject.fromObject(loginResult);
		// 断言
		assertEquals("admin", obj2.get("authority"));
	}
}
