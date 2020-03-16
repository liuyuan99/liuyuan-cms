package com.liuyuan.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liuyuan.cms.dao.SlideMapper;
import com.liuyuan.cms.domain.Slide;
import com.liuyuan.cms.service.SlideService;

@Service
public class SlideServiceimpl implements SlideService{

	@Resource
	SlideMapper slideMapper;
	@Override
	public List<Slide> selects() {
		// TODO Auto-generated method stub
		return slideMapper.selects();
	}

}
