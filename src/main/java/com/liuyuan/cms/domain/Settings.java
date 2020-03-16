package com.liuyuan.cms.domain;

import java.io.Serializable;

/**
 * 
 * @ClassName: Settings 
 * @Description: 系统配置表
 * @author: 刘媛
 * @date: 2020年3月3日 上午11:40:25
 */
public class Settings implements Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String siteDomain;	//网站域名
	private String siteName;	//网站名称
	private String article_list_size;	//文章每页显示的条目
	private String slide_size;		//显示多少个广告
	private String adminUsername;
	private String admin_password;
	public Settings(Integer id, String siteDomain, String siteName, String article_list_size, String slide_size,
			String adminUsername, String admin_password) {
		super();
		this.id = id;
		this.siteDomain = siteDomain;
		this.siteName = siteName;
		this.article_list_size = article_list_size;
		this.slide_size = slide_size;
		this.adminUsername = adminUsername;
		this.admin_password = admin_password;
	}
			
	public Settings(Integer id, String siteDomain) {
		super();
		this.id = id;
		this.siteDomain = siteDomain;
	}

	public Settings() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSiteDomain() {
		return siteDomain;
	}
	public void setSiteDomain(String siteDomain) {
		this.siteDomain = siteDomain;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getArticle_list_size() {
		return article_list_size;
	}
	public void setArticle_list_size(String article_list_size) {
		this.article_list_size = article_list_size;
	}
	public String getSlide_size() {
		return slide_size;
	}
	public void setSlide_size(String slide_size) {
		this.slide_size = slide_size;
	}
	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	@Override
	public String toString() {
		return "Settings [id=" + id + ", siteDomain=" + siteDomain + ", siteName=" + siteName + ", article_list_size="
				+ article_list_size + ", slide_size=" + slide_size + ", adminUsername=" + adminUsername
				+ ", admin_password=" + admin_password + "]";
	}
	
	
}
