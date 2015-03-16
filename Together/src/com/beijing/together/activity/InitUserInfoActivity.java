package com.beijing.together.activity;

import java.io.File;
import java.io.IOException;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import cc.lifelink.cn.City_cnActivity;

import com.beijing.together.R;
import com.beijing.together.entity.UserInfo;
import com.beijing.together.entity.VisitorInfo;
import com.beijing.together.utils.Utils;


public class InitUserInfoActivity extends BaseActivity  implements OnClickListener{
	
	private TextView commitInfo;
	private TextView showName;
	private EditText nameNikeEdit;
	private TextView cityText;
	private TextView statusText;
	private TextView redirectText;
	private TextView attentionText;
	private TextView phoneText;
	private TextView emailText;
	private TextView keepMoneyText;
	private TextView outputMoneyText;
	private TextView worktText;
	private TextView educationText;
	
	private Dialog dialog;
	
	public static final int WORK = 11;
	public static final int EDUCATION = 12;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.init_userinfo);
		initView();
		initListner();
		initData();
	}
	
	private void initView(){
		commitInfo = (TextView)findViewById(R.id.user_edit_commit_id);
		showName = (TextView)findViewById(R.id.user_name__id);
		nameNikeEdit = (EditText)findViewById(R.id.user_edit_nikename_id);
		cityText = (TextView)findViewById(R.id.user_edit_city_id);
		statusText = (TextView)findViewById(R.id.user_edit_curstatus_id);
		redirectText = (TextView)findViewById(R.id.user_edit_redirect_id);
		attentionText = (TextView)findViewById(R.id.user_edit_attention_id);
		emailText = (TextView)findViewById(R.id.user_edit_email_id);
		keepMoneyText = (TextView)findViewById(R.id.user_edit_keepmoney_id);
		outputMoneyText = (TextView)findViewById(R.id.user_edit_outputmoney_id);
		worktText = (TextView)findViewById(R.id.user_edit_work_id);
		educationText = (TextView)findViewById(R.id.user_edit_education_id);
	}
	
	private void initListner(){
		cityText.setOnClickListener(this);
		statusText.setOnClickListener(this);
		redirectText.setOnClickListener(this);
		attentionText.setOnClickListener(this);
		emailText.setOnClickListener(this);
		keepMoneyText.setOnClickListener(this);
		outputMoneyText.setOnClickListener(this);
		worktText.setOnClickListener(this);
		educationText.setOnClickListener(this);
		commitInfo.setOnClickListener(this);
	}
	
	private void initData(){
		//Object userbasic = Utils.restoreObject(Utils.CACHEDIR + Utils.USER_INFO);
		Object userbasic = Utils.getUserInfo();
		if(userbasic != null){
			if(userbasic instanceof UserInfo){
				UserInfo userInfo = (UserInfo)userbasic;
				showName.setText(userInfo.getName());
				nameNikeEdit.setText(userInfo.getNikeName());
				cityText.setText(userInfo.getCity());
				statusText.setText(userInfo.getCurrentStatus());
				redirectText.setText(userInfo.getRedirect());
				attentionText.setText(userInfo.getAttention());
				emailText.setText(userInfo.getEmail());
				keepMoneyText.setText(userInfo.getKeepMoney());
				outputMoneyText.setText(userInfo.getOutputMoney());
				worktText.setText(userInfo.getWorks());
				educationText.setText(userInfo.getEducation());
			}else if(userbasic instanceof VisitorInfo){
				VisitorInfo visitorInfo = (VisitorInfo)userbasic;
				showName.setText(visitorInfo.getName());
				nameNikeEdit.setText(visitorInfo.getName());
				cityText.setText(visitorInfo.getCity());
				//statusText.setText(visitorInfo.et);
				//redirectText.setText(visitorInfo.get);
				attentionText.setText(visitorInfo.getAttention());
				emailText.setText(visitorInfo.getEmail());
				//keepMoneyText.setText(visitorInfo.get;
				//outputMoneyText.setText(visitorInfo.getOutputMoney());
				worktText.setText(visitorInfo.getPosition());
				educationText.setText(visitorInfo.getEducation());
			}
		}
	}
	
	private void commitUserInfo(){
		//userInfo.setPhone(outputMoneyText.getText() == null?outputMoneyText.getText().toString():"");
		UserInfo userInfo = new UserInfo();
		userInfo.setAttention(attentionText.getText() != null?attentionText.getText().toString():"");
		userInfo.setCity(cityText.getText() != null?cityText.getText().toString():"");
		userInfo.setCurrentStatus(statusText.getText() != null?statusText.getText().toString():"");
		userInfo.setEducation(educationText.getText() != null?educationText.getText().toString():"");
		userInfo.setEmail(emailText.getText() != null?emailText.getText().toString():"");
		userInfo.setKeepMoney(keepMoneyText.getText() != null?keepMoneyText.getText().toString():"");
		userInfo.setName(showName.getText() != null?showName.getText().toString():"");
		userInfo.setNikeName(nameNikeEdit.getText() != null?nameNikeEdit.getText().toString():"");
		userInfo.setOutputMoney(outputMoneyText.getText() != null?outputMoneyText.getText().toString():"");
		userInfo.setRedirect(redirectText.getText() != null?redirectText.getText().toString():"");
		userInfo.setWorks(worktText.getText() != null?worktText.getText().toString():"");
		
		File file = new File(Utils.CACHEDIR + Utils.USER_INFO);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		finished();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.user_edit_commit_id:
			commitUserInfo();
			break;
		case R.id.user_edit_city_id:
			Intent intent = new Intent(this,City_cnActivity.class);
			startActivityForResult(intent, City_cnActivity.CITY);
			break;
		case R.id.user_edit_curstatus_id:
			dialog = createDialog(v.getId(),
					this.getResources().getStringArray(R.array.userinfo_current_status));
			dialog.show();
			break;
		case R.id.user_edit_redirect_id:
			dialog = createDialog(v.getId(),this.getResources().getStringArray(R.array.userinfo_redirect));
			dialog.show();
			break;
		case R.id.user_edit_attention_id:
			dialog = createDialog(v.getId(),this.getResources().getStringArray(R.array.userinfo_attention));
			dialog.show();
			break;
		case R.id.user_edit_keepmoney_id:
			dialog = createDialog(v.getId(),this.getResources().getStringArray(R.array.userinfo_keepmoney));
			dialog.show();
			break;
		case R.id.user_edit_outputmoney_id:
			dialog = createDialog(v.getId(),this.getResources().getStringArray(R.array.userinfo_outputmoney));
			dialog.show();
			break;
		case R.id.user_edit_email_id:
			
			break;
		case R.id.user_edit_work_id:
			Intent workIntent = new Intent(this,WorkHistoryActivity.class);
			startActivityForResult(workIntent,WORK);
			break;
		case R.id.user_edit_education_id:
			Intent eduIntent = new Intent(this,EducationHistoryActivity.class);
			startActivityForResult(eduIntent,EDUCATION);
			break;
		default:
			break;
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(data == null)return;
		switch (requestCode) {
		case City_cnActivity.CITY:
			String value = data.getStringExtra("cityvalue");
			if(!TextUtils.isEmpty(value)){
				cityText.setText(value);
			}
			break;
		case WORK:
			String[] workinfo = data.getStringArrayExtra("workinfo");
			if(workinfo != null && workinfo.length>0){
				worktText.setText(workinfo[0]+" "+workinfo[1]+" "+workinfo[2]);
			}
			break;
		case EDUCATION:
			String[] educationinfo = data.getStringArrayExtra("educationinfo");
			if(educationinfo != null && educationinfo.length>0){
				educationText.setText(educationinfo[0]+" "+educationinfo[1]+" "+educationinfo[2]);
			}
			break;
		default:
			break;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	@SuppressLint("NewApi")
	private Dialog createDialog(final int viewID,final String[] values){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);  
		builder.setItems(values, new DialogInterface.OnClickListener() {  
		    public void onClick(DialogInterface dialog, int item) {  
		        Toast.makeText(getApplicationContext(), values[item], Toast.LENGTH_SHORT).show();  
		        showMyDialog(viewID,values[item]);
		        dialog.dismiss();
		    }  
		});  
		 AlertDialog alert = builder.create(); 
		 return alert;
	}
	
	
	private void showMyDialog(int viewid,String value){
		switch (viewid) {
		case R.id.user_edit_curstatus_id:
			statusText.setText(value);
			break;
		case R.id.user_edit_redirect_id:
			redirectText.setText(value);
			break;
		case R.id.user_edit_attention_id:
			attentionText.setText(value);
			break;
		case R.id.user_edit_keepmoney_id:
			keepMoneyText.setText(value);
			break;
		case R.id.user_edit_outputmoney_id:
			outputMoneyText.setText(value);
			break;
		default:
			break;
		}
	}
}
