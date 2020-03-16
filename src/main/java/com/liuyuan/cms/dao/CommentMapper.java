package com.liuyuan.cms.dao;

import java.util.List;

import com.liuyuan.cms.domain.Article;
import com.liuyuan.cms.domain.Comment;

public interface CommentMapper {

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
	 * @Description: 根据文章查询评论
	 * @return
	 * @return: List<Comment>
	 */
	List<Comment> selects(Article article);

	/**
	 * 
	 * @Title: selects 
	 * @Description: 按照评论数量排序
	 * @return
	 * @return: List<Article>
	 */
	List<Article> selectsByCommentNum();

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
