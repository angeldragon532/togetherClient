package com.beijing.together.activity.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.beijing.together.R;

public class ConditionDialog extends Dialog {

	TextView txv_title = null;// 标题
	TextView txv_content = null;// 内容
	ImageView imageconfirm = null;
	ImageView imagecancel = null;


	public ConditionDialog(Context context) {
		super(context, R.style.NoTitleTransDialog);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.project_list_condition_dialog);
		initView();
		setCancelable(false);
	}
	
	private void initView(){
		imagecancel = (ImageView)findViewById(R.id.dialog_close_id);
		imagecancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dismiss();
			}
		});
		imageconfirm = (ImageView)findViewById(R.id.dialog_confirm_id);
		imageconfirm.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dismiss();
			}
		});
	}

	public ImageView getConfirm() {
		return imageconfirm;
	}
	
	public ImageView getCancel(){
		return imagecancel;
	}

}
