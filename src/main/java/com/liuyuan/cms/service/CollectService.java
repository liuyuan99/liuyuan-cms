package com.liuyuan.cms.service;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.liuyuan.cms.domain.Collect;

public interface CollectService {
	/**
	 * 
	 * @Title: insert 
	 * @Description: 收藏
	 * @param collect
	 * @return
	 * @return: int
	 * @throws Exception 
	 */
	int insert(Collect collect) throws Exception;
	
	/**
	 * 
	 * @Title: delete 
	 * @Description: 取消收藏
	 * @param id
	 * @return
	 * @return: int
	 */
	int delete(Integer id);
	
	/**
	 * 
	 * @Title: selects 
	 * @Description: 显示我的收藏夹
	 * @param userId
	 * @return
	 * @return: List<Collect>
	 */
	PageInfo<Collect> selects(Integer id, Integer page, Integer pageSize);

	/**
	 * 
	 * @Title: selectByTitleAndUserId 
	 * @Description: 检查文章是否收藏过
	 * @param title
	 * @param userId
	 * @return
	 * @return: Collect
	 */
	Collect selectByTitleAndUserId(@Param("title")String title,@Param("userId")Integer userId);

	
	
}