package com.liuyuan.cms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuyuan.cms.domain.Category;
import com.liuyuan.cms.domain.Channel;
import com.liuyuan.cms.service.ChannelService;

/**
 * 
 * @ClassName: ChannelController 
 * @Description: 栏目的控制器
 * @author: 刘媛
 * @date: 2020年3月5日 上午10:10:36
 */

@Controller
@RequestMapping("channel")
public class ChannelController {

	@Resource
	ChannelService channelService;
	
	/**
	 * 
	 * @Title: channels 
	 * @Description: 查询所有栏目
	 * @return
	 * @return: List<Channel>
	 */
	@ResponseBody
	@RequestMapping("channels")
	public List<Channel> channels(){
		return channelService.selects();
	}
	
	/**
	 * 
	 * 
	 * @Title: selectsByChannelId 
	 * @Description: 根据栏目查询分类
	 * @param channelId
	 * @return
	 * @return: List<Category>
	 */
	@ResponseBody
	@RequestMapping("selectsByChannelId")
	public List<Category> selectsByChannelId(Integer channelId){
		return channelService.selectsByChannelId(channelId);
	}
	
}
