package com.liuyuan.cms.domain;

import java.io.Serializable;

/**
 * 
 * @ClassName: Channel 
 * @Description: 栏目
 * @author: 刘媛
 * @date: 2020年3月3日 上午11:25:38
 */
public class Channel implements Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String description; //栏目说明
	private String icon; //栏目图标
	private Integer sorted; //排序
	public Channel(Integer id, String name, String description, String icon, Integer sorted) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.icon = icon;
		this.sorted = sorted;
	}
	
	public Channel(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Channel() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String geticon() {
		return icon;
	}
	public void seticon(String icon) {
		this.icon = icon;
	}
	public Integer getSorted() {
		return sorted;
	}
	public void setSorted(Integer sorted) {
		this.sorted = sorted;
	}
	@Override
	public String toString() {
		return "Channel [id=" + id + ", name=" + name + ", description=" + description + ", icon=" + icon + ", sorted="
				+ sorted + "]";
	}
	
	
}
