package com.liuyuan.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuyuan.cms.dao.CommentMapper;
import com.liuyuan.cms.domain.Article;
import com.liuyuan.cms.domain.Comment;
import com.liuyuan.cms.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Resource
	private CommentMapper commentMapper;

	@Override
	public int insert(Comment comment) {
		// TODO Auto-generated method stub
		try {
			//增加评论
			commentMapper.insert(comment);
			//让文章评论数量+1
			commentMapper.updateArticle(comment.getArticleId());
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public PageInfo<Comment> selects(Article article, Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page,pageSize);
		List<Comment> list = commentMapper.selects(article);
		PageInfo<Comment> info = new PageInfo<Comment>(list);
		return info;
	}

	@Override
	public PageInfo<Article> selectsByCommentNum(Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page,pageSize);
		List<Article> list = commentMapper.selectsByCommentNum();
		return new PageInfo<Article>(list);
	}

	@Override
	public int updateArticle(Integer articleId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
