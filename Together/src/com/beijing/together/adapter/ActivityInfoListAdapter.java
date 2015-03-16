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
import com.beijing.together.entity.ActivityInfo;
import com.beijing.together.entity.UserInfo;
import com.beijing.together.entity.VisitorInfo;

public class ActivityInfoListAdapter extends BaseAdapter {

	private Context mContext = null;
	private LayoutInflater mInflater = null;
	private List<ActivityInfo> dataList;

	public void setDataList(List<ActivityInfo> dataList) {
		this.dataList = dataList;
	}

	public ActivityInfoListAdapter(Context cxt,List<ActivityInfo> datalist) {
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
		ActivityInfo activityInfo = dataList.get(position);
		if(convertView == null){
			vHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.activityinfo_list_item,null);
			vHolder.photoImageView = (ImageView)convertView.findViewById(R.id.activityinfo_photo_id);
			vHolder.nameTextView = (TextView)convertView.findViewById(R.id.activityinfo_name_id);
			vHolder.timeTextView = (TextView)convertView.findViewById(R.id.activityinfo_starttime_id);
			vHolder.attentedValue = (TextView)convertView.findViewById(R.id.activityinfo_attented_id);
			vHolder.addressTextView = (TextView)convertView.findViewById(R.id.activityinfo_address_id);
			convertView.setTag(vHolder);
		}else{
			vHolder = (ViewHolder)convertView.getTag();
		}
		vHolder.photoImageView.setImageResource(R.drawable.my_name);
		vHolder.nameTextView.setText(activityInfo.getName());
		vHolder.timeTextView.setText(activityInfo.getStartTime());
		vHolder.addressTextView.setText(activityInfo.getAddress());
		vHolder.attentedValue.setText(activityInfo.getAttetion());;
		return convertView;
	}
	
	public class ViewHolder{
		private ImageView photoImageView;
		private TextView nameTextView;
		private TextView attentedValue;
		private TextView timeTextView;
		private TextView addressTextView;
	}
}
