package com.liuyuan.cms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.liuyuan.cms.domain.Wpjgd;
import com.liuyuan.cms.domain.WpjgdIO;
import com.liuyuan.cms.service.WpjgdService;

@Controller
public class WpjgdController {

	@Resource
	private WpjgdService service;
	
	@RequestMapping("pj")
	public String selects(Model model,WpjgdIO wpjgdio,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "3")Integer pageSize) {
		PageInfo<Wpjgd> info  = service.selects(wpjgdio, pageSize, pageSize);
		model.addAttribute("wpjgdio", wpjgdio);
		model.addAttribute("info", info);
		return "pj/selects";
	}	
}
