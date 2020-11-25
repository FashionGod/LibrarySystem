package com.springboot.service;

import com.springboot.entity.User;

public interface UserService {
	/** 根据用户名密码返回身份
	 * @param name
	 * @param password
	 * @return
	 */
	public String checkPassword(String name, String password);

	public User getUser(String userId);

	public boolean addUser(User user);

	// public List<User> getAll();

	/** 根据用户名获取用户ID
	 * @param userName
	 * @return
	 */
	public int getUserId(String userName);

	// public User getUserInfo(String userName);

	public User getUserInfo(String userName);

	public boolean updateUserInfo(User user);

	public boolean checkUserThere(String userName);

	boolean registerLog(int userId, String time);
	
}
