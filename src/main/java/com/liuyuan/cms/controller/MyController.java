package com.liuyuan.cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.liuyuan.cms.domain.Article;
import com.liuyuan.cms.domain.Collect;
import com.liuyuan.cms.domain.User;
import com.liuyuan.cms.service.ArticleService;
import com.liuyuan.cms.service.CollectService;

/**
 * 
 * @ClassName: MyController 
 * @Description:个人中心
 * @author: 刘媛
 * @date: 2020年3月4日 上午10:50:52
 */

@RequestMapping("my")
@Controller
public class MyController {

	@Resource
	private ArticleService articleService;
	
	@Resource
	private CollectService collectService;
	
	/**
	 * 
	 * @Title: index 
	 * @Description: 进入个人中心首页
	 * @return
	 * @return: String
	 */
	//提供三种url映射
	@RequestMapping(value = {"","/","index"})
	public String index() {
		return "my/index";
		
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
	 * 
	 * 
	 * @Title: articles 
	 * @Description:我的文章
	 * @return
	 * @return: String
	 */
	@RequestMapping("articles")
	public String articles(Model model,HttpSession session,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "3")Integer pageSize) {
		Article article = new Article();
		User user = (User) session.getAttribute("user"); //session获取当前登录人的信息
	
		article.setUserId(user.getId()); //只限是当前登录人的文章
		
		PageInfo<Article> info = articleService.selects(article, page, pageSize);
		model.addAttribute("info", info);
		return "my/articles";
	}
	/**
	 * 
	 * 
	 * @Title: publish
	 * @Description:发表文章
	 * @return
	 * @return: String
	 */
	@GetMapping("publish")
	public String publish() {
		return "my/publish";
	}
	
	/**
	 * 
	 * @Title: publish 
	 * @Description: 发布文章
	 * @param file
	 * @param article
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@RequestMapping("publish")
	public boolean publish(MultipartFile file,Article article,HttpSession session) {
		//文件上传
		if(null!=file && !file.isEmpty()) {
			String path = "d:/pic/";
			//文件的原始名称
			String filename = file.getOriginalFilename();
			//为了防止文件重名,需要改变文件的名字
			String newfilename = UUID.randomUUID()+filename.substring(filename.lastIndexOf("."));
			File f = new File(path,newfilename);
			//把文件写入硬盘
			try {
				file.transferTo(f);
				article.setPicture(newfilename);//文件的名称
					
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			//文章初始数据
			User user = (User) session.getAttribute("user");
			article.setUserId(user.getId()); //发布人
			article.setCreated(new Date());
			article.setHits(0);  //点击量默认0
			article.setDeleted(0);	//默认未删除
			article.setHot(0);	//默认非热门
			article.setStatus(0); //默认待审核
		
			return articleService.insert(article)>0;
		
	}
	
	/**
	 * 
	 * 
	 * @Title: articles 
	 * @Description:我的收藏
	 * @return
	 * @return: String
	 */
	@RequestMapping("articles2")
	public String articles2() {
		return "my/articles2";
	}
	/**
	 * 
	 * 
	 * @Title: articles 
	 * @Description:我的评论
	 * @return
	 * @return: String
	 */
	@RequestMapping("articles3")
	public String articles3() {
		return "my/articles3";
	}
	/**
	 * 
	 * 
	 * @Title: articles 
	 * @Description:个人中心
	 * @return
	 * @return: String
	 */
	@RequestMapping("articles4")
	public String articles4() {
		return "my/articles4";
	}
	
	/**
	 * 
	 * @Title: seleController 
	 * @Description: 我的收藏
	 * @param session
	 * @param model
	 * @param page
	 * @param pageSize
	 * @return
	 * @return: String
	 */
	@RequestMapping("collect")
	public String seleController(HttpSession session,Model model,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "5")Integer pageSize) {
		User user = (User) session.getAttribute("user");
		if(user==null) {
			return "redirect:/my";  //session过期
		}
		PageInfo<Collect> info = collectService.selects(user.getId(),page,pageSize);
		
		model.addAttribute("info", info);		
		
		return "my/collect";		
	}
	
	
}
