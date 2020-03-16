package com.liuyuan.cms.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.liuyuan.cms.domain.Article;
import com.liuyuan.cms.domain.Category;
import com.liuyuan.cms.domain.Channel;
import com.liuyuan.cms.domain.Collect;
import com.liuyuan.cms.domain.Comment;
import com.liuyuan.cms.domain.ContentType;
import com.liuyuan.cms.domain.Slide;
import com.liuyuan.cms.domain.User;
import com.liuyuan.cms.domain.Vote;
import com.liuyuan.cms.service.ArticleService;
import com.liuyuan.cms.service.ChannelService;
import com.liuyuan.cms.service.CollectService;
import com.liuyuan.cms.service.CommentService;
import com.liuyuan.cms.service.SlideService;
import com.liuyuan.cms.service.VoteService;
import com.ly.common.utils.NumberUtil;

/**
 * 
 * @ClassName: IndexController 
 * @Description: 系统首页入口
 * @author: 刘媛
 * @date: 2020年3月9日 上午11:21:29
 */
@Controller
public class IndexController {

	@Resource
	private ChannelService channelService;
	
	@Resource
	private ArticleService articleService;
	
	@Resource
	private SlideService slideService;
	
	@Resource
	private CommentService commentService;
	
	@Resource
	private CollectService collectService;
	
	@Resource
	private VoteService voteService;
	
	@RequestMapping(value = {"","/","index"})
	public String index(Model model,Article article,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "3")Integer pageSize) {
		article.setStatus(1);	//只显示审核过的文章
		article.setDeleted(0); //只显示为未删除
		model.addAttribute("article", article);
		//查询左侧栏目
		List<Channel> channels = channelService.selects();
		model.addAttribute("channels", channels);
		//如果栏目ID 不为空则查查其下所有的分类
		if(article.getChannelId()!=null) {
		List<Category> categorys = channelService.selectsByChannelId(article.getChannelId());
		model.addAttribute("categorys", categorys);
		}		
		//如果栏目为空,说明没有点击栏目
		if(article.getChannelId()==null) {
			article.setHot(1);
			//轮播图
			List<Slide> slides = slideService.selects();
			model.addAttribute("slides", slides);
		}
		
		//查询所有的文章
		PageInfo<Article> info = articleService.selects(article, page, pageSize);
		model.addAttribute("info", info);

		//在右侧显示10篇文章
		Article article2 = new Article();
		article2.setStatus(1);
		article2.setDeleted(0);
		PageInfo<Article> lastArticles = articleService.selects(article2,1,10);
		model.addAttribute("lastArticles", lastArticles);

		// 问卷调查
		Article voteArticle = new Article();
		voteArticle.setStatus(1);//
		voteArticle.setDeleted(0);
		voteArticle.setContentType(ContentType.VOTE);
		
		PageInfo<Article> voteArticles = articleService.selects(voteArticle, 1, 10);
		model.addAttribute("voteArticles", voteArticles);
		
		return "index/index";
	}
	
	/**
	 * 
	 * @Title: articleDetail 
	 * @Description: 文章详情
	 * @param id
	 * @return
	 * @return: String
	 */
	@RequestMapping("articleDetail")
	public String articleDetail(HttpSession session,Integer id,Model model,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "18")Integer pageSize) {
		Article article = articleService.select(id);
		model.addAttribute("article", article);
		//查询出当前文章的评论信息
		PageInfo<Comment> info = commentService.selects(article, page, pageSize);
		//查询所有文章的评论
		PageInfo<Article> info2 = commentService.selectsByCommentNum(1, 10);
		model.addAttribute("info", info);
		model.addAttribute("info2", info2);
		
		//查询是否被收藏
		User user = (User) session.getAttribute("user");
		Collect collect=null;
		if(user!=null) {  //如果用户已经登陆，返回是都被收藏过
			collect = collectService.selectByTitleAndUserId(article.getTitle(),user.getId());
		}
		model.addAttribute("collect", collect);
		return "index/articleDetail";
		
	}
	
	/**
	 * 
	 * @Title: articleDetail 
	 * @Description: 投票详情
	 * @param session
	 * @param id
	 * @param model
	 * @return
	 * @return: String
	 */
	@RequestMapping("voteDetail")
	public String voteDetail(HttpSession session ,Integer id,Model model) {
		Article article = articleService.select(id);
		String content = article.getContent();
		Gson gson =new Gson();
		LinkedHashMap<Character,String> mapVote = gson.fromJson(content, LinkedHashMap.class);
	
		
		model.addAttribute("mapVote", mapVote);
		model.addAttribute("article", article);
		
		//查询出投票情况
		
		List<Vote> votes = voteService.selects(article.getId());
		for (Vote vote : votes) {
			//获取选项的值并重新封装到vote
			vote.setOption(mapVote.get(vote.getOption()));
			//计算百分比
			vote.setPercent(new BigDecimal(NumberUtil.getPercent(vote.getOptionNum(), vote.getTotalNum())));
		}
		model.addAttribute("votes", votes);
		return "index/voteDetail";
		
	}
	
	
	//投票
	@ResponseBody
	@PostMapping("addVote")
	public boolean addVote(Vote vote ,HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(null ==user)
		return false;//没有登录的用户不能收藏
		vote.setUserId(user.getId());
		//检查用户是否已经投过票
		if(voteService.select(vote)!=null)
			return false;
	
		
		return voteService.insert(vote) >0;
	}
	
	//增加评论
	@ResponseBody
	@RequestMapping("addComment")
	public boolean addComment(Comment comment,Integer articleId,HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user==null) {
			return false;  //没有登陆不能评论
		}
		comment.setUserId(user.getId());		//用户名
		comment.setArticleId(articleId);		//评论
		comment.setCreated(new Date());			//评论时间
		return commentService.insert(comment)>0;
	}
	
	//收藏文章
	@ResponseBody
	@RequestMapping("collect")
	public boolean collect(Collect collect,HttpSession session) throws Exception {
		User user = (User) session.getAttribute("user");
		if(user==null) {
			return false;  //没有登陆不能收藏
		}
		collect.setUser(user);		//收藏人
		collect.setCreated(new Date());	//收藏时间
		return collectService.insert(collect)>0;
	}
	
	//取消收藏文章
	@ResponseBody
	@RequestMapping("deleteCollect")
	public boolean deleteCollect(Integer id) {
		return collectService.delete(id)>0;
	}
	
	
}
