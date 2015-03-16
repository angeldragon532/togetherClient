package com.beijing.together.activity;


import java.io.File;
import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beijing.together.R;
import com.beijing.together.entity.UserInfo;
import com.beijing.together.entity.VisitorInfo;
import com.beijing.together.utils.Utils;

@SuppressLint("ValidFragment")
public class SubMenuFragment extends Fragment implements View.OnClickListener{
	
	private ImageView sub_menu_myphoto;
	private TextView username;
	private LinearLayout sub_menu_porject;
	private LinearLayout sub_menu_create;
	private LinearLayout sub_menu_partner;
	private LinearLayout sub_menu_visitor;
	private LinearLayout sub_menu_resource; 
	private LinearLayout sub_menu_manager;
	
	public static String PROJECT_TAG = "project";
	public static String PARTNER_TAG = "partner";
	public static String VISITOR_TAG = "visitor";
	public static String FOUNDER_TAG = "founder";
	public static String ACTIVITY_TAG = "activity";
	
	private static int[] selectDrawable = new int[]{R.drawable.main_menu_project_press,R.drawable.main_menu_founder_press,
			R.drawable.main_menu_partner_press,R.drawable.main_menu_visitor_press,R.drawable.main_menu_resource_press,
			R.drawable.main_menu_managerproject_press};
	
	private int[] nomalDrawable = new int[]{R.drawable.main_menu_project,R.drawable.main_menu_founder,
		R.drawable.main_menu_partner,R.drawable.main_menu_visitor,R.drawable.main_menu_resource,
		R.drawable.main_menu_managerproject};
	
	private ArrayList<LinearLayout> list = new ArrayList<LinearLayout>();
	private static String selectColor = "#ff00a040";
	private static String nomalColor = "#ff000000";
	private static OnChangeMenuToggle menuToggle;
	private Fragment mLastFragment;
	
	private int lastIndex = 0;
	private int currentIndex = 0;
	
	
	public SubMenuFragment(OnChangeMenuToggle menuToggle){
		this.menuToggle = menuToggle;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	   View resultview = inflater.inflate(R.layout.main_menu, container, false);  
	   initView(resultview);
	   return resultview;
	}
	
	private void initView(View view){
		sub_menu_myphoto = (ImageView)view.findViewById(R.id.main_submenu_image_photo_id);
		username = (TextView)view.findViewById(R.id.main_submenu_user_name_id);
		sub_menu_porject = (LinearLayout)view.findViewById(R.id.sub_menu_project_id);
		sub_menu_create = (LinearLayout)view.findViewById(R.id.sub_menu_create_id);
		sub_menu_partner = (LinearLayout)view.findViewById(R.id.sub_menu_partner_id);
		sub_menu_visitor = (LinearLayout)view.findViewById(R.id.sub_menu_visitor_id);
		sub_menu_resource = (LinearLayout)view.findViewById(R.id.sub_menu_resource_id);
		sub_menu_manager = (LinearLayout)view.findViewById(R.id.sub_menu_manage_id);
		sub_menu_myphoto.setOnClickListener(this);
		sub_menu_porject.setOnClickListener(this);
		sub_menu_create.setOnClickListener(this);
		sub_menu_partner.setOnClickListener(this);
		sub_menu_visitor.setOnClickListener(this);
		sub_menu_resource.setOnClickListener(this);
		sub_menu_manager.setOnClickListener(this);
		
		list.add(sub_menu_porject);
		list.add(sub_menu_create);
		list.add(sub_menu_partner);
		list.add(sub_menu_visitor);
		list.add(sub_menu_resource);
		list.add(sub_menu_manager);
	}
	
	  @Override  
	    public void onActivityCreated(Bundle savedInstanceState) {  
	        super.onActivityCreated(savedInstanceState);
	        initData();
	    }

	  private void initData(){
		  String name = Utils.getLoginUserName();
		  username.setText(name);
	  }
	  
