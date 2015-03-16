package com.beijing.together.activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.beijing.together.R;
import com.beijing.together.activity.widget.MyHorizontalScrollView;
import com.beijing.together.adapter.HorizontalScrollViewAdapter;
import com.beijing.together.adapter.VisitorFansHorizontalScrollViewAdapter;
import com.beijing.together.entity.Project;
import com.beijing.together.entity.VisitorInfo;
import com.beijing.together.entity.VisitorInfoProduct;

public class VisitorDetailActivity extends BaseActivity implements OnClickListener{
	
	private MyHorizontalScrollView mHorizontalScrollView;
	private HorizontalScrollViewAdapter mAdapter;
//	private List<Integer> mDatas = new ArrayList<Integer>(Arrays.asList(
//			R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d,
//			R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h,
//			R.drawable.l));
	private List<VisitorInfo> mDatas  = new ArrayList<VisitorInfo>();
	
	private ImageView back;
	private TextView title;
	private ImageView collecteImageView;
	private ImageView photo;
	private TextView visitorname;
	private TextView visitorCompany;
	private TextView visitorChiefDesc;
	private TextView visitorCity;
	private TextView visitorChat;
	private TextView visitorAttetion;
	private TextView visitorCollection;
	private TextView visitorIdea;
	private TextView visitorOther;
	
	private ImageView fensiArraw;
	private VisitorInfo visitorinfo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.visitor_detail);
		initView();
		visitorinfo = (VisitorInfo)getIntent().getSerializableExtra("visitoritem");
		initData();
		mAdapter = new VisitorFansHorizontalScrollViewAdapter(this, mDatas);
		mHorizontalScrollView.setOnItemClickListener(new MyHorizontalScrollView.OnItemClickListener(){
			@Override
			public void onClick(View view, int position){
//				view.setBackgroundColor(Color.parseColor("#AA024DA4"));
			}
		});
		mHorizontalScrollView.initDatas(mAdapter);
	}
	
	private void initView(){
		back = (ImageView)findViewById(R.id.title_back_id);
		title = (TextView)findViewById(R.id.title_text_mid_id);
		collecteImageView = (ImageView)findViewById(R.id.title_back_text_img_id);
		photo = (ImageView)findViewById(R.id.visitor_detail_photo_id);
		visitorname = (TextView)findViewById(R.id.visitor_detail_name_id);
		visitorCompany = (TextView)findViewById(R.id.visitor_detail_company_info_id);
		visitorChiefDesc = (TextView)findViewById(R.id.visitor_detail_chifedesc_id);
		visitorCity = (TextView)findViewById(R.id.visitor_detail_city_id);
		visitorChat = (TextView)findViewById(R.id.visitor_detail_chat_id);
		visitorAttetion = (TextView)findViewById(R.id.visitor_detail_attation_id);
		visitorCollection = (TextView)findViewById(R.id.visitor_detail_collection_id);
		visitorIdea = (TextView)findViewById(R.id.visitor_detail_idea_id);
		visitorOther = (TextView)findViewById(R.id.visitor_detail_others_id);
		fensiArraw = (ImageView)findViewById(R.id.visitor_detail_fensi_id);
		
		mHorizontalScrollView = (MyHorizontalScrollView) findViewById(R.id.id_horizontalScrollView);
        back.setOnClickListener(this);
        fensiArraw.setOnClickListener(this);
        collecteImageView.setOnClickListener(this);
	}
	
	private void initData(){
		mDatas.addAll(VisitorInfoProduct.productList(10));
		title.setText("罗月");
		collecteImageView.setImageResource(R.drawable.collection);
		photo.setImageResource(R.drawable.my_name);
	    visitorname.setText(visitorinfo.getName());
	    visitorCompany.setText(visitorinfo.getCompany());
	    visitorChiefDesc.setText(visitorinfo.getCheifDesc());
	    visitorCity.setText(visitorinfo.getCity());
	    visitorAttetion.setText(String.valueOf(visitorinfo.getAttented()));
	    visitorCollection.setText(String.valueOf(visitorinfo.getCollection()));
	    visitorIdea.setText(visitorinfo.getVisitorIdea());
	    visitorOther.setText(visitorinfo.getDoVocation());
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.title_back_id:
			finished();
			break;
		case R.id.id_horizontalScrollView:
					
			break;
		case R.id.visitor_detail_fensi_id:
			if(View.VISIBLE == mHorizontalScrollView.getVisibility()){
				mHorizontalScrollView.setVisibility(View.GONE);
				fensiArraw.setImageResource(R.drawable.arrow_up);
			}else{
				mHorizontalScrollView.setVisibility(View.VISIBLE);
				fensiArraw.setImageResource(R.drawable.arrow_down);
			}
			break;
		case R.id.title_back_text_img_id:
			Toast.makeText(this,"关注成功",Toast.LENGTH_SHORT).show();
			break;
		case R.id.project_detail_desc_arrow_usercase_id:
			break;
		case R.id.project_detail_desc_arrow_marketknow_id:
			break;
		case R.id.project_detail_desc_arrow_projectwell_id:
			
			break;
		case R.id.project_detail_desc_arrow_businessmodel_id:
			break;
		case R.id.project_detail_desc_arrow_developplan_id:
			break;
		default:
			break;
		}
	}
	
}
