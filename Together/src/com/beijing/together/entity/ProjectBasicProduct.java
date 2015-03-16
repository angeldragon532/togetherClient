package com.beijing.together.entity;

import java.util.ArrayList;
import java.util.List;

import com.beijing.together.R;

public class ProjectBasicProduct {
	
	
	public static ArrayList<ProjectBasic> productList(int num){
		ArrayList<ProjectBasic> list = new ArrayList<ProjectBasic>();
		for(int i=0;i<num;i++){
			ProjectBasic projectBasic = new ProjectBasic();
			projectBasic.setName("ËÑ±¦");
			projectBasic.setImageUrl(String.valueOf(R.drawable.my_name));
			list.add(projectBasic);
		}
		return list;
	}
}
