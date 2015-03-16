package com.beijing.together.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.beijing.together.R;
import com.beijing.together.activity.widget.MyHorizontalScrollView;
import com.beijing.together.adapter.NeedPartnerHorizontalScrollViewAdapter;
import com.beijing.together.adapter.ProjectHorizontalScrollViewAdapter;
import com.beijing.together.adapter.commentListAdapter;
import com.beijing.together.entity.CommentInfo;
import com.beijing.together.entity.Project;
import com.beijing.together.entity.ProjectBasic;
import com.beijing.together.entity.ProjectBasicProduct;
import com.beijing.together.entity.ProjectProduct;

public class ProjectDetailActivity extends BaseActivity implements OnClickListener{
	
	private MyHorizontalScrollView mHorizontalScrollView;
	private ProjectHorizontalScrollViewAdapter mAdapter;
	private List<ProjectBasic> mDatas = new ArrayList<ProjectBasic>();
	
	private ImageView back;
	private TextView title;
	private TextView rightOperator;
	private TextView projectName;
	private TextView projectIncomeStatus;
	private TextView projectFinice;
	private TextView projectOnline;
	//private TextView projectCity;
	private TextView projectDesc;
	//private TextView projectRedirect;
	
	
	private LinearLayout projectDecll;
//	private ImageView arraw_ll;
	private ImageView arraw_usercase;
	private ImageView arraw_markeknow;
	private ImageView arraw_projectwell;
	private ImageView arraw_businessmodel;
	private ImageView arraw_developerplan;
	
	private LinearLayout ll_usercase;
	private LinearLayout ll_marketnow;
	private LinearLayout ll_projectWell;
	private LinearLayout ll_businessModel;
	private LinearLayout ll_developerplan;
	
	private boolean usercase;
	private boolean markeknow;
	private boolean projectwell;
	private boolean businesmode;
	private boolean developerplan;
	
	private MyHorizontalScrollView myNeedPartnerHorizontalView;
	private NeedPartnerHorizontalScrollViewAdapter needPartnerAdapter;
	private ImageView left_iv;
	private ImageView right_iv;
	
	private ListView commentListView;
	private commentListAdapter commentListAdapter;
	private ImageView commentImage;
	
