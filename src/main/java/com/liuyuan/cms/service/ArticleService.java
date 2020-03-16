package com.liuyuan.cms.service;



import com.github.pagehelper.PageInfo;
import com.liuyuan.cms.domain.Article;

public interface ArticleService {

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
	PageInfo<Article> selects(Article article,Integer page,Integer pgeSize);
	

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
	 * @Description: 修改更新
	 * @param article
	 * @return
	 * @return: int
	 */
	 int update(Article article);
}
