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
			project.setRedirect("�ƶ�������   OTO");
			project.setProjectDec("����һ���������Ŀ�����Ա��������ǣ������˲�˫�ֵľ�����������Ŀ");
			project.setProjectName("�ƽ�ʱ��");
			project.setOnline(i%2 == 0?true:false);
			project.setCity("����");
			getProjectPartner(project);
			list.add(project);
		}
		return list;
	}
	
	public static void getProjectPartner(Project project){
		ArrayList<ProjectPartnerInfo> infos = new ArrayList<ProjectPartnerInfo>();
		for(int i=0;i<10;i++){
			ProjectPartnerInfo info = new ProjectPartnerInfo();
			info.setRoleName("�����ϻ���");
			info.setSalary("15K");
			info.setWorkway("ȫְ");
			infos.add(info);
		}
		project.setPartnerList(infos);
	}
}
