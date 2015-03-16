package com.beijing.together.adapter;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beijing.together.R;
import com.beijing.together.entity.ProjectPartnerInfo;

public class NeedPartnerHorizontalScrollViewAdapter extends HorizontalScrollViewAdapter {

	private Context context;

	public NeedPartnerHorizontalScrollViewAdapter(Context context,
			List<ProjectPartnerInfo> mDatas) {
		super(context, mDatas);
		this.context = context;
	}

	@SuppressLint("ResourceAsColor")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(mDatas == null || mDatas.size() == 0)return null;
		ProjectPartnerViewHolder vHolder;
		ProjectPartnerInfo info = (ProjectPartnerInfo)mDatas.get(position);
		if(convertView == null){
			vHolder = new ProjectPartnerViewHolder();
			LinearLayout llLayout = new LinearLayout(context);
			llLayout.setClickable(true);
			llLayout.setGravity(Gravity.CENTER);
			llLayout.setBackgroundResource(R.drawable.project_partner_bg_img);
			llLayout.setOrientation(LinearLayout.VERTICAL);
			LinearLayout.LayoutParams parmas = new LinearLayout.LayoutParams(
					new LinearLayout.LayoutParams(
							LinearLayout.LayoutParams.WRAP_CONTENT,
							LinearLayout.LayoutParams.WRAP_CONTENT));
			parmas.setMargins(3, 3, 3, 3);
			llLayout.setLayoutParams(parmas);
			
			TextView tvrole = new TextView(context);
			tvrole.setText(info.getRoleName());
			tvrole.setTextColor(R.color.project_partner_text_color);
			tvrole.setTextSize(14);
			tvrole.setGravity(Gravity.CENTER);
		
			TextView tv = new TextView(context);
			tv.setText("’ŸªΩ÷–");
			tv.setTextColor(R.color.project_partner_text_color);
			tv.setTextSize(14);
			tv.setGravity(Gravity.CENTER);
			
			llLayout.addView(tvrole, new LinearLayout.LayoutParams
					(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
			llLayout.addView(tv, new LinearLayout.LayoutParams
					(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
			
			convertView = llLayout;
			convertView.setTag(vHolder);
		}else{
			vHolder = (ProjectPartnerViewHolder)convertView.getTag();
		}	
		return convertView;
	}

	private class ProjectPartnerViewHolder {
		LinearLayout llLayout;
	}

}