	private Project project;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.project_detail);
		initView();
		project = (Project)getIntent().getSerializableExtra("projectitem");
		initData();
		mAdapter = new ProjectHorizontalScrollViewAdapter(this, mDatas);
		needPartnerAdapter = new NeedPartnerHorizontalScrollViewAdapter(this,project.getPartnerList());
		mHorizontalScrollView.setCurrentImageChangeListener(new MyHorizontalScrollView.CurrentImageChangeListener()
			{
				@Override
				public void onCurrentImgChanged(int position,
						View viewIndicator)
				{
//					viewIndicator.setBackgroundColor(Color
//							.parseColor("#AA024DA4"));
				}
			});
		mHorizontalScrollView.setOnItemClickListener(new MyHorizontalScrollView.OnItemClickListener()
		{

			@Override
			public void onClick(View view, int position)
			{
//				view.setBackgroundColor(Color.parseColor("#AA024DA4"));
			}
		});
		mHorizontalScrollView.initDatas(mAdapter);
		myNeedPartnerHorizontalView.initDatas(needPartnerAdapter);
	}
	
	private void initView(){
		back = (ImageView)findViewById(R.id.title_back_id);
		title = (TextView)findViewById(R.id.title_text_mid_id);
		rightOperator = (TextView)findViewById(R.id.title_back_text_text_right_id);
		mHorizontalScrollView = (MyHorizontalScrollView) findViewById(R.id.id_horizontalScrollView);
        projectName = (TextView)findViewById(R.id.project_detail_name_id);
        projectIncomeStatus = (TextView)findViewById(R.id.project_detail_incomestatus_id);
        projectFinice = (TextView)findViewById(R.id.project_detail_finance_id);
        projectOnline = (TextView)findViewById(R.id.project_detail_onlinestatus_id);
        //projectCity = (TextView)findViewById(R.id.project_detail_city_id);
        projectDesc = (TextView)findViewById(R.id.project_detail_desc_id);
        //projectRedirect = (TextView)findViewById(R.id.project_detail_redirect_id);
        
        projectDecll = (LinearLayout)findViewById(R.id.project_detail_desc_content_ll_id);
        //arraw_ll = (ImageView)findViewById(R.id.project_detail_desc_arrow_ll_id);
        arraw_usercase = (ImageView)findViewById(R.id.project_detail_desc_arrow_usercase_id);
        arraw_markeknow = (ImageView)findViewById(R.id.project_detail_desc_arrow_marketknow_id);
        arraw_projectwell = (ImageView)findViewById(R.id.project_detail_desc_arrow_projectwell_id);
        arraw_businessmodel = (ImageView)findViewById(R.id.project_detail_desc_arrow_businessmodel_id);
        arraw_developerplan = (ImageView)findViewById(R.id.project_detail_desc_arrow_developplan_id);
        
        ll_usercase = (LinearLayout)findViewById(R.id.project_detail_desc_content_usercase_id);
    	ll_marketnow = (LinearLayout)findViewById(R.id.project_detail_desc_content_marketknow_id);
    	ll_projectWell = (LinearLayout)findViewById(R.id.project_detail_desc_content_projectwell_id);
    	ll_businessModel = (LinearLayout)findViewById(R.id.project_detail_desc_content_businessmodel_id);
    	ll_developerplan = (LinearLayout)findViewById(R.id.project_detail_desc_content_develpeplan_id);
    	
    	//viewPager = (ViewPager)findViewById(R.id.vPager);
    	myNeedPartnerHorizontalView = (MyHorizontalScrollView)findViewById(R.id.id_horizontalScrollView_partener);
    	left_iv = (ImageView)findViewById(R.id.project_detail_arrow_left_id);
    	right_iv = (ImageView)findViewById(R.id.project_detail_arrow_right_id);
        
    	commentListView = (ListView)findViewById(R.id.project_detail_comment_list_id);
    	commentImage = (ImageView)findViewById(R.id.project_detail_comment_arrow_id);
    	
        back.setOnClickListener(this);
//        arraw_ll.setOnClickListener(this);
        arraw_usercase.setOnClickListener(this);	
        arraw_markeknow.setOnClickListener(this);
        arraw_projectwell.setOnClickListener(this);
        arraw_businessmodel.setOnClickListener(this);
        arraw_developerplan.setOnClickListener(this);
        left_iv.setOnClickListener(this);
        right_iv.setOnClickListener(this);
        commentImage.setOnClickListener(this);
	}
	
	private void initData(){	
		mDatas.addAll(ProjectBasicProduct.productList(10));
		title.setText(project.getProjectName());
		projectName.setText(project.getProjectName());
		projectIncomeStatus.setText(project.isIncome()?"已盈利":"未盈利");
		projectFinice.setText(project.getHad_finance()>0?"已融资金"+project.getHad_finance()+"万":"未融资");
		projectOnline.setText(project.isOnline()?"已上线运营":"未上线");
		//projectCity.setText("地址  "+project.getCity());
		projectDesc.setText(project.getProjectDec());
		//projectRedirect.setText(project.getRedirect());
		
		List<CommentInfo> commentInfos = new ArrayList<CommentInfo>();
		commentInfos.addAll(getCommentInfos());
		commentListAdapter = new commentListAdapter(this,commentInfos);
		commentListView.setAdapter(commentListAdapter);
		//setListViewHeightBasedOnChildren(commentListView);
	}
	
//	@SuppressLint("ResourceAsColor")
//	private List<View> productView(List<ProjectPartnerInfo> infos){
//		List<View> views = new ArrayList<View>();
//		if(infos != null){
//			for(ProjectPartnerInfo info:infos){
//				LinearLayout llLayout = new LinearLayout(this);
//				llLayout.setClickable(true);
//				llLayout.setGravity(Gravity.CENTER);
//				llLayout.setBackgroundColor(R.drawable.project_partner_bg_img);
//				llLayout.setOrientation(LinearLayout.VERTICAL);
//				
//				TextView tvrole = new TextView(this);
//				tvrole.setText(info.getRoleName());
//				tvrole.setTextColor(R.color.project_partner_text_color);
//				tvrole.setTextSize(16);
//				tvrole.setGravity(Gravity.CENTER);
//				
//				TextView tv = new TextView(this);
//				tv.setText("召唤中");
//				tv.setTextColor(R.color.project_partner_text_color);
//				tv.setTextSize(16);
//				tv.setGravity(Gravity.CENTER);
//				
//				
//				llLayout.addView(tv, new LinearLayout.LayoutParams
//						(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
//				llLayout.addView(tvrole, new LinearLayout.LayoutParams
//						(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
//				
//				views.add(llLayout);
//			}
//		}
//		return views;
//	}
	
	private List<CommentInfo> getCommentInfos(){
		ArrayList<CommentInfo> commentInfos = new ArrayList<CommentInfo>();
		for(int i=0;i<5;i++){
			CommentInfo info = new CommentInfo();
			info.setContent("这个撒旦反对司法的阿三地方地方撒");
			info.setTime("今天上午");
			info.setUsername("longlong");
			commentInfos.add(info);
		}
		return commentInfos;
	}
	

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.title_back_id:
			finished();
			break;
		case R.id.id_horizontalScrollView:
					
			break;
		case R.id.title_back_text_text_right_id:
			Toast.makeText(this,"投资成功",Toast.LENGTH_SHORT).show();
			break;
		case R.id.project_detail_comment_arrow_id:
			if(commentListView.getVisibility() == View.VISIBLE){
				commentListView.setVisibility(View.GONE);
				commentImage.setImageResource(R.drawable.arrow_up_grey);
			}else{
				commentListView.setVisibility(View.VISIBLE);
				commentImage.setImageResource(R.drawable.arrow_down_grey);
			}
			break;
