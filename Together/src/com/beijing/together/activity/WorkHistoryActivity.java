package com.beijing.together.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.beijing.together.R;
import com.beijing.together.animation.CustomZoomAnimation;

public class WorkHistoryActivity extends BaseActivity implements OnClickListener{
	
	private TextView comimTextView;
	
	private EditText company;
	
	private EditText position;
	
	private EditText time;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_work_history);
		initView();
	}
	
	private void initView(){
		comimTextView = (TextView)findViewById(R.id.user_edit_commit_id);
		comimTextView.setOnClickListener(this);
		company = (EditText)findViewById(R.id.user_work_company_id);
		position = (EditText)findViewById(R.id.user_work_carror_id);
		time = (EditText)findViewById(R.id.user_work_time_id);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.user_edit_commit_id:
			String tx1 = company.getText().toString();
			String tx2 = position.getText().toString();
			String tx3 = time.getText().toString();
			String[] values = new String[]{tx1,tx2,tx3};
			Intent intent = new Intent();
			intent.putExtra("workinfo", values);
			setResult(InitUserInfoActivity.WORK, intent);
			finished();
			break;
		
		default:
			break;
		}
	}
}
