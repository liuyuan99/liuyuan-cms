package com.liuyuan.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @ClassName: BootController 
 * @Description: bootstrap入门
 * @author: 刘媛
 * @date: 2020年3月4日 上午10:51:05
 */
@Controller
public class BootController {
	
	@RequestMapping("boorstrap")
	public String boorstrap() {
		return "boorstrap";
	}
	
	@RequestMapping("boorstrap3")
	public String boorstrap3() {
		return "boorstrap3";
	}
}
