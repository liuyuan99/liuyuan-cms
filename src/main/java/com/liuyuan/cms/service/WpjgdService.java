package com.liuyuan.cms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.liuyuan.cms.dao.WpjgdMapper;
import com.liuyuan.cms.domain.Wpjgd;
import com.liuyuan.cms.domain.WpjgdIO;

public interface WpjgdService {

	/**
	 * 
	 * @Title: selects 
	 * @Description: 加工单列表
	 * @param wpjgd
	 * @return
	 * @return: List<WpjgdMapper>
	 */
	PageInfo<Wpjgd> selects(WpjgdIO wpjgdio,@Param("page")Integer page,@Param("pageSize")Integer pageSize);

}
