package com.beijing.together.entity;

import java.util.ArrayList;

public class VisitorInfoProduct {
	
	
	public static ArrayList<VisitorInfo> productList(int num){
		ArrayList<VisitorInfo> list = new ArrayList<VisitorInfo>();
		for(int i=1;i<=num;i++){
			VisitorInfo userinfo = new VisitorInfo();
			userinfo.setAttented(i*13);
			userinfo.setAttention("�ƶ�������  ����");
			userinfo.setCompany("�ƶ��ڴ�");
			userinfo.setPosition("CEO CFO COO");
			userinfo.setVisitorDomain("�ƶ����� ҽ��   ��Ϸ  �罻");
			userinfo.setVisitorIdea("һ��������Ŷӣ������������Ŀ�������������Դ���Ķ�����");
			userinfo.setCity("���");
			userinfo.setCheifDesc("��һ�����������Ϣ����ƽ̨");
			userinfo.setCollection(i*15);
			userinfo.setDoVocation("���� ����");
			userinfo.setEducation("���� �廪");
			userinfo.setEmail("sdfsd@163.com");
			userinfo.setName("����");
			userinfo.setPosition("����ʦ");
			userinfo.setPhone("133431323");
			list.add(userinfo);
		}
		return list;
	}
}
