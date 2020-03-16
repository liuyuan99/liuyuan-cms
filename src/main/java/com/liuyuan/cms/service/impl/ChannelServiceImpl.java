package com.liuyuan.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liuyuan.cms.dao.ChannelMapper;
import com.liuyuan.cms.domain.Category;
import com.liuyuan.cms.domain.Channel;
import com.liuyuan.cms.service.ChannelService;

@Service
public class ChannelServiceImpl implements ChannelService {

	@Resource
	private ChannelMapper channelMapper;

	@Override
	public List<Channel> selects() {
		// TODO Auto-generated method stub
		return channelMapper.selects();
	}

	@Override
	public List<Category> selectsByChannelId(Integer channelId) {
		// TODO Auto-generated method stub
		return channelMapper.selectsByChannelId(channelId);
	}

	
	
	


}
