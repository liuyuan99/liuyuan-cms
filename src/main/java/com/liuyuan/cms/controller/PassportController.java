package com.liuyuan.cms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuyuan.cms.domain.User;
import com.liuyuan.cms.service.UserService;
import com.liuyuan.cms.util.CMSException;
import com.liuyuan.cms.util.Result;

/**
 * 
 * @ClassName: PassportController 
 * @Description: 系统的注册登录入口
 * @author: 刘媛
 * @date: 2020年3月11日 上午10:36:39
 */
@RequestMapping("passport")
@Controller
public class PassportController {

	@Resource
	private UserService userService;
	
	/**
	 * 
	 * @Title: reg 
	 * @Description: 注册
	 * @return
	 * @return: String
	 */
	@GetMapping("reg")
	public String reg() {
		return "passport/reg";
	}
	
	/**
	 * 
	 * @Title: reg 
	 * @Description: 执行注册
	 * @return
	 * @return: boolean
	 */
	@PostMapping("reg")
	@ResponseBody
	public Result<User> reg(User user,Model model) {
		Result<User> result = new Result<User>();
		try {
			if (userService.insert(user)>0) {
				result.setCode(200);
				result.setMsg("注册成功");
			}
		}catch (CMSException e) {
			e.printStackTrace();//异常消息控制台打印,方便找BUG
			result.setCode(300);
			result.setMsg("注册失败"+e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();//异常消息控制台打印,方便找BUG
			result.setCode(500);
			result.setMsg("注册失败，系统出现不可预知异常,请联系管理员");
		}
		return result;
	}
	
	/**
	 * 
	 * @Title: login 
	 * @Description: 去登陆普通用户
	 * @return
	 * @return: String
	 */
	@GetMapping("login")
	public String login() {
		return "passport/login";
	}
	
	/**
	 * 
	 * @Title: adminLogin 
	 * @Description: 去登陆-管理员用户
	 * @return
	 * @return: String
	 */
	@GetMapping("admin/login")
	public String adminLogin() {
		return "passport/adminLogin";
	}
	
	/**
	 * 
	 * 
	 * @Title: login 
	 * @Description: 执行登录
	 * @param user
	 * @param model
	 * @return
	 * @return: Result<User>
	 */
	@PostMapping("login")
	@ResponseBody
	public Result<User> login(User formUser,Model model,HttpSession session) {
		Result<User> result = new Result<User>();
		try {
			//去登陆,如果成功返回用户的基本信息
			User user = userService.login(formUser);
			if(user!=null) {
				result.setCode(200);
				result.setMsg("登录成功");
				if(user.getRole()==0) {   //根据角色判断,存不同session  普通 0 管理员 1
					session.setAttribute("user", user); //登录成功,用户信息存入session
				}else {
					session.setAttribute("admin", user); //登录成功,用户信息存入session
				}
			}
			
		}catch (CMSException e) {
			e.printStackTrace();//异常消息控制台打印,方便找BUG
			result.setCode(300);
			result.setMsg("登录失败"+e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();//异常消息控制台打印,方便找BUG
			result.setCode(500);
			result.setMsg("登录失败，系统出现不可预知异常,请联系管理员");
		}
		
		return result;
	
	}
	
	/**
	 * 
	 * @Title: logout 
	 * @Description: 注销
	 * @return
	 * @return: String
	 */
	@GetMapping("logout")
	public String logout(HttpSession session){
		
		//清除session
		session.invalidate();
		return "redirect:/"; //回到系统首页
	}
	
	/**
	 * 
	 * @Title: checkName 
	 * @Description: 检查用户是否存在
	 * @param username
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@PostMapping("checkName")
	public boolean checkName(String username) {
		
		return userService.selectByUsername(username)==null;		
	}
	
	
}
