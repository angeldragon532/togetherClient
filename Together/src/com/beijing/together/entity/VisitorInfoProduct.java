package com.beijing.together.entity;

import java.util.ArrayList;

public class VisitorInfoProduct {
	
	
	public static ArrayList<VisitorInfo> productList(int num){
		ArrayList<VisitorInfo> list = new ArrayList<VisitorInfo>();
		for(int i=1;i<=num;i++){
			VisitorInfo userinfo = new VisitorInfo();
			userinfo.setAttented(i*13);
			userinfo.setAttention("移动互联网  金融");
			userinfo.setCompany("移动融创");
			userinfo.setPosition("CEO CFO COO");
			userinfo.setVisitorDomain("移动金融 医疗   游戏  社交");
			userinfo.setVisitorIdea("一看优秀的团队，二看优秀的项目，三看优秀的资源，四都不看");
			userinfo.setCity("天津");
			userinfo.setCheifDesc("是一个很神奇的信息计算平台");
			userinfo.setCollection(i*15);
			userinfo.setDoVocation("金融 电信");
			userinfo.setEducation("本科 清华");
			userinfo.setEmail("sdfsd@163.com");
			userinfo.setName("陈龙");
			userinfo.setPosition("工程师");
			userinfo.setPhone("133431323");
			list.add(userinfo);
		}
		return list;
	}
}
