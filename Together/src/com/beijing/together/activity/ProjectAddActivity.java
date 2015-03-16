package com.beijing.together.activity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import cc.lifelink.cn.City_cnActivity;

import com.beijing.together.R;
import com.beijing.together.entity.ProjectPartnerInfo;
import com.beijing.together.entity.Project;
import com.beijing.together.utils.DialogUtils;
import com.beijing.together.utils.Utils;
import com.beijing.together.utils.DialogUtils.DialogCallBack;

public class ProjectAddActivity extends BaseActivity implements OnClickListener{
	
	private TextView backTextView;
	private TextView finishedTextView;
	private EditText projectName;
	private TextView projectCity;
	private TextView projectRedirect;
	private TextView projectFineiceStatus;
	private TextView projectRunStatus;
	private TextView projectDevelopTime;
	private TextView projectNeedPatener;
	private EditText projectDesc;
	
	private LinearLayout partnerLinearLayout;
	
	public static final int TO_REDIRECT = 6;
	
	private ProjectPartnerInfo partnerInfo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.project_add);
		initView();
		initListener();
	}
	
	private void initView(){
		backTextView = (TextView)findViewById(R.id.project_add_back_id);
		finishedTextView = (TextView)findViewById(R.id.project_add_commit_id);
        projectCity = (TextView)findViewById(R.id.project_add_city_id);
        projectRedirect = (TextView)findViewById(R.id.project_add_select_redirect_id);
        projectFineiceStatus = (TextView)findViewById(R.id.project_add_fininace_status_id);
        projectRunStatus = (TextView)findViewById(R.id.project_add_run_status_id);
        projectDevelopTime = (TextView)findViewById(R.id.project_add_developer_time_id);
        projectNeedPatener = (TextView)findViewById(R.id.project_add_need_pataner_id);
        
        partnerLinearLayout = (LinearLayout)findViewById(R.id.project_add_pataner_list_id);
        
        //not need onlistner
        projectName = (EditText)findViewById(R.id.project_add_name_id);
        projectDesc = (EditText)findViewById(R.id.project_add_project_desc_id);
	}
	
	private void initListener(){
		backTextView.setOnClickListener(this);
		finishedTextView.setOnClickListener(this);
		projectCity.setOnClickListener(this);
		projectRedirect.setOnClickListener(this);
		projectFineiceStatus.setOnClickListener(this);
		projectRunStatus.setOnClickListener(this);
		projectDevelopTime.setOnClickListener(this);
		projectNeedPatener.setOnClickListener(this);
	}
	
	/**
	 * 提交项目信息
	 */
	private void commitProjectInfo(){
		Project project = new Project();
		project.setAttention(10);
		project.setCity(projectCity.getText() != null?projectCity.getText().toString():"");
		project.setRedirect(projectRedirect.getText() != null?projectRedirect.getText().toString():"");
		project.setFinaceStatus(projectFineiceStatus.getText() != null?projectFineiceStatus.getText().toString():"");
		project.setRunStatus(projectRunStatus.getText() != null?projectRunStatus.getText().toString():"");
		project.setDevelopTime(projectDevelopTime.getText() != null?projectDevelopTime.getText().toString():"");
		project.setCity(projectCity.getText() != null?projectCity.getText().toString():"");
		project.setProjectName(projectName.getText() != null?projectName.getText().toString():"");
		project.setProjectDec(projectDesc.getText() != null?projectDesc.getText().toString():"");
		ArrayList<ProjectPartnerInfo> parterList = new ArrayList<ProjectPartnerInfo>();
		if(partnerInfo != null){
			parterList.add(partnerInfo);
		}
		project.setPartnerList(parterList);
		File file = new File(Utils.CACHEDIR + Utils.PROJECT_INFO);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Utils.saveObject(Utils.CACHEDIR + Utils.PROJECT_INFO,project);
		finished();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.project_add_back_id:
			finished();
			break;
		case R.id.project_add_commit_id:
			commitProjectInfo();	
			break;
		case R.id.project_add_city_id:
			Intent cityIntent = new Intent(this,City_cnActivity.class);
			startActivityForResult(cityIntent,City_cnActivity.CITY);
			break;
		case R.id.project_add_select_redirect_id:
			Intent redirceSelectIntent = new Intent(this,RedirectSelectActivity.class);
			startActivityForResult(redirceSelectIntent,TO_REDIRECT);
			break;
		case R.id.project_add_fininace_status_id:
			DialogUtils.createDialog(this,R.layout.project_add_fininacestatus_dialog,
					new DialogCallBack() {
				@Override
				public void onDialogListener(String value) {
					if(!TextUtils.isEmpty(value)){
						projectFineiceStatus.setText(value);
					}
				}
			});
			break;
		case R.id.project_add_run_status_id:
			DialogUtils.createDialog(this,R.layout.project_add_runstatus_dialog,
					new DialogCallBack() {
				@Override
				public void onDialogListener(String value) {
					if(!TextUtils.isEmpty(value)){
						projectRunStatus.setText(value);
					}
				}
			});
			break;
		case R.id.project_add_developer_time_id:
			DialogUtils.createDialog(this,R.layout.project_add_developetime_dialog,
					new DialogCallBack() {
				@Override
				public void onDialogListener(String value) {
					if(!TextUtils.isEmpty(value)){
						projectDevelopTime.setText(value);
					}
				}
			});
			break;
		case R.id.project_add_need_pataner_id:
			Intent partnerIntent = new Intent(this,ProjectPartnerAddActivity.class);
			startActivityForResult(partnerIntent,ProjectPartnerAddActivity.RQUEST_CODE_PARTNER);
			break;
		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if(data == null)return;
		switch (requestCode) {
		case TO_REDIRECT:
			String redirect = data.getStringExtra("redirectInfo");
			if(!TextUtils.isEmpty(redirect)){
				projectRedirect.setText(redirect);
			}
			break;
		case City_cnActivity.CITY:
			String cityInfo = data.getStringExtra("cityvalue");
			if(!TextUtils.isEmpty(cityInfo)){
				projectCity.setText(cityInfo);
			}
			break;
		case ProjectPartnerAddActivity.RQUEST_CODE_PARTNER:
			ArrayList<ProjectPartnerInfo> list = (ArrayList<ProjectPartnerInfo>)
				data.getSerializableExtra("partnerlistinfo");
			if(list != null && list.size() > 0){
				partnerInfo = list.get(0);
				partnerLinearLayout.setVisibility(View.VISIBLE);
				((TextView)partnerLinearLayout.findViewById(R.id.project_add_partner_rolename_id)).setText(partnerInfo.getRoleName());
				((TextView)partnerLinearLayout.findViewById(R.id.project_add_partner_work_id)).setText(partnerInfo.getWorkway());
				((TextView)partnerLinearLayout.findViewById(R.id.project_add_partner_opion_id)).setText(partnerInfo.getOption());
				((TextView)partnerLinearLayout.findViewById(R.id.project_add_partner_salary_id)).setText(partnerInfo.getSalary());
			}else{
				partnerLinearLayout.setVisibility(View.GONE);
			}
			break;
		default:
			break;
		}
	}
}
