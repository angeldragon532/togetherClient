package com.beijing.together.entity;

import java.util.ArrayList;

public class ActivityInfoProduct {
	
	
	public static ArrayList<ActivityInfo> productList(int num){
		ArrayList<ActivityInfo> list = new ArrayList<ActivityInfo>();
		for(int i=1;i<=num;i++){
			ActivityInfo activityInfo = new ActivityInfo();
			activityInfo.setAddress("�����������йش�֪��·�Ѿ��Ƽ�԰B���Ӵ�����");
			activityInfo.setDetail("12��ǰ�����ǳ����ҹ��������ƶ���ҵ������ƽ̨");
			activityInfo.setEndTime("2014.09.23 14:00");
			activityInfo.setCheifer("���ϻ�");
			activityInfo.setName("��ҵ���������");
			activityInfo.setStartTime("2014.09.23 9:00");
			activityInfo.setStatus("���ڽ���");
			activityInfo.setTarkNum("100");
			list.add(activityInfo);
		}
		return list;
	}
}
