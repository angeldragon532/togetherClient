package com.beijing.together.entity;

import java.io.Serializable;

public class VisitorInfo implements Serializable{
	
	private String name;
	private String imageUrl;
	private String city;
	private String password;
	private String attention;
	private String phone;
	private String email;
	private String education;
	private String doVocation;
	private String position;//职位
	private String company;
	private String visitorDomain;
	private String visitorIdea;
	private String cheifDesc;//主要描述
	private int attented;
	private int collection;
	private String rongyunToken;
	
	
	public VisitorInfo(){};
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAttention() {
		return attention;
	}
	public void setAttention(String attention) {
		this.attention = attention;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getDoVocation() {
		return doVocation;
	}
	public void setDoVocation(String doVocation) {
		this.doVocation = doVocation;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getVisitorDomain() {
		return visitorDomain;
	}
	public void setVisitorDomain(String visitorDomain) {
		this.visitorDomain = visitorDomain;
	}
	public String getVisitorIdea() {
		return visitorIdea;
	}
	public void setVisitorIdea(String visitorIdea) {
		this.visitorIdea = visitorIdea;
	}
	public int getAttented() {
		return attented;
	}
	public void setAttented(int attented) {
		this.attented = attented;
	}
	public int getCollection() {
		return collection;
	}
	public void setCollection(int collection) {
		this.collection = collection;
	}
	public String getCheifDesc() {
		return cheifDesc;
	}

	public void setCheifDesc(String cheifDesc) {
		this.cheifDesc = cheifDesc;
	}
	
	public String getRongyunToken() {
		return rongyunToken;
	}
	public void setRongyunToken(String rongyunToken) {
		this.rongyunToken = rongyunToken;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
