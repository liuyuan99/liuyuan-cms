package com.liuyuan.cms.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @ClassName: Comment 
 * @Description: 评论表
 * @author: 刘媛
 * @date: 2020年3月13日 下午10:49:47
 */
public class Comment implements Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;			//id
	private Integer userId;		//用户
	private Integer	articleId;	//广告
	private String content;		//评论
	private Date created;		//评论时间
	
	private User user;  //评论人
	private Article article;//评论文章
	public Comment(Integer id, Integer userId, Integer articleId, String content, Date created, User user,
			Article article) {
		super();
		this.id = id;
		this.userId = userId;
		this.articleId = articleId;
		this.content = content;
		this.created = created;
		this.user = user;
		this.article = article;
	}
	public Comment() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", userId=" + userId + ", articleId=" + articleId + ", content=" + content
				+ ", created=" + created + ", user=" + user + ", article=" + article + "]";
	}
	
	
	
}
