package com.beijing.together.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.beijing.together.R;

public class AppGuideActivity extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		initView();
	}
	
	private void initView(){
		findViewById(R.id.regeste_user_id).setOnClickListener(
				new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(AppGuideActivity.this,RegeisteActivity.class);
				AppGuideActivity.this.startActivity(intent);
			}
		});
		findViewById(R.id.login_user_id).setOnClickListener(
				new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(AppGuideActivity.this,LoginActivity.class);
				AppGuideActivity.this.startActivity(intent);
			}
		});
	}
}
