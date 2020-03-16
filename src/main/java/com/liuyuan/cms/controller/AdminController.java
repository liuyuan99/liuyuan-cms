package com.liuyuan.cms.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.liuyuan.cms.domain.Article;
import com.liuyuan.cms.domain.User;
import com.liuyuan.cms.service.ArticleService;
import com.liuyuan.cms.service.UserService;

/**
 * 
 * @ClassName: AdminController 
 * @Description:管理员中心
 * @author: 刘媛
 * @date: 2020年3月6日 上午10:00:44
 */

@RequestMapping("admin")
@Controller
public class AdminController {

	@Resource
	private ArticleService articleService;
	@Resource
	UserService userService;
	/**
	 * 
	 * 
	 * @Title: index 
	 * @Description: 进入管理员首页
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = {"","/","index"})
	public String index() {
		return "admin/index";
	}	
	
	/**
	 * 
	 * @Title: users 
	 * @Description: 用户列表
	 * @param model
	 * @param user
	 * @param page
	 * @param pageSize
	 * @return
	 * @return: String
	 */
	@RequestMapping("users") 
	public String users(Model model,User user,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "18")Integer pageSize) {
		
		PageInfo<User> info = userService.selects(user, page, pageSize);
		model.addAttribute("info", info);
		model.addAttribute("user", user);

		return "admin/users";
		
	}
	
	/**
	 * 
	 * @Title: updateUser 
	 * @Description: 更新用户
	 * @param user
	 * @return
	 * @return: Article
	 */
	@ResponseBody
	@RequestMapping("updateUser")
	public boolean updateUser(User user) {
		return userService.update(user)>0;
	}
	
	/**
	 * 
	 * @Title: articleDetail 
	 * @Description: 单个文章内容
	 * @param id
	 * @return
	 * @return: Article
	 */
	@ResponseBody
	@RequestMapping("articleDetail")
	public Article articleDetail(Integer id) {
		return articleService.select(id);
		
	}
	
	/** 
	 * @Title: articles 
	 * @Description: 进入文章审核列表
	 * @return
	 * @return: String
	 */
	@RequestMapping("articles") 
	public String articles(Model model,Article article,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "18")Integer pageSize) {
		
		PageInfo<Article> info = articleService.selects(article, page, pageSize);
		model.addAttribute("info", info);
		model.addAttribute("article", article);

		return "admin/articles";
		
	}
	
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改
	 * @param article
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@RequestMapping("update")
	public boolean update(Article article) {
		return articleService.update(article)>0;
	}
	 
}
