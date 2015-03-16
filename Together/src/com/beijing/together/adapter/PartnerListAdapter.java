package com.beijing.together.adapter;

import io.rong.imkit.RongIM;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.beijing.together.R;
import com.beijing.together.activity.Constant;
import com.beijing.together.entity.UserInfo;

public class PartnerListAdapter extends BaseAdapter {

	private Context mContext = null;
	private LayoutInflater mInflater = null;
	private List<UserInfo> dataList;

	public void setDataList(List<UserInfo> dataList) {
		this.dataList = dataList;
	}

	public PartnerListAdapter(Context cxt,List<UserInfo> datalist) {
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
		final UserInfo userinfo = dataList.get(position);
		if(convertView == null){
			vHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.partner_list_item,null);
			vHolder.photoImageView = (ImageView)convertView.findViewById(R.id.user_photo_id);
			vHolder.nameTextView = (TextView)convertView.findViewById(R.id.user_name_id);
			vHolder.cityTextView = (TextView)convertView.findViewById(R.id.user_city_id);
			vHolder.redirctTextView = (TextView)convertView.findViewById(R.id.user_redirect_id);
			vHolder.creatStausTextView = (TextView)convertView.findViewById(R.id.user_createStatus_id);
			vHolder.positionTextView = (TextView)convertView.findViewById(R.id.user_posiont_value_id);
			vHolder.workTextView = (TextView)convertView.findViewById(R.id.user_work_value_id);
			vHolder.workTimeTextView = (TextView)convertView.findViewById(R.id.user_worktime_value_id);
			vHolder.downTextView = (TextView)convertView.findViewById(R.id.user_done_value_id);
			vHolder.skillTextView = (TextView)convertView.findViewById(R.id.user_skill_value_id);
			vHolder.attendTextView = (TextView)convertView.findViewById(R.id.user_note_value_id);
			vHolder.attentedValue = (TextView)convertView.findViewById(R.id.user_attented_value_id);
			vHolder.collectionValue = (TextView)convertView.findViewById(R.id.user_collection_value_id);
			vHolder.contactTextView = (TextView)convertView.findViewById(R.id.user_contact_others_id);
			vHolder.contactTextView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					String name = (String)v.getTag(R.id.title_back_id);
			        RongIM.getInstance().startPrivateChat(mContext,name,name);
				}
			});
			convertView.setTag(vHolder);
		}else{
			vHolder = (ViewHolder)convertView.getTag();
		}
		
		vHolder.contactTextView.setTag(R.id.title_back_id, userinfo.getName());
		
		vHolder.photoImageView.setImageResource(R.drawable.my_name);
		vHolder.nameTextView.setText(userinfo.getName());
		vHolder.cityTextView.setText(userinfo.getCity());
		vHolder.redirctTextView.setText(userinfo.getRedirect());
		vHolder.creatStausTextView.setText(userinfo.getCurrentStatus());
		vHolder.positionTextView.setText(userinfo.getPosition());
		vHolder.workTextView.setText(userinfo.getWorks());
		vHolder.workTimeTextView.setText(userinfo.getWorkTime());
		vHolder.downTextView.setText(userinfo.getDoVocation());
		vHolder.skillTextView.setText(userinfo.getSkill());
		vHolder.attendTextView.setText(userinfo.getAttention());
		vHolder.attentedValue.setText(String.valueOf(userinfo.getAttented()));
		vHolder.collectionValue.setText(String.valueOf(userinfo.getCollection()));
		
		return convertView;
	}
	
	public class ViewHolder{
		private ImageView photoImageView;
		private TextView nameTextView;
		private TextView cityTextView;
		private TextView redirctTextView;
		private TextView creatStausTextView;
		private TextView positionTextView;
		private TextView workTextView;
		private TextView workTimeTextView;
		private TextView downTextView;
		private TextView skillTextView;
		private TextView attendTextView;
		private TextView attentedValue;
		private TextView collectionValue;
		private TextView contactTextView;
	}
}
