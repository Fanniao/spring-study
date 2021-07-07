package com.sun.mapper;

import com.sun.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	User findUser(String username);

	int addUser(User user);

	int update(User user);
}
