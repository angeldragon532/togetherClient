package com.beijing.together.entity;

import java.io.Serializable;

public class ActivityInfo implements Serializable{

	private String imgUrl;
	private String name;
	private String status;
	private String cheifer;
	private String startTime;
	private String endTime;
	private String address;
	private String tarkNum;
	private String detail;
	private String attetion;
	
	public String getAttetion() {
		return attetion;
	}
	public void setAttetion(String attetion) {
		this.attetion = attetion;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCheifer() {
		return cheifer;
	}
	public void setCheifer(String cheifer) {
		this.cheifer = cheifer;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTarkNum() {
		return tarkNum;
	}
	public void setTarkNum(String tarkNum) {
		this.tarkNum = tarkNum;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}
