package com.beijing.together.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class HorizontalScrollViewAdapter<T>
{

	protected Context mContext;
	protected LayoutInflater mInflater;
	protected List<T> mDatas;

	public HorizontalScrollViewAdapter(Context context, List<T> mDatas)
	{
		this.mContext = context;
		mInflater = LayoutInflater.from(context);
		this.mDatas = mDatas;
	}

	public int getCount()
	{
		return mDatas.size();
	}

	public Object getItem(int position)
	{
		return mDatas.get(position);
	}

	public long getItemId(int position)
	{
		return position;
	}

	public abstract View getView(int position, View convertView, ViewGroup parent);
}
