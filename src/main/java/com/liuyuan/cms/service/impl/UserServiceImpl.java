package com.liuyuan.cms.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuyuan.cms.dao.UserMapper;
import com.liuyuan.cms.domain.User;
import com.liuyuan.cms.service.UserService;
import com.liuyuan.cms.util.CMSException;
import com.liuyuan.cms.util.Md5Util;
import com.ly.common.utils.StringUtil;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper userMapper;

	@Override
	public PageInfo<User> selects(User user, Integer page, Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		List<User> list = userMapper.selects(user);
		return new PageInfo<User>(list);
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return userMapper.update(user);
	}

	@Override
	public int insert(User user) {
		//通过自定义效验规则,对注册用户进行效验
		//1、用户名不能为空	 用户名不能重复	
		if(!StringUtil.hasText(user.getUsername()))
			throw new CMSException("用户不能为空");
		
		//2、判断长度
		if(!(user.getUsername().length()>=2 && user.getUsername().length()<=10))
			throw new CMSException("用户名长度在2-10之间");
		
		User findUser = this.selectByUsername(user.getUsername());
		if(findUser!=null) {
			throw new CMSException("用户名已被注册");
		}
		
		if(!StringUtil.hasText(user.getPassword()))
			throw new CMSException("密码不能为空");
		//3 密码效验
		if(!(user.getPassword().length()>=6 && user.getPassword().length()<=10))
			throw new CMSException("密码长度在6-10之间");
		
		if(!StringUtil.hasText(user.getRepassword())) {
			throw new CMSException("确认密码不能为空");
		}
		
		if(!user.getRepassword().equals(user.getPassword()))
			throw new CMSException("两次密码不一致");
		
		user.setPassword(Md5Util.encode(user.getPassword()));
		user.setCreated(new Date());//注册时间
		user.setNickname(user.getUsername()); //默认用户昵称
		user.setLocked("0"); //默认用户状态可用的
		return userMapper.insert(user);
	}

	@Override
	public User selectByUsername(String username) {
		// TODO Auto-generated method stub
		return userMapper.selectByUsername(username);
	}
	
	/**
	 * 登录
	 */
	public User login(User user) {
		//1、用户名不能为空		
		if(!StringUtil.hasText(user.getUsername()))
			throw new CMSException("用户不能为空");
		//2 检查用户名是否存在
		User u = this.selectByUsername(user.getUsername());
		if(u==null) {
			throw new CMSException("该用户名不存在");			
		}
		//3 比较密码是否一致
		//对登录的密码进行加密 在和数据库的密码进行比较
		if(!Md5Util.encode(user.getPassword()).equals(u.getPassword())) {
			throw new CMSException("密码不正确,请重新录入");			
		}
		//4
		if(u.getLocked().equals("1")) {
			throw new CMSException("登陆失败，当前账户被禁用，不能登录");
		}
		return u;
		
	}
}
