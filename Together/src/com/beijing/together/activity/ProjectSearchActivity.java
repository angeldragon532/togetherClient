package com.beijing.together.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.beijing.together.R;

public class ProjectSearchActivity extends BaseActivity implements OnClickListener{
	
	private ImageView backImageView;
	private EditText searchEditText;
	private ImageView clearSerachImage;
	
	private TextView hot_elec_TextView;
	private TextView hot_play_TextView;
	private TextView hot_oto_TextView;
	
	private TextView clear_distoryTextView;
	private TextView cur_electTextView;
	private TextView cur_playTextView;
	private TextView cur_otoTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.project_search);
		initView();
	}
	
	private void initView(){
		clearSerachImage = (ImageView)findViewById(R.id.project_search_clearc_id);
		searchEditText = (EditText)findViewById(R.id.project_search_edit_id);
		hot_elec_TextView = (TextView)findViewById(R.id.project_serach_ele_business_id);
		hot_play_TextView = (TextView)findViewById(R.id.project_serach_ele_play_id);
		hot_oto_TextView = (TextView)findViewById(R.id.project_serach_ele_oto_id);
		clear_distoryTextView = (TextView)findViewById(R.id.project_search_distory_clear_id);
		cur_electTextView = (TextView)findViewById(R.id.project_serach_ele_distorybusiness_id);
		cur_playTextView = (TextView)findViewById(R.id.project_serach_play_distorybusiness_id);
		cur_otoTextView = (TextView)findViewById(R.id.project_serach_oto_distorybusiness_id);
		
		clearSerachImage.setOnClickListener(this);
		hot_elec_TextView.setOnClickListener(this);
		hot_play_TextView.setOnClickListener(this);
		hot_oto_TextView.setOnClickListener(this);
		clear_distoryTextView.setOnClickListener(this);
		cur_electTextView.setOnClickListener(this);
		cur_playTextView.setOnClickListener(this);
		cur_otoTextView.setOnClickListener(this);
		
		searchEditText.addTextChangedListener(new MyTextWitch(searchEditText));
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login_back_id:
			finished();
			break;
		case R.id.project_serach_ele_business_id:
		case R.id.project_serach_ele_play_id:
		case R.id.project_serach_ele_oto_id:
		case R.id.project_serach_ele_distorybusiness_id:
		case R.id.project_serach_play_distorybusiness_id:
		case R.id.project_serach_oto_distorybusiness_id:
			TextView tView = (TextView)v;
			searchEditText.setText(tView.getText());
			break;
		case R.id.project_search_distory_clear_id:
			cur_electTextView.setVisibility(View.GONE);
			cur_playTextView.setVisibility(View.GONE);
			cur_otoTextView.setVisibility(View.GONE);
			break;
		case R.id.project_search_clearc_id:
			searchEditText.setText("");
			break;
		default:
			break;
		}
	}
	
	private class MyTextWitch implements TextWatcher{
		private EditText view;
		private MyTextWitch(EditText view){
			this.view = view;
		}
		@Override
		public void afterTextChanged(Editable s) {
			String keyword = s.toString();
			keyword = keyword.trim();
			Drawable result = null;
			boolean nullData = true;
			if (s == null || s.length() == 0||"".equals(s.toString().trim())) {
				nullData = true;
			}else {
				nullData = false;
			}
			
			if(view.getId() == searchEditText.getId()){
				if(nullData){
					clearSerachImage.setVisibility(View.GONE);
				}else{
					clearSerachImage.setVisibility(View.VISIBLE);
				}
			}
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
		}
	}
	
	private void showDanymicLeftDrable(EditText v,Drawable drawable){
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
		v.setCompoundDrawables(drawable,null,null,null);
	}
}
