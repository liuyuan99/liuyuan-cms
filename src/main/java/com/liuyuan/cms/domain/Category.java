package com.liuyuan.cms.domain;

import java.io.Serializable;

/**
 * 
 * @ClassName: Category 
 * @Description: 栏目子类
 * @author: 刘媛
 * @date: 2020年3月3日 上午11:23:48
 */
public class Category implements Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Integer channelId; //所属栏目的ID
	private String sorted; //排序
	
	private Channel channel;  //栏目对象

	public Category(Integer id, String name, Integer channelId, String sorted, Channel channel) {
		super();
		this.id = id;
		this.name = name;
		this.channelId = channelId;
		this.sorted = sorted;
		this.channel = channel;
	}

	
	public Category(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public Category() {
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

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public String getSorted() {
		return sorted;
	}

	public void setSorted(String sorted) {
		this.sorted = sorted;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", channel_id=" + channelId + ", sorted=" + sorted
				+ ", channel=" + channel + "]";
	}
	
	
	
}
