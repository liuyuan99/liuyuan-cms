package com.liuyuan.cms.dao;

import java.util.List;

import com.liuyuan.cms.domain.Article;

/**
 * 
 * @ClassName: ArticleMapper 
 * @Description: TODO
 * @author: 刘媛
 * @date: 2020年3月4日 上午8:50:30
 */
public interface ArticleMapper {

	/**
	 * 
	 * @Title: insert 
	 * @Description: 增加文章
	 * @param article
	 * @return
	 * @return: int
	 */
	int insert(Article article);
	
	/**
	 * 
	 * @Title: selects 
	 * @Description: 文章列表
	 * @param article
	 * @return
	 * @return: List<Article>
	 */
	List<Article> selects(Article article);
	
	/**
	 * 
	 * @Title: select 
	 * @Description: 单个文章
	 * @param id
	 * @return
	 * @return: Article
	 */
	Article select(Integer id);
	
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改
	 * @param article
	 * @return
	 * @return: int
	 */
	 int update(Article article);
}
