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

import com.beijing.together.R;
import com.beijing.together.activity.Constant;
import com.beijing.together.entity.UserInfo;
import com.beijing.together.entity.VisitorInfo;

public class VisitorListAdapter extends BaseAdapter {

	private Context mContext = null;
	private LayoutInflater mInflater = null;
	private List<VisitorInfo> dataList;

	public void setDataList(List<VisitorInfo> dataList) {
		this.dataList = dataList;
	}

	public VisitorListAdapter(Context cxt,List<VisitorInfo> datalist) {
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
		VisitorInfo visitorinfo = dataList.get(position);
		if(convertView == null){
			vHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.visitor_list_item,null);
			vHolder.photoImageView = (ImageView)convertView.findViewById(R.id.user_photo_id);
			vHolder.nameTextView = (TextView)convertView.findViewById(R.id.user_name_id);
			vHolder.cityTextView = (TextView)convertView.findViewById(R.id.user_city_id);
			vHolder.positionTextView = (TextView)convertView.findViewById(R.id.user_posiont_value_id);
			vHolder.companyTextView = (TextView)convertView.findViewById(R.id.user_company_value_id);
			vHolder.visitordomainTextView = (TextView)convertView.findViewById(R.id.user_vistordomain_value_id);
			vHolder.visitorIdeaTextView = (TextView)convertView.findViewById(R.id.user_visitoridea_value_id);
			vHolder.attentedValue = (TextView)convertView.findViewById(R.id.user_attented_value_id);
			vHolder.collectionValue = (TextView)convertView.findViewById(R.id.user_collection_value_id);
			vHolder.contactTextView = (TextView)convertView.findViewById(R.id.user_contact_others_id);
			vHolder.contactTextView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					String userid = (String)v.getTag(R.id.title_back_id);
			        RongIM.getInstance().startPrivateChat(mContext,userid,userid);
				}
			});
			convertView.setTag(vHolder);
		}else{
			vHolder = (ViewHolder)convertView.getTag();
		}
		
		vHolder.contactTextView.setTag(R.id.title_back_id,visitorinfo.getName());
		vHolder.photoImageView.setImageResource(R.drawable.my_name);
		vHolder.nameTextView.setText(visitorinfo.getName());
		vHolder.cityTextView.setText(visitorinfo.getCity());
		vHolder.positionTextView.setText(visitorinfo.getPosition());
		vHolder.companyTextView.setText(visitorinfo.getCompany());
		vHolder.visitordomainTextView.setText(visitorinfo.getVisitorDomain());
		vHolder.visitorIdeaTextView.setText(visitorinfo.getVisitorIdea());
		vHolder.attentedValue.setText(String.valueOf(visitorinfo.getAttented()));
		vHolder.collectionValue.setText(String.valueOf(visitorinfo.getCollection()));
		return convertView;
	}
	
	public class ViewHolder{
		private ImageView photoImageView;
		private TextView nameTextView;
		private TextView cityTextView;
		private TextView positionTextView;
		private TextView companyTextView;
		private TextView visitordomainTextView;
		private TextView visitorIdeaTextView;
		private TextView attentedValue;
		private TextView collectionValue;
		private TextView contactTextView;
	}
}
