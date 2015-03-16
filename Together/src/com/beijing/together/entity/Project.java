package com.beijing.together.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Project  implements Serializable{
	
	private String imageUrl;
	
	private String projectName;
	
	private boolean income;
	
	private String redirect;
	
	private String projectDec;
	
	private int pre_finance;
	
	private int had_finance;
	
	private int overPlusTime;//剩余时间 单位天
	
	private int memeberIndex;//团队综合指数
	
	private int messageNum;
	
	private int collection;//收藏
	
	private int attention;//关注
	
	private boolean isOnline;
	
	private String city;
	
	private String needPartner;//需要的拍档
	
	private ArrayList<ProjectPartnerInfo> partnerList;//合伙人列表
	
	private String finaceStatus;
	
	private String runStatus;
	
	private String developTime;//发展阶段
	
	private String userCase;
	
	private String marketCheck;
	
	private String projectadvantage;
	
	private String businessModel;
	
	private String developerPlan;
	
	
	public String getDevelopTime() {
		return developTime;
	}

	public void setDevelopTime(String developTime) {
		this.developTime = developTime;
	}

	public String getRunStatus() {
		return runStatus;
	}

	public void setRunStatus(String runStatus) {
		this.runStatus = runStatus;
	}

	public String getFinaceStatus() {
		return finaceStatus;
	}

	public void setFinaceStatus(String finaceStatus) {
		this.finaceStatus = finaceStatus;
	}

	public ArrayList<ProjectPartnerInfo> getPartnerList() {
		return partnerList;
	}

	public void setPartnerList(ArrayList<ProjectPartnerInfo> partnerList) {
		this.partnerList = partnerList;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	private String onLineTime;//上线时间

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public boolean isIncome() {
		return income;
	}

	public void setIncome(boolean income) {
		this.income = income;
	}

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

	public String getProjectDec() {
		return projectDec;
	}

	public void setProjectDec(String projectDec) {
		this.projectDec = projectDec;
	}

	public int getPre_finance() {
		return pre_finance;
	}

	public void setPre_finance(int pre_finance) {
		this.pre_finance = pre_finance;
	}

	public int getHad_finance() {
		return had_finance;
	}

	public void setHad_finance(int had_finance) {
		this.had_finance = had_finance;
	}

	public int getOverPlusTime() {
		return overPlusTime;
	}

	public void setOverPlusTime(int overPlusTime) {
		this.overPlusTime = overPlusTime;
	}

	public int getMemeberIndex() {
		return memeberIndex;
	}

	public void setMemeberIndex(int memeberIndex) {
		this.memeberIndex = memeberIndex;
	}

	public int getMessageNum() {
		return messageNum;
	}

	public void setMessageNum(int messageNum) {
		this.messageNum = messageNum;
	}

	public int getCollection() {
		return collection;
	}

	public void setCollection(int collection) {
		this.collection = collection;
	}

	public int getAttention() {
		return attention;
	}

	public void setAttention(int attention) {
		this.attention = attention;
	}

	public String getOnLineTime() {
		return onLineTime;
	}

	public void setOnLineTime(String onLineTime) {
		this.onLineTime = onLineTime;
	}
	
	public boolean isOnline() {
		return isOnline;
	}

	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	
	public String getNeedPartner() {
		return needPartner;
	}

	public void setNeedPartner(String needPartner) {
		this.needPartner = needPartner;
	}
	
	public String getUserCase() {
		return userCase;
	}

	public void setUserCase(String userCase) {
		this.userCase = userCase;
	}

	public String getMarketCheck() {
		return marketCheck;
	}

	public void setMarketCheck(String marketCheck) {
		this.marketCheck = marketCheck;
	}

	public String getProjectadvantage() {
		return projectadvantage;
	}

	public void setProjectadvantage(String projectadvantage) {
		this.projectadvantage = projectadvantage;
	}

	public String getBusinessModel() {
		return businessModel;
	}

	public void setBusinessModel(String businessModel) {
		this.businessModel = businessModel;
	}

	public String getDeveloperPlan() {
		return developerPlan;
	}

	public void setDeveloperPlan(String developerPlan) {
		this.developerPlan = developerPlan;
	}
}
