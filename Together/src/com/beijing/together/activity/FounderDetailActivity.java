package com.beijing.together.activity;

import io.rong.imkit.RongIM;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.beijing.together.R;
import com.beijing.together.entity.Project;
import com.beijing.together.entity.UserInfo;

public class FounderDetailActivity extends BaseActivity implements OnClickListener{
	
	private ImageView back;
	private TextView title;
	private TextView partnertName;
	private TextView cityText;
	private TextView statusText;
	private TextView redirectText;
	private TextView attentionText;
	private TextView emailText;
	private TextView keepMoneyText;
	private TextView outputMoneyText;
	private TextView wishOptionText;
	private TextView worktText;
	private TextView educationText;
	private TextView descTextView;
	private TextView projectDescTextView;
	
	private ImageView titleCollection;
	private LinearLayout contact_llLayout;
	
	private UserInfo userinfo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.founder_detail_info);
		initView();
		userinfo = (UserInfo)getIntent().getSerializableExtra("partneritem");
		initData();
	}
	
	private void initView(){
		back = (ImageView)findViewById(R.id.title_back_id);
		titleCollection = (ImageView)findViewById(R.id.title_back_text_img_id);
		title = (TextView)findViewById(R.id.title_text_mid_id);
        partnertName = (TextView)findViewById(R.id.user_name_id);
		cityText = (TextView)findViewById(R.id.user_city_id);
		statusText = (TextView)findViewById(R.id.user_curstatus_id);
		redirectText = (TextView)findViewById(R.id.user_redirect_id);
		attentionText = (TextView)findViewById(R.id.user_attention_id);
		emailText = (TextView)findViewById(R.id.user_email_id);
		keepMoneyText = (TextView)findViewById(R.id.user_keepmoney_id);
		outputMoneyText = (TextView)findViewById(R.id.user_outputmoney_id);
		wishOptionText = (TextView)findViewById(R.id.user_info_wish_opion_id);
		worktText = (TextView)findViewById(R.id.user_work_time_id);
		educationText = (TextView)findViewById(R.id.user_education_time_id);
		descTextView = (TextView)findViewById(R.id.user_info_desc_id);
		projectDescTextView = (TextView)findViewById(R.id.user_info_project_desc_id);
		contact_llLayout = (LinearLayout)findViewById(R.id.user_info_contact_id);
		back.setOnClickListener(this);
		titleCollection.setOnClickListener(this);
		contact_llLayout.setOnClickListener(this);
	}
	
	private void initData(){
		title.setText(userinfo.getName());
		partnertName.setText(userinfo.getName());
		cityText.setText(userinfo.getCity());
		statusText.setText(userinfo.getCurrentStatus());
		redirectText.setText(userinfo.getPosition()+"合伙人");
		attentionText.setText(userinfo.getAttention());
		emailText.setText(userinfo.getEmail());
		keepMoneyText.setText(userinfo.getKeepMoney());
		outputMoneyText.setText(userinfo.getOutputMoney());
		wishOptionText.setText(userinfo.getWishOption());
		worktText.setText(userinfo.getWorks());
		educationText.setText(userinfo.getEducation());
		descTextView.setText(userinfo.getDesc());
		Project project = userinfo.getProject();
		projectDescTextView.setText(project != null?project.getProjectDec():"你还没有添加项目");
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.title_back_id:
			finished();
			break;
		case R.id.title_back_text_img_id:
			Toast.makeText(this,"收藏成功",Toast.LENGTH_SHORT).show();
			break;	
		case R.id.user_info_contact_id:
			RongIM.getInstance().startPrivateChat(this,userinfo.getName(),userinfo.getName());
			break;
		default:
			break;
		}
	}
}
