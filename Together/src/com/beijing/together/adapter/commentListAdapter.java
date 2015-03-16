package com.beijing.together.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.beijing.together.R;
import com.beijing.together.entity.CommentInfo;

public class commentListAdapter extends BaseAdapter {

	private Context mContext = null;
	private LayoutInflater mInflater = null;
	private List<CommentInfo> dataList;

	public void setDataList(List<CommentInfo> dataList) {
		this.dataList = dataList;
	}

	public commentListAdapter(Context cxt,List<CommentInfo> datalist) {
		mContext = cxt;
		mInflater = LayoutInflater.from(this.mContext);
		this.dataList = datalist;
	}
	
	@Override
	public int getCount() {
		return dataList.size();
	}

	@Override
	public Object getItem(int position) {
		return dataList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vHolder;
		CommentInfo commentinfo = dataList.get(position);
		if(convertView == null){
			vHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.comment_list_item,null);
			vHolder.photoImage = (ImageView)convertView.findViewById(R.id.comment_photo_id);
			vHolder.name = (TextView)convertView.findViewById(R.id.comment_name_id);
			vHolder.time = (TextView)convertView.findViewById(R.id.comment_time_id);
			vHolder.content = (TextView)convertView.findViewById(R.id.comment_content_id);
			convertView.setTag(vHolder);
		}else{
			vHolder = (ViewHolder)convertView.getTag();
		}
		vHolder.photoImage.setImageResource(R.drawable.my_name);
		vHolder.name.setText(commentinfo.getUsername());
		vHolder.time.setText(commentinfo.getTime());
		vHolder.content.setText(commentinfo.getContent());
		return convertView;
	}
	
	public class ViewHolder{
		private ImageView photoImage;
		private TextView name;
		private TextView time;
		private TextView content;
		
	}
}
