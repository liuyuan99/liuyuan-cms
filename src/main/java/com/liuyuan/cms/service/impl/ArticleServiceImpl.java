package com.liuyuan.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuyuan.cms.dao.ArticleMapper;
import com.liuyuan.cms.domain.Article;
import com.liuyuan.cms.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Resource
	private ArticleMapper articleMapper;
	
	@Override
	public int insert(Article article) {
		return articleMapper.insert(article);
	}

	@Override
	public PageInfo<Article> selects(Article article,Integer page,Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		List<Article> list = articleMapper.selects(article);
		return new PageInfo<Article>(list);
	}

	@Override
	public Article select(Integer id) {
		// TODO Auto-generated method stub
		return articleMapper.select(id);
	}

	@Override
	public int update(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.update(article);
	}



}
