package com.beijing.together.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.beijing.together.R;
import com.beijing.together.activity.SubMenuFragment.OnChangeMenuToggle;
import com.beijing.together.activity.widget.ConditionDialog;

public class BaseFragment extends Fragment implements OnClickListener{
	
	protected ImageView acitonHomeAs;
	protected TextView titleTextView;
	protected ImageView sortImageView;
	protected ImageView selectImageView;
	protected ImageView searchImageView;
	
	protected OnChangeMenuToggle menuToggle;
	
	protected String actionBarTitle;
	protected int fragmentTag = 0;//0项目 1 发起人 2合伙人 3投资人  4创业资源  5项目管理
	

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initTitle();
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.title_homeas_id:
			if(menuToggle != null)
				menuToggle.onChangMenuCallBack();
			break;
		case R.id.title_back_text_img_sort_id:
			Intent projectIntent = new Intent(getActivity(),ProjectAddActivity.class);
			startActivity(projectIntent);
			break;
		case R.id.title_back_text_img_select_id:
			ConditionDialog dialog = new ConditionDialog(getActivity());
			dialog.show();
			break;
		case R.id.title_back_text_img_search_id:
			Intent intent = new Intent(getActivity(),ProjectSearchActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}	
	
	/**
	 * 在父类初始化标题数据
	 */
	protected void initTitle(){
		acitonHomeAs = (ImageView)this.getActivity().findViewById(R.id.title_homeas_id);
		titleTextView = (TextView)this.getActivity().findViewById(R.id.title_text_mid_id);
		sortImageView = (ImageView)this.getActivity().findViewById(R.id.title_back_text_img_sort_id);
		selectImageView = (ImageView)this.getActivity().findViewById(R.id.title_back_text_img_select_id);
		searchImageView = (ImageView)this.getActivity().findViewById(R.id.title_back_text_img_search_id);
		
		titleTextView.setText(actionBarTitle);
		acitonHomeAs.setOnClickListener(this);
		searchImageView.setOnClickListener(this);
		selectImageView.setOnClickListener(this);
		sortImageView.setOnClickListener(this);
	}
	
	public int getFragmentTag() {
		return fragmentTag;
	}

	public void setFragmentTag(int fragmentTag) {
		this.fragmentTag = fragmentTag;
	}

	public String getActionBarTitle() {
		return actionBarTitle;
	}

	public void setActionBarTitle(String actionBarTitle) {
		this.actionBarTitle = actionBarTitle;
	}
	
	public OnChangeMenuToggle getMenuToggle() {
		return menuToggle;
	}

	public void setOnMenuToggle(OnChangeMenuToggle menuToggle) {
		this.menuToggle = menuToggle;
	}
}
