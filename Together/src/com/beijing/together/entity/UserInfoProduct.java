package com.beijing.together.entity;

import java.util.ArrayList;

public class UserInfoProduct {
	
	
	public static ArrayList<UserInfo> productList(int num){
		ArrayList<UserInfo> list = new ArrayList<UserInfo>();
		for(int i=1;i<=num;i++){
			UserInfo userinfo = new UserInfo();
			userinfo.setAttented(i*13);
			userinfo.setAttention("移动互联网  金融");
			userinfo.setCity("天津");
			userinfo.setCollection(i*15);
			userinfo.setCurrentStatus("兼职");
			userinfo.setDoVocation("金融 电信");
			userinfo.setEducation("本科 清华");
			userinfo.setEmail("sdfsd@163.com");
			userinfo.setKeepMoney("一年");
			userinfo.setName("陈龙");
			userinfo.setNikeName("龙龙");
			userinfo.setOutputMoney("一百万");
			userinfo.setWorkTime("四年");
			userinfo.setWorks("巴士在线");
			userinfo.setSkill("JAVA HTML");
			userinfo.setRedirect("移动物联网,金融");
			userinfo.setPosition("工程师");
			userinfo.setPhone("133431323");
			userinfo.setPersonIndex(i%5);
			list.add(userinfo);
		}
		return list;
	}
}