	@Override
	public void onClick(View v) {
		Intent intent = null;
		switch (v.getId()) {
		case R.id.main_submenu_image_photo_id://
			intent = new Intent(getActivity(),InitUserInfoActivity.class);
			startActivity(intent);
			menuToggle.onChangMenuCallBack();
			break;
		case R.id.sub_menu_project_id:	
			currentIndex = 0;
			break;
		case R.id.sub_menu_create_id://
			currentIndex = 1;
			break;
		case R.id.sub_menu_partner_id://
			currentIndex = 2;
			break;
		case R.id.sub_menu_visitor_id: //
			currentIndex = 3;
			break;
		case R.id.sub_menu_resource_id://
			currentIndex = 4;
			break;
		case R.id.sub_menu_manage_id://
			currentIndex = 5;
			break;
		default:
			break;
		}
		showContentFragment(v.getId());
		selectIndexLinearlayout(currentIndex,lastIndex);
		
	} 
	
	private void selectIndexLinearlayout(int current,int last){
		if(current == last)return;
		if(list != null && list.size()>0){
			LinearLayout ll = list.get(current);
			ImageView imageView = (ImageView)ll.getChildAt(0);
			TextView textView = (TextView)ll.getChildAt(1);
			imageView.setImageResource(selectDrawable[current]);
			textView.setTextColor(Color.parseColor(selectColor));
			
			LinearLayout nomal = list.get(last);
			ImageView nomalmageView = (ImageView)nomal.getChildAt(0);
			TextView nomalTextView = (TextView)nomal.getChildAt(1);
			nomalmageView.setImageResource(nomalDrawable[last]);
			nomalTextView.setTextColor(Color.parseColor(nomalColor));
			lastIndex = current;
		}
	}
	
	public void showContentFragment(int selectViewId){
		switch (selectViewId) {
		case R.id.sub_menu_project_id:
//			if(projectFragment == null){
//				projectFragment = new ProjectListFragment();
//			}
//			this.getActivity().getSupportFragmentManager().beginTransaction()
//			.replace(R.id.content_frame,projectFragment)
//			.commit();
			fuyongfragment(PROJECT_TAG,R.id.sub_menu_project_id);
			break;
		case R.id.sub_menu_partner_id:
			fuyongfragment(PARTNER_TAG,R.id.sub_menu_partner_id);
//			if(partnreFragment == null){
//				partnreFragment = new PartnerListFragment();
//			}
//			this.getActivity().getSupportFragmentManager().beginTransaction()
//			.replace(R.id.content_frame,partnreFragment)
//			.commit();
			break;
		case R.id.sub_menu_visitor_id:
			fuyongfragment(VISITOR_TAG,R.id.sub_menu_visitor_id);
			break;
		case R.id.sub_menu_create_id:
			fuyongfragment(FOUNDER_TAG,R.id.sub_menu_create_id);
			break;
		case R.id.sub_menu_resource_id:
			fuyongfragment(ACTIVITY_TAG,R.id.sub_menu_resource_id);
			break;
		default:
			break;
		}
		menuToggle.onChangMenuCallBack();
	}
	
	public void fuyongfragment(String tagName,int viewID) {
		FragmentTransaction fragmentTransaction = this.getActivity()
				.getSupportFragmentManager().beginTransaction();
		if (mLastFragment != null) {
			fragmentTransaction.detach(mLastFragment);
		}

		BaseFragment fragment = (BaseFragment)this.getActivity().getSupportFragmentManager()
			.findFragmentByTag(tagName);
		if (fragment == null) {
			if(viewID == R.id.sub_menu_project_id){
				fragment = new ProjectListFragment();
			}else if(viewID == R.id.sub_menu_partner_id){
				fragment = new PartnerListFragment();
			}else if(viewID == R.id.sub_menu_visitor_id){
				fragment = new VisitorListFragment();
			}else if(viewID == R.id.sub_menu_create_id){
				fragment = new FounderListFragment();
			}else if(viewID == R.id.sub_menu_resource_id){
				fragment = new ActivityInfoListFragment();
			}
			fragment.setOnMenuToggle(menuToggle);
			fragmentTransaction.replace(R.id.content_frame, fragment, tagName);
		} else {
			fragmentTransaction.attach(fragment);
		}
		mLastFragment = fragment;
		fragmentTransaction.commitAllowingStateLoss();
		this.getActivity().getSupportFragmentManager().executePendingTransactions();
	}
	
	public interface OnChangeMenuToggle{
		public void onChangMenuCallBack();
	}
}
