package com.beijing.together.entity;

import java.io.Serializable;

public class UserInfo implements Serializable{
	
	public static String FOUNDER_USER = "0";
	public static String PARTNER_USER = "1";
	public static String VISITOR_USER = "2";
	
	private String name;
	private String nikeName;
	private String imageUrl;
	private String password;
	private String city;
	private String currentStatus;
	private String redirect;
	private String attention;
	private String phone;
	private String email;
	private String keepMoney;
	private String outputMoney;
	private String wishOption;//期望保障
	private String works;
	private String education;
	private String doVocation;
	private String position;//职位
	private String workTime;
	private String skill;
	private String desc;
	private int personIndex;
	private int attented;
	private int collection;
	private String rongyunToken;
	
	private int userRole;//0 发起人 1合伙人
	private Project project;//发起人有项目
	
	public int getUserRole() {
		return userRole;
	}
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
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
	public String getWorkTime() {
		return workTime;
	}
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public int getPersonIndex() {
		return personIndex;
	}
	public void setPersonIndex(int personIndex) {
		this.personIndex = personIndex;
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
	public UserInfo() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNikeName() {
		return nikeName;
	}
	public void setNikeName(String nikeName) {
		this.nikeName = nikeName;
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
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public String getRedirect() {
		return redirect;
	}
	public void setRedirect(String redirect) {
		this.redirect = redirect;
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
	public String getKeepMoney() {
		return keepMoney;
	}
	public void setKeepMoney(String keepMoney) {
		this.keepMoney = keepMoney;
	}
	public String getOutputMoney() {
		return outputMoney;
	}
	public void setOutputMoney(String outputMoney) {
		this.outputMoney = outputMoney;
	}
	public String getWorks() {
		return works;
	}
	public void setWorks(String works) {
		this.works = works;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getWishOption() {
		return wishOption;
	}
	public void setWishOption(String wishOption) {
		this.wishOption = wishOption;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
