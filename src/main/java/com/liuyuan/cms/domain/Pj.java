package com.liuyuan.cms.domain;

import java.io.Serializable;

/**
 * 
 * @ClassName: Pj 
 * @Description: 配件表
 * @author: 刘媛
 * @date: 2020年3月17日 上午10:17:08
 */
public class Pj implements Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;	//id
	private String name;	//配件名称
	private String pid;		//配件编号
	private Integer num;	//配件数量
	private String money;	//配件单价
	public Pj(Integer id, String name, String pid, Integer num, String money) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
		this.num = num;
		this.money = money;
	}
	public Pj() {
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
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Pj [id=" + id + ", name=" + name + ", pid=" + pid + ", num=" + num + ", money=" + money + "]";
	}
	
	
}
