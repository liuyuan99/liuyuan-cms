package com.liuyuan.cms.dao;

import java.util.List;

import com.liuyuan.cms.domain.Category;
import com.liuyuan.cms.domain.Channel;

public interface ChannelMapper {

	/**
	 * 
	 * @Title: selects 
	 * @Description: 栏目查询
	 * @param channel
	 * @return
	 * @return: List<Channel>
	 */
	List<Channel> selects();

	/**
	 * 
	 * @Title: selectsByChannelId 
	 * @Description: 根据栏目查分类
	 * @param channelId
	 * @return
	 * @return: List<Category>
	 */
	List<Category> selectsByChannelId(Integer channelId);

}
