package com.beijing.together.activity;


import java.io.File;
import android.annotation.SuppressLint;
import android.content.Intent;
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
import com.beijing.together.utils.Utils;

@SuppressLint("ValidFragment")
public class SubMenuVisitorFragment extends Fragment implements View.OnClickListener{
	
	private ImageView sub_menu_myphoto;// ÎÒµÄÍ·Ïñ
	private TextView username;//
	private LinearLayout sub_menu_porject;//
	private LinearLayout sub_menu_create;//
	private LinearLayout sub_menu_partner;//
	private LinearLayout sub_menu_visitor;//
	private LinearLayout sub_menu_resource;// 
	private LinearLayout sub_menu_manager;//
	
	public static String PROJECT_TAG = "project";
	public static String PARTNER_TAG = "partner";
	public static String VISITOR_TAG = "visitor";
	public static String FOUNDER_TAG = "founder";
	
	private  OnChangeMenuToggle menuToggle;
	
	private Fragment mLastFragment;
	
	public SubMenuVisitorFragment(OnChangeMenuToggle menuToggle){
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
	}
	
	  @Override  
	    public void onActivityCreated(Bundle savedInstanceState) {  
	        super.onActivityCreated(savedInstanceState);
	        initData();
	    }

	  private void initData(){
		  File file = new File(Utils.CACHEDIR,Utils.USER_INFO);
		  Object object = Utils.restoreObject(file.getAbsolutePath());
		  if(object != null){
			  UserInfo info = (UserInfo)object;
			  username.setText(info.getName());
		  }
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
		case R.id.sub_menu_create_id://
		case R.id.sub_menu_partner_id://
		case R.id.sub_menu_visitor_id: //
		case R.id.sub_menu_resource_id://
		case R.id.sub_menu_manage_id://
			showContentFragment(v.getId());
			break;
		default:
			break;
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
			fuyongfragment(FOUNDER_TAG,R.id.sub_menu_visitor_id);
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
			}
			fragment.setOnMenuToggle(null);
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
