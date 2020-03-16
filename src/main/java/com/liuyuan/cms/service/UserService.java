package com.liuyuan.cms.service;

import com.github.pagehelper.PageInfo;
import com.liuyuan.cms.domain.User;

public interface UserService {
	/**
	 * 
	 * @Title: selects 
	 * @Description: 用户列表
	 * @param user
	 * @return
	 * @return: List<User>
	 */
	PageInfo<User> selects(User user,Integer page,Integer pageSize);

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

	/**
	 * 
	 * @Title: login 
	 * @Description: 登录
	 * @return
	 * @return: User
	 */
	User login(User user);
}
