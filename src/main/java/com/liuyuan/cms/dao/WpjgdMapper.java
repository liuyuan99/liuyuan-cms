package com.liuyuan.cms.dao;

import java.util.List;

import com.liuyuan.cms.domain.Wpjgd;
import com.liuyuan.cms.domain.WpjgdIO;

public interface WpjgdMapper {

	/**
	 * 
	 * @Title: selects 
	 * @Description: 加工单列表
	 * @param wpjgd
	 * @return
	 * @return: List<WpjgdMapper>
	 */
	List<Wpjgd> selects(WpjgdIO wpjgdio);
}
