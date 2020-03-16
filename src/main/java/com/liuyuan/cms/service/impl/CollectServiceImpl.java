package com.liuyuan.cms.service.impl;

import java.awt.color.CMMException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuyuan.cms.dao.CollectMapper;
import com.liuyuan.cms.domain.Collect;
import com.liuyuan.cms.service.CollectService;
import com.ly.common.utils.StringUtil;

@Service
public class CollectServiceImpl implements CollectService{

	@Resource
	private CollectMapper collectMapper;

	@Override
	public int insert(Collect collect) throws Exception {
		// TODO Auto-generated method stub
		if(!StringUtil.isHttpUrl(collect.getUrl())) {
			throw new CMMException("不是合法的url");
		}
		return collectMapper.insert(collect);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		
		return collectMapper.delete(id);
	}

	@Override
	public PageInfo<Collect> selects(Integer id, Integer page, Integer pageSize) {
		PageHelper.startPage(page,pageSize);
		
		List<Collect> list = collectMapper.selects(id);
		
		return new PageInfo<Collect>(list);
	}
	
	@Override
	public Collect selectByTitleAndUserId(String title, Integer userId) {
		// TODO Auto-generated method stub
		return collectMapper.selectByTitleAndUserId(title, userId);
	}
	
}
