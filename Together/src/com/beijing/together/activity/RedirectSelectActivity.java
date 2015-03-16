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
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.beijing.together.R;
import com.beijing.together.animation.CustomZoomAnimation;

public class RedirectSelectActivity extends BaseActivity implements OnClickListener{
	
	private ImageView backImageView;
	private TextView commitTextView;
	
//	private RadioButton btn1;
//	private RadioButton btn2;
//	private RadioButton btn3;
//	private RadioButton btn4;
//	private RadioButton btn5;
//	private RadioButton btn6;
//	private RadioButton btn7;
//	private RadioButton btn8;
//	private RadioButton btn9;
//	private RadioButton btn10;
//	private RadioButton btn11;
//	private RadioButton btn12;
//	private RadioButton btn13;
//	private RadioButton btn14;
//	private RadioButton btn15;
//	private RadioButton btn16;
	
	private LinearLayout group1;
	private LinearLayout group2;
	
	private String selectValue="";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.redirect_select);
		initView();
	}
	
	private void initView(){
		backImageView = (ImageView)findViewById(R.id.redirect_select_back_id);
		commitTextView = (TextView)findViewById(R.id.redirect_select_commit_id);
		backImageView.setOnClickListener(this);
		commitTextView.setOnClickListener(this);
		
		group1 = (LinearLayout)findViewById(R.id.radiogroup_1_id);
		group2 = (LinearLayout)findViewById(R.id.radiogroup_2_id);
		
//		btn1 = (RadioButton)findViewById(R.id.orderBy1);
//		btn2 = (RadioButton)findViewById(R.id.orderBy2);
//		btn3 = (RadioButton)findViewById(R.id.orderBy3);
//		btn4 = (RadioButton)findViewById(R.id.orderBy4);
//		btn5 = (RadioButton)findViewById(R.id.orderBy5);
//		btn6 = (RadioButton)findViewById(R.id.orderBy6);
//		btn7 = (RadioButton)findViewById(R.id.orderBy7);
//		btn8 = (RadioButton)findViewById(R.id.orderBy8);
//		btn9 = (RadioButton)findViewById(R.id.orderBy9);
//		btn10 = (RadioButton)findViewById(R.id.orderBy10);
//		btn11 = (RadioButton)findViewById(R.id.orderBy11);
//		btn12 = (RadioButton)findViewById(R.id.orderBy12);
//		btn13 = (RadioButton)findViewById(R.id.orderBy13);
//		btn14 = (RadioButton)findViewById(R.id.orderBy14);
//		btn15 = (RadioButton)findViewById(R.id.orderBy15);
//		btn16 = (RadioButton)findViewById(R.id.orderBy16);
	}
	
	private void commitSelect(){
		for(int i=0;i<group1.getChildCount();i++){
			RadioButton rb = (RadioButton)group1.getChildAt(i);
			if(rb.isChecked()){
				System.out.println("----longlonge--"+rb.getText().toString());
				selectValue+=rb.getText().toString()+" ";
			}
		}
		for(int i=0;i<group2.getChildCount();i++){
			RadioButton rb = (RadioButton)group2.getChildAt(i);
			if(rb.isChecked()){
				System.out.println("----longlonge--"+rb.getText().toString());
				selectValue+=rb.getText().toString()+" ";
			}
		}
		Intent intent = new Intent();
		intent.putExtra("redirectInfo", selectValue);
		setResult(ProjectAddActivity.TO_REDIRECT,intent);
		finished();
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.redirect_select_back_id:
			finished();
			break;
		case R.id.redirect_select_commit_id:
			commitSelect();
			break;
		default:
			break;
		}
	}
	
	
}
