package com.beijing.together.activity.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.beijing.together.R;

public class UserInfoSelectDialog extends Dialog {

	private Context context;
	
	public UserInfoSelectDialog(Context context) {
		super(context, R.style.NoTitleTransDialog);
		this.context = context;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.project_list_condition_dialog);
		setCancelable(false);
		
		ListView listview = new ListView(context);  
		String[] values = context.getResources().getStringArray(R.string.user_info_attention);
		ArrayAdapter adapter = new ArrayAdapter<String>(context, 
				android.R.layout.simple_expandable_list_item_1, values);
		listview.setAdapter(adapter);  
		setContentView(listview);   
	}
	

	
}
