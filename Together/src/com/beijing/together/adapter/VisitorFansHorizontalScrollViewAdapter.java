package com.beijing.together.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.beijing.together.R;
import com.beijing.together.entity.VisitorInfo;

public class VisitorFansHorizontalScrollViewAdapter extends HorizontalScrollViewAdapter {


	public VisitorFansHorizontalScrollViewAdapter(Context context,
			List<VisitorInfo> mDatas) {
		super(context, mDatas);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(mDatas == null || mDatas.size() == 0)return null;
		VisitorFansViewHolder viewHolder = null;
		VisitorInfo info = (VisitorInfo)mDatas.get(position);
		if (convertView == null) {
			viewHolder = new VisitorFansViewHolder();
			convertView = mInflater.inflate(
					R.layout.activity_index_gallery_item, parent, false);
			viewHolder.mImg = (ImageView) convertView
					.findViewById(R.id.id_index_gallery_item_image);
			viewHolder.mText = (TextView) convertView
					.findViewById(R.id.id_index_gallery_item_text);
			viewHolder.descText = (TextView) convertView
					.findViewById(R.id.id_index_gallery_item_desc);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (VisitorFansViewHolder) convertView.getTag();
		}
		viewHolder.mImg.setImageResource(R.drawable.my_name);
		viewHolder.mText.setText(info.getName());
		viewHolder.descText.setText(info.getPosition());

		return convertView;
	}

	private class VisitorFansViewHolder {
		ImageView mImg;
		TextView mText;
		TextView descText;
	}

}
