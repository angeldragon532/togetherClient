package com.beijing.together.activity;


import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import android.app.Application;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.beijing.together.R;

public class MyTogetherAppllication  extends Application{
	
	private static MyTogetherAppllication application;
	
	public static MyTogetherAppllication  getinstance(){
		return application;
	}
	
	private RequestQueue questQueue;
	
	public RequestQueue getQuestQueue() {
		return questQueue;
	}

	public void setQuestQueue(RequestQueue questQueue) {
		this.questQueue = questQueue;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		application = this;
        // ≥ı ºªØ°£
        RongIM.init(this,Constant.APPKEY,R.drawable.ic_launcher);
        questQueue = Volley.newRequestQueue(this);
	}
}
