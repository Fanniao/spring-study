package com.sun.service;

import com.sun.entity.User;
import com.sun.mapper.UserMapper;

public class RegisterService {
	private UserMapper userMapper;

	public RegisterService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	/**
	 * 注册用户
	 * @param user 用户信息[用户名,密码]
	 * @return 注册成功 - true; 失败 - false
	 */
	public boolean register(User user) {
		User user1 = userMapper.findUser(user.getUsername());
		if (user1 != null) {
			return false;
		} else {
			int i = userMapper.addUser(user);
			if (i == 1)
				return true;
			else
				return false;
		}
	}
}
