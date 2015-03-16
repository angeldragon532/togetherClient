package com.beijing.together.entity;

import java.util.ArrayList;
import java.util.List;

public class ProjectProduct {
	
	
	public static ArrayList<Project> productList(int num){
		ArrayList<Project> list = new ArrayList<Project>();
		for(int i=1;i<=num;i++){
			Project project = new Project();
			project.setAttention(200/i);
			project.setCollection(500/i);
			project.setHad_finance(100);
			project.setImageUrl("http://");
			project.setIncome(i%2==0?true:false);
			project.setMemeberIndex(i%5);
			project.setMessageNum(i*10);
			project.setOnLineTime("2014-02-09");
			project.setOverPlusTime(i);
			project.setPre_finance(1000);
			project.setRedirect("移动互联网   OTO");
			project.setProjectDec("这事一个神奇的项目，可以保你享福无忧，让你人才双手的举世爆掉的项目");
			project.setProjectName("黄金时间");
			project.setOnline(i%2 == 0?true:false);
			project.setCity("北京");
			getProjectPartner(project);
			list.add(project);
		}
		return list;
	}
	
	public static void getProjectPartner(Project project){
		ArrayList<ProjectPartnerInfo> infos = new ArrayList<ProjectPartnerInfo>();
		for(int i=0;i<10;i++){
			ProjectPartnerInfo info = new ProjectPartnerInfo();
			info.setRoleName("技术合伙人");
			info.setSalary("15K");
			info.setWorkway("全职");
			infos.add(info);
		}
		project.setPartnerList(infos);
	}
}
