package com.beijing.together.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.beijing.together.R;
import com.beijing.together.entity.Project;
import com.beijing.together.entity.ProjectBasic;
import com.beijing.together.entity.VisitorInfo;

public class ProjectHorizontalScrollViewAdapter extends HorizontalScrollViewAdapter {


	public ProjectHorizontalScrollViewAdapter(Context context,
			List<ProjectBasic> mDatas) {
		super(context, mDatas);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(mDatas == null || mDatas.size() == 0)return null;
		VisitorFansViewHolder viewHolder = null;
		ProjectBasic info = (ProjectBasic)mDatas.get(position);
		if (convertView == null) {
			viewHolder = new VisitorFansViewHolder();
			convertView = mInflater.inflate(
					R.layout.activity_index_gallery_item, parent, false);
			viewHolder.mImg = (ImageView) convertView
					.findViewById(R.id.id_index_gallery_item_image);
			viewHolder.mText = (TextView) convertView
					.findViewById(R.id.id_index_gallery_item_text);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (VisitorFansViewHolder) convertView.getTag();
		}
		viewHolder.mImg.setImageResource(R.drawable.my_name);
		viewHolder.mText.setText(info.getName());

		return convertView;
	}

	private class VisitorFansViewHolder {
		ImageView mImg;
		TextView mText;
	}

}
