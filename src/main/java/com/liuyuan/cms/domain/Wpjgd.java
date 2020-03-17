package com.liuyuan.cms.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: Wpjgd 
 * @Description: 外派加工单
 * @author: 刘媛
 * @date: 2020年3月17日 上午10:18:20
 */
public class Wpjgd implements Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;		//id
	private String llnum;	//联络单号
	private Date bsdate;	//报送日期
	private String zzb;		//制造部
	private String zzbid;	//制造部编号
	private Integer pname;		//配件名称
	private Pj pj;				//外键
	private String pid;		//配件编号
	private String price;	//参考单价
	private Integer num;	//数量
	private String money;	//金额
	private String other;	//具体设备要求
	private String sid;		//设备编号
	private String sname;	//设备部
	private Date psdate;	//配件外送时间
	private String shmoney;	//审核单价
	private String shmoneys;	//审核金额
	
	private String people;	//发货人
	private String img;		//加工检验图片
	private String jgdw;	//加工单位
	private String phpeople;	//联系人
	private String jprice;	//加共单价
	private String jmoneys;	//加工单位金额
	private Date songdate;	//配件送回时间
	private String shpeople;	//收货人
	private String cgpeople;	//采购部报销人
	private String other1;		//备注
	public Wpjgd(Integer id, String llnum, Date bsdate, String zzb, String zzbid, Integer pname, Pj pj, String pid,
			String price, Integer num, String money, String other, String sid, String sname, Date psdate,
			String shmoney, String shmoneys, String people, String img, String jgdw, String phpeople, String jprice,
			String jmoneys, Date songdate, String shpeople, String cgpeople, String other1) {
		super();
		this.id = id;
		this.llnum = llnum;
		this.bsdate = bsdate;
		this.zzb = zzb;
		this.zzbid = zzbid;
		this.pname = pname;
		this.pj = pj;
		this.pid = pid;
		this.price = price;
		this.num = num;
		this.money = money;
		this.other = other;
		this.sid = sid;
		this.sname = sname;
		this.psdate = psdate;
		this.shmoney = shmoney;
		this.shmoneys = shmoneys;
		this.people = people;
		this.img = img;
		this.jgdw = jgdw;
		this.phpeople = phpeople;
		this.jprice = jprice;
		this.jmoneys = jmoneys;
		this.songdate = songdate;
		this.shpeople = shpeople;
		this.cgpeople = cgpeople;
		this.other1 = other1;
	}
	public Wpjgd() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLlnum() {
		return llnum;
	}
	public void setLlnum(String llnum) {
		this.llnum = llnum;
	}
	public Date getBsdate() {
		return bsdate;
	}
	public void setBsdate(Date bsdate) {
		this.bsdate = bsdate;
	}
	public String getZzb() {
		return zzb;
	}
	public void setZzb(String zzb) {
		this.zzb = zzb;
	}
	public String getZzbid() {
		return zzbid;
	}
	public void setZzbid(String zzbid) {
		this.zzbid = zzbid;
	}
	public Integer getPname() {
		return pname;
	}
	public void setPname(Integer pname) {
		this.pname = pname;
	}
	public Pj getPj() {
		return pj;
	}
	public void setPj(Pj pj) {
		this.pj = pj;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
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
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Date getPsdate() {
		return psdate;
	}
	public void setPsdate(Date psdate) {
		this.psdate = psdate;
	}
	public String getShmoney() {
		return shmoney;
	}
	public void setShmoney(String shmoney) {
		this.shmoney = shmoney;
	}
	public String getShmoneys() {
		return shmoneys;
	}
	public void setShmoneys(String shmoneys) {
		this.shmoneys = shmoneys;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getJgdw() {
		return jgdw;
	}
	public void setJgdw(String jgdw) {
		this.jgdw = jgdw;
	}
	public String getPhpeople() {
		return phpeople;
	}
	public void setPhpeople(String phpeople) {
		this.phpeople = phpeople;
	}
	public String getJprice() {
		return jprice;
	}
	public void setJprice(String jprice) {
		this.jprice = jprice;
	}
	public String getJmoneys() {
		return jmoneys;
	}
	public void setJmoneys(String jmoneys) {
		this.jmoneys = jmoneys;
	}
	public Date getSongdate() {
		return songdate;
	}
	public void setSongdate(Date songdate) {
		this.songdate = songdate;
	}
	public String getShpeople() {
		return shpeople;
	}
	public void setShpeople(String shpeople) {
		this.shpeople = shpeople;
	}
	public String getCgpeople() {
		return cgpeople;
	}
	public void setCgpeople(String cgpeople) {
		this.cgpeople = cgpeople;
	}
	public String getOther1() {
		return other1;
	}
	public void setOther1(String other1) {
		this.other1 = other1;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Wpjgd [id=" + id + ", llnum=" + llnum + ", bsdate=" + bsdate + ", zzb=" + zzb + ", zzbid=" + zzbid
				+ ", pname=" + pname + ", pj=" + pj + ", pid=" + pid + ", price=" + price + ", num=" + num + ", money="
				+ money + ", other=" + other + ", sid=" + sid + ", sname=" + sname + ", psdate=" + psdate + ", shmoney="
				+ shmoney + ", shmoneys=" + shmoneys + ", people=" + people + ", img=" + img + ", jgdw=" + jgdw
				+ ", phpeople=" + phpeople + ", jprice=" + jprice + ", jmoneys=" + jmoneys + ", songdate=" + songdate
				+ ", shpeople=" + shpeople + ", cgpeople=" + cgpeople + ", other1=" + other1 + "]";
	}
	
	
	
	
}
