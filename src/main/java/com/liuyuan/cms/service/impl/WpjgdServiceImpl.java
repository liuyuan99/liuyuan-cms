package com.liuyuan.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuyuan.cms.dao.WpjgdMapper;
import com.liuyuan.cms.domain.Wpjgd;
import com.liuyuan.cms.domain.WpjgdIO;
import com.liuyuan.cms.service.WpjgdService;

@Service
public class WpjgdServiceImpl implements WpjgdService {

	@Resource
	private WpjgdMapper wpjgdMapper;
	
	@Override
	public PageInfo<Wpjgd> selects(WpjgdIO wpjgdio, Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pageSize);
		List<Wpjgd> list = wpjgdMapper.selects(wpjgdio);
		
		return new PageInfo<Wpjgd>(list);
	}

}
