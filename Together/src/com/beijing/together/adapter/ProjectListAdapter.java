package com.beijing.together.adapter;

import java.util.List;

import org.w3c.dom.Text;

import com.beijing.together.R;
import com.beijing.together.entity.Project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class ProjectListAdapter extends BaseAdapter {

	private Context mContext = null;
	private LayoutInflater mInflater = null;
	private List<Project> dataList;

	public void setDataList(List<Project> dataList) {
		this.dataList = dataList;
	}

	public ProjectListAdapter(Context cxt,List<Project> datalist) {
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
		Project ject = dataList.get(position);
		if(convertView == null){
			vHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.project_list_item,null);
			vHolder.photoImageView = (ImageView)convertView.findViewById(R.id.project_photo_id);
			vHolder.nameTextView = (TextView)convertView.findViewById(R.id.project_name_id);
			vHolder.redirctTextView = (TextView)convertView.findViewById(R.id.project_direct_id);
			vHolder.descTextView = (TextView)convertView.findViewById(R.id.project_desc_id);
			vHolder.progressBar = (ProgressBar)convertView.findViewById(R.id.project_fininace_id);
			vHolder.fininaceTextView = (TextView)convertView.findViewById(R.id.project_fininace_desc_id);
			vHolder.incomeTextView = (TextView)convertView.findViewById(R.id.project_income_id);
			vHolder.overplusTextView = (TextView)convertView.findViewById(R.id.project_overplus_time_id);
			vHolder.ratingBar = (RatingBar)convertView.findViewById(R.id.ratingBar);
			vHolder.chatinfo = (TextView)convertView.findViewById(R.id.chat_info_id);
			vHolder.attentionTextView = (TextView)convertView.findViewById(R.id.attention_info_id);
			vHolder.collectionTextView = (TextView)convertView.findViewById(R.id.collection_info_id);
			vHolder.onlineTimeTextView = (TextView)convertView.findViewById(R.id.time_info_id);
			convertView.setTag(vHolder);
		}else{
			vHolder = (ViewHolder)convertView.getTag();
		}
		vHolder.photoImageView.setImageResource(R.drawable.my_name);
		vHolder.nameTextView.setText(ject.getProjectName());
		vHolder.redirctTextView.setText(ject.getRedirect());
		vHolder.descTextView.setText(ject.getProjectDec());
		int result = caculateFinace(ject);
		vHolder.progressBar.setProgress(result);
		vHolder.fininaceTextView.setText("预融资"+ject.getPre_finance()+"万  (已融资"+ject.getHad_finance()+"万)");
		if(ject.isIncome()){
			vHolder.incomeTextView.setVisibility(View.VISIBLE);;
		}
		vHolder.overplusTextView.setText("剩余"+ject.getOverPlusTime()+"天");
		vHolder.ratingBar.setRating(ject.getMemeberIndex());
		vHolder.chatinfo.setText(String.valueOf(ject.getMessageNum()));
		vHolder.attentionTextView.setText(String.valueOf(ject.getAttention()));
		vHolder.collectionTextView.setText(String.valueOf(ject.getCollection()));
		vHolder.onlineTimeTextView.setText(ject.getOnLineTime());
		return convertView;
	}
	
	
	private int caculateFinace(Project ject){
		int profininace = ject.getPre_finance();
		int hadfininace = ject.getHad_finance();
		float value = (float)hadfininace/profininace;
		value *= 100;
		int result = (int)value;
		return result>100?100:result;
	}
	
	public class ViewHolder{
		private ImageView photoImageView;
		private TextView nameTextView;
		private TextView redirctTextView;
		private TextView descTextView;
		private ProgressBar progressBar;
		private TextView fininaceTextView;
		private TextView incomeTextView;
		private TextView overplusTextView;
		private RatingBar ratingBar;
		private TextView chatinfo;
		private TextView attentionTextView;
		private TextView collectionTextView;
		private TextView onlineTimeTextView;
	}
}
