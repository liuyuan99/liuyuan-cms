package com.liuyuan.cms.service;

import java.util.List;

import com.liuyuan.cms.domain.Vote;

public interface VoteService {
	
	int insert(Vote vote);
	/**
	 * 
	 * @Title: select 
	 * @Description: 查询某个文章的投票情况
	 * @param articleId
	 * @return
	 * @return: Vote
	 */
	List<Vote> selects(Integer articleId);
	
	/**
	 * 
	 * @Title: select 
	 * @Description:  查查用户是否重复投票
	 * @param vote
	 * @return
	 * @return: Vote
	 */
	Vote select(Vote vote);
}
