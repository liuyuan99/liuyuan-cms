package com.liuyuan.cms.service;

import com.github.pagehelper.PageInfo;
import com.liuyuan.cms.domain.Article;
import com.liuyuan.cms.domain.Comment;

public interface CommentService {

	/**
	 * 
	 * @Title: insert 
	 * @Description: 增加评论
	 * @param comment
	 * @return
	 * @return: int
	 */
	int insert(Comment comment);
	
	/**
	 * 
	 * @Title: selects 
	 * @Description: 按照评论数量排序
	 * @return
	 * @return: List<Article>
	 */
	PageInfo<Article> selectsByCommentNum(Integer page, Integer pageSize);

	/**
	 * 
	 * @Title: selects 
	 * @Description: 根据文章查询评论
	 * @return
	 * @return: List<Comment>
	 */
	PageInfo<Comment> selects(Article article, Integer page, Integer pageSize);


	/**
	 * 
	 * @Title: updateArticle 
	 * @Description: 评论数增加1
	 * @param articleId
	 * @return
	 * @return: int
	 */
	int updateArticle(Integer articleId);

}
