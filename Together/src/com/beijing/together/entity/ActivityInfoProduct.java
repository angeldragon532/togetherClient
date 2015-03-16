package com.beijing.together.entity;

import java.util.ArrayList;

public class ActivityInfoProduct {
	
	
	public static ArrayList<ActivityInfo> productList(int num){
		ArrayList<ActivityInfo> list = new ArrayList<ActivityInfo>();
		for(int i=1;i<=num;i++){
			ActivityInfo activityInfo = new ActivityInfo();
			activityInfo.setAddress("北京海淀区中关村知春路籽晶科技园B座河床大厦");
			activityInfo.setDetail("12月前，我们成了我国际最大的移动创业者联盟平台");
			activityInfo.setEndTime("2014.09.23 14:00");
			activityInfo.setCheifer("爱合伙");
			activityInfo.setName("创业速配第三季");
			activityInfo.setStartTime("2014.09.23 9:00");
			activityInfo.setStatus("正在进行");
			activityInfo.setTarkNum("100");
			list.add(activityInfo);
		}
		return list;
	}
}
