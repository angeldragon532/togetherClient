package com.beijing.together.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.beijing.together.R;
import com.beijing.together.entity.ActivityInfo;

public class ActivityInfoDetailActivity extends BaseActivity implements OnClickListener{
	
	private ImageView backView;
	private TextView titleView;
	private ImageView photoView;
	private TextView nameView;
	private TextView statusView;
	private TextView chiefView;
	private TextView startTimeView;
	private TextView endTimeView;
	private TextView addressView;
	private TextView partnumView;
	private TextView detailView;
	
	private LinearLayout commitInfo;
	
	private ActivityInfo activityinfo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activityinfo_detail);
		initView();
		activityinfo = (ActivityInfo)getIntent().getSerializableExtra("activityinfoitem");
		initData();
	}
	
	private void initView(){
		backView = (ImageView)findViewById(R.id.title_back_id);
		titleView = (TextView)findViewById(R.id.title_text_mid_id);
		photoView = (ImageView)findViewById(R.id.activityinfo_detail_photo_id);
		nameView = (TextView)findViewById(R.id.activityinfo_detail_name_id);
		statusView = (TextView)findViewById(R.id.activityinfo_detail_status_id);
		chiefView = (TextView)findViewById(R.id.activityinfo_detail_chief_id);
		startTimeView = (TextView)findViewById(R.id.activityinfo_detail_starttime_id);
		endTimeView = (TextView)findViewById(R.id.activityinfo_detail_endtime_id);
		addressView = (TextView)findViewById(R.id.activityinfo_detail_address_id);
		partnumView = (TextView)findViewById(R.id.activityinfo_detail_partnum_id);
		detailView = (TextView)findViewById(R.id.activityinfo_detail_desc_id);
		commitInfo = (LinearLayout)findViewById(R.id.activityinfo_detail_commit_id);
		
		backView.setOnClickListener(this);
		commitInfo.setOnClickListener(this);
	}
	
	private void initData(){
		titleView.setText("活动详情");
		photoView.setImageResource(R.drawable.my_name);
		nameView.setText(activityinfo.getName());
		statusView.setText(activityinfo.getStatus());
		chiefView.setText(activityinfo.getCheifer());
		startTimeView.setText(activityinfo.getStartTime());
		endTimeView.setText(activityinfo.getEndTime());
		addressView.setText(activityinfo.getAddress());
		partnumView.setText(activityinfo.getTarkNum());
		detailView.setText(activityinfo.getDetail());
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.title_back_id:
			finished();
			break;
		case R.id.activityinfo_detail_commit_id:
			Toast.makeText(this,"成功参与活动",Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
	}
	
}
