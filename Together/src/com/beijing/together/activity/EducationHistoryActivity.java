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

public class EducationHistoryActivity extends BaseActivity implements OnClickListener{
	
	private TextView comimTextView;
	
	private EditText school;
	
	private EditText prefession;
	
	private EditText time;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_education_history);
		initView();
	}
	
	private void initView(){
		comimTextView = (TextView)findViewById(R.id.user_edit_commit_id);
		comimTextView.setOnClickListener(this);
		school = (EditText)findViewById(R.id.user_education_name_id);
		prefession = (EditText)findViewById(R.id.user_education_marir_id);
		time = (EditText)findViewById(R.id.user_education_time_id);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.user_edit_commit_id:
			String tx1 = school.getText().toString();
			String tx2 = prefession.getText().toString();
			String tx3 = time.getText().toString();
			String[] values = new String[]{tx1,tx2,tx3};
			Intent intent = new Intent();
			intent.putExtra("educationinfo", values);
			setResult(InitUserInfoActivity.EDUCATION, intent);
			finished();
			break;
		default:
			break;
		}
	}
}
