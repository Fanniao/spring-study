package com.sun.service;

import com.sun.entity.User;
import com.sun.mapper.UserMapper;

public class LoginService {

	private UserMapper userMapper;

	public LoginService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	/**
	 * 登陆验证
	 * @param user 存放用户信息对象[用户名和密码]
	 * @return true登陆成功, false登陆失败
	 */
	public boolean login(User user){
		User mapperUser = userMapper.findUser(user.getUsername());
		if (mapperUser == null)
			return false;
		if (user.getUsername().equals(mapperUser.getUsername()) && user.getPassword().equals(mapperUser.getPassword())) {
			return true;
		}
		return false;
	}
}
