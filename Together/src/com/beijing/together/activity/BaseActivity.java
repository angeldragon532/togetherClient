package com.beijing.together.activity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.KeyEvent;

import com.beijing.together.R;

public class BaseActivity extends Activity{
	
	public static int WIDTHPIX;
	public static int HEIGHTPIX;
	
	protected Dialog dialog;
	protected static int CLOSE_MyDIALOG = -10;
	
	protected Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case -10:
				if(dialog != null || dialog.isShowing()){
					dialog.dismiss();
				}
				break;

			default:
				break;
			}
		};
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		DisplayMetrics metrics=new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		WIDTHPIX=metrics.widthPixels;
		HEIGHTPIX=metrics.heightPixels;
		System.out.println("-----你手机的分辨率是："+WIDTHPIX+"*"+HEIGHTPIX);
		
		int version = Integer.valueOf(android.os.Build.VERSION.SDK_INT);
		if (version > 4) {
			overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
		}
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finished();
		}
		return super.onKeyDown(keyCode, event);
	}
	
	protected boolean finished(){
		this.finish(); // finish当前activity
		int version = Integer.valueOf(android.os.Build.VERSION.SDK_INT);
		if (version > 4) {
			overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
		}
		return true;
	}
	
}