//		case R.id.project_detail_desc_arrow_ll_id:
//			if(projectDecll.getVisibility() == View.VISIBLE){
//				projectDecll.setVisibility(View.GONE);
//				arraw_ll.setImageResource(android.R.drawable.arrow_up_float);
//			}else{
//				projectDecll.setVisibility(View.VISIBLE);
//				arraw_ll.setImageResource(android.R.drawable.arrow_down_float);
//			}
//			break;
		case R.id.project_detail_desc_arrow_usercase_id:
			if(usercase){
				arraw_usercase.setImageResource(R.drawable.arrow_up_grey);
				ll_usercase.setVisibility(View.GONE);
				usercase = false;
			}else{
				arraw_usercase.setImageResource(R.drawable.arrow_down_grey);
				ll_usercase.setVisibility(View.VISIBLE);
				usercase = true;
			}
			break;
		case R.id.project_detail_desc_arrow_marketknow_id:
			if(markeknow){
				arraw_markeknow.setImageResource(R.drawable.arrow_up_grey);
				ll_marketnow.setVisibility(View.GONE);
				markeknow = false;
			}else{
				arraw_markeknow.setImageResource(R.drawable.arrow_down_grey);
				ll_marketnow.setVisibility(View.VISIBLE);
				markeknow = true;
			}
			break;
		case R.id.project_detail_desc_arrow_projectwell_id:
			if(projectwell){
				arraw_projectwell.setImageResource(R.drawable.arrow_up_grey);
				ll_projectWell.setVisibility(View.GONE);
				projectwell = false;
			}else{
				arraw_projectwell.setImageResource(R.drawable.arrow_down_grey);
				ll_projectWell.setVisibility(View.VISIBLE);
				projectwell = true;
			}
			
			break;
		case R.id.project_detail_desc_arrow_businessmodel_id:
			if(businesmode){
				arraw_businessmodel.setImageResource(R.drawable.arrow_up_grey);
				ll_businessModel.setVisibility(View.GONE);
				businesmode = false;
			}else{
				arraw_businessmodel.setImageResource(R.drawable.arrow_down_grey);
				ll_businessModel.setVisibility(View.VISIBLE);
				businesmode = true;
			}
			break;
		case R.id.project_detail_desc_arrow_developplan_id:
			if(developerplan){
				arraw_developerplan.setImageResource(R.drawable.arrow_up_grey);
				developerplan = false;
				ll_developerplan.setVisibility(View.GONE);
			}else{
				arraw_developerplan.setImageResource(R.drawable.arrow_down_grey);
				developerplan = true;
				ll_developerplan.setVisibility(View.VISIBLE);
			}
			break;
		case R.id.project_detail_arrow_left_id:
			myNeedPartnerHorizontalView.loadPreImg();
			//viewPager.setCurrentItem(viewPager.getCurrentItem()-1==0?0:viewPager.getCurrentItem()-1);
			break;
		case R.id.project_detail_arrow_right_id:
			myNeedPartnerHorizontalView.loadNextImg();
//			viewPager.setCurrentItem(viewPager.getCurrentItem()+1==viewPager.getChildCount()?
//					viewPager.getCurrentItem():viewPager.getCurrentItem()+1);
			break;
		default:
			break;
		}
	}
	
	  public static void setListViewHeightBasedOnChildren(ListView listView) {
          ListAdapter listAdapter = listView.getAdapter(); 
          if (listAdapter == null) {
              // pre-condition
              return;
          }
          int totalHeight = 0;
          for (int i = 0; i < listAdapter.getCount(); i++) {
              View listItem = listAdapter.getView(i, null, listView);
              listItem.measure(0, 0);
              totalHeight += listItem.getMeasuredHeight();
          }

          ViewGroup.LayoutParams params = listView.getLayoutParams();
          params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
          listView.setLayoutParams(params);
      }
}
