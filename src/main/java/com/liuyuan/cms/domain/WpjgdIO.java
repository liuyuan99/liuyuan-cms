package com.liuyuan.cms.domain;

import java.util.Date;

public class WpjgdIO extends Wpjgd{
	
	private String llnum1;	//联络单号
	private String zzbid1;	//制造部编号
	private String zzb1;		//制造部
	private String sid1;		//设备编号
	private String sname1;	//设备部
	private String jgdw1;	//加工单位
	private String phpeople1;	//联系人
	private String shpeople1;	//收货人
	private String cgpeople1;	//采购部报销人
	private String other2;		//备注
	private Date bsdate1;	//报送日期
	private Date bsdate2;	//报送日期
	public WpjgdIO(Integer id, String llnum, Date bsdate, String zzb, String zzbid, Integer pname, Pj pj, String pid,
			String price, Integer num, String money, String other, String sid, String sname, Date psdate,
			String shmoney, String shmoneys, String people, String img, String jgdw, String phpeople, String jprice,
			String jmoneys, Date songdate, String shpeople, String cgpeople, String other1, String llnum1,
			String zzbid1, String zzb1, String sid1, String sname1, String jgdw1, String phpeople1, String shpeople1,
			String cgpeople1, String other2, Date bsdate1,Date bsdate2) {
		super(id, llnum, bsdate, zzb, zzbid, pname, pj, pid, price, num, money, other, sid, sname, psdate, shmoney,
				shmoneys, people, img, jgdw, phpeople, jprice, jmoneys, songdate, shpeople, cgpeople, other1);
		this.llnum1 = llnum1;
		this.zzbid1 = zzbid1;
		this.zzb1 = zzb1;
		this.sid1 = sid1;
		this.sname1 = sname1;
		this.jgdw1 = jgdw1;
		this.phpeople1 = phpeople1;
		this.shpeople1 = shpeople1;
		this.cgpeople1 = cgpeople1;
		this.other2 = other2;
		this.bsdate1 = bsdate1;
		this.bsdate2 = bsdate2;
	}
	public WpjgdIO() {
		super();
	}
	public String getLlnum1() {
		return llnum1;
	}
	public void setLlnum1(String llnum1) {
		this.llnum1 = llnum1;
	}
	public String getZzbid1() {
		return zzbid1;
	}
	public void setZzbid1(String zzbid1) {
		this.zzbid1 = zzbid1;
	}
	public String getZzb1() {
		return zzb1;
	}
	public void setZzb1(String zzb1) {
		this.zzb1 = zzb1;
	}
	public String getSid1() {
		return sid1;
	}
	public void setSid1(String sid1) {
		this.sid1 = sid1;
	}
	public String getSname1() {
		return sname1;
	}
	public void setSname1(String sname1) {
		this.sname1 = sname1;
	}
	public String getJgdw1() {
		return jgdw1;
	}
	public void setJgdw1(String jgdw1) {
		this.jgdw1 = jgdw1;
	}
	public String getPhpeople1() {
		return phpeople1;
	}
	public void setPhpeople1(String phpeople1) {
		this.phpeople1 = phpeople1;
	}
	public String getShpeople1() {
		return shpeople1;
	}
	public void setShpeople1(String shpeople1) {
		this.shpeople1 = shpeople1;
	}
	public String getCgpeople1() {
		return cgpeople1;
	}
	public void setCgpeople1(String cgpeople1) {
		this.cgpeople1 = cgpeople1;
	}
	public String getOther2() {
		return other2;
	}
	public void setOther2(String other2) {
		this.other2 = other2;
	}
	public Date getBsdate1() {
		return bsdate1;
	}
	public void setBsdate1(Date bsdate1) {
		this.bsdate1 = bsdate1;
	}
	
	public Date getBsdate2() {
		return bsdate2;
	}
	public void setBsdate2(Date bsdate2) {
		this.bsdate2 = bsdate2;
	}
	@Override
	public String toString() {
		return "WpjgdIO [llnum1=" + llnum1 + ", zzbid1=" + zzbid1 + ", zzb1=" + zzb1 + ", sid1=" + sid1 + ", sname1="
				+ sname1 + ", jgdw1=" + jgdw1 + ", phpeople1=" + phpeople1 + ", shpeople1=" + shpeople1 + ", cgpeople1="
				+ cgpeople1 + ", other2=" + other2 + ", bsdate1=" + bsdate1 + "]";
	}

	
}
