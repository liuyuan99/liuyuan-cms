package com.liuyuan.cms.dao;

import java.util.List;

import com.liuyuan.cms.domain.User;

public interface UserMapper {

	/**
	 * 
	 * @Title: selects 
	 * @Description: 用户列表
	 * @param user
	 * @return
	 * @return: List<User>
	 */
	List<User> selects(User user);
	/**
	 * 
	 * @Title: update 
	 * @Description: 更新
	 * @param user
	 * @return
	 * @return: int
	 */
	int update(User user);
	
	/**
	 * 
	 * 
	 * @Title: insert 
	 * @Description: 用户注册
	 * @param user
	 * @return
	 * @return: int
	 */
	int insert(User user);
	
	/**
	 * 
	 * @Title: selectByUsername 
	 * @Description: 查询是否存在
	 * @param username
	 * @return
	 * @return: User
	 */
	User selectByUsername(String username);

}
