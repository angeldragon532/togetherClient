package com.beijing.together.entity;

import java.util.ArrayList;

public class UserInfoProduct {
	
	
	public static ArrayList<UserInfo> productList(int num){
		ArrayList<UserInfo> list = new ArrayList<UserInfo>();
		for(int i=1;i<=num;i++){
			UserInfo userinfo = new UserInfo();
			userinfo.setAttented(i*13);
			userinfo.setAttention("�ƶ�������  ����");
			userinfo.setCity("���");
			userinfo.setCollection(i*15);
			userinfo.setCurrentStatus("��ְ");
			userinfo.setDoVocation("���� ����");
			userinfo.setEducation("���� �廪");
			userinfo.setEmail("sdfsd@163.com");
			userinfo.setKeepMoney("һ��");
			userinfo.setName("����");
			userinfo.setNikeName("����");
			userinfo.setOutputMoney("һ����");
			userinfo.setWorkTime("����");
			userinfo.setWorks("��ʿ����");
			userinfo.setSkill("JAVA HTML");
			userinfo.setRedirect("�ƶ�������,����");
			userinfo.setPosition("����ʦ");
			userinfo.setPhone("133431323");
			userinfo.setPersonIndex(i%5);
			list.add(userinfo);
		}
		return list;
	}
}
