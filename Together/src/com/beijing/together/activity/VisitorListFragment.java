package com.beijing.together.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.alibaba.fastjson.JSON;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.beijing.together.R;
import com.beijing.together.activity.widget.XListView;
import com.beijing.together.activity.widget.XListView.IXListViewListener;
import com.beijing.together.adapter.VisitorListAdapter;
import com.beijing.together.entity.UserInfo;
import com.beijing.together.entity.VisitorInfo;
import com.beijing.together.entity.VisitorInfoProduct;
import com.beijing.together.utils.DialogUtils;

public class VisitorListFragment extends BaseFragment implements IXListViewListener{
	
	// Xlist�б����
	private XListView xListView = null;
	private List<VisitorInfo> dataList = new ArrayList<VisitorInfo>();
	private VisitorListAdapter adapter;
	private static int pageIndex=1;
	private static int pageSize = 5;//ÿ��������������
	
	private static int LOADING_SUCESS = 1;
	private static int LOADING_FAILURE = 2;
	
	private Handler mhandler = new Handler(){
		public void handleMessage(Message msg) {
			if(dialog != null || dialog.isShowing()){
				dialog.dismiss();
			}
			switch (msg.what) {
			case 1:
				if(adapter != null){
					adapter.notifyDataSetChanged();
				}
				break;
			case 2:
				break;
			default:
				break;
			}
		};
	};
	
	private static Dialog dialog;
	private static View viewRoot;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
		 if(viewRoot == null){
			   viewRoot = inflater.inflate(R.layout.project_list,null);  
			   initView(viewRoot);
			   dialog = DialogUtils.createProgressDialog(this.getActivity());
			   requestPartner(false);
		   }
		   ViewGroup paretent = (ViewGroup)viewRoot.getParent();
		   if(paretent != null){
			   paretent.removeView(viewRoot);
		   }
		   return viewRoot;
	}
	
	private void requestPartner(final boolean isAddMore){
		Request sr = new StringRequest(Request.Method.POST,
				Constant.VISITORLIST_ACTION,
				new Response.Listener<String>() {
					@Override
					public void onResponse(String response) {
						System.out.println("---requestPartner----"+response);
						List<VisitorInfo> visitorlist = JSON.parseArray(response,VisitorInfo.class);
						if(visitorlist == null || visitorlist.size() ==0){
							if(pageIndex>1)pageIndex--;
							if(isAddMore){
								mhandler.post(new Runnable() {
									public void run() {
										mhandler.obtainMessage(LOADING_FAILURE).sendToTarget();
										xListView.mFooterView.getTitleInfo().setText("û�и������Ϣ");
									}
								});
							}
						}else{
							dataList.addAll(visitorlist);
							mhandler.obtainMessage(LOADING_SUCESS).sendToTarget();
						}
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						System.out.println("----longlong--"+error.getMessage());
						mhandler.obtainMessage(LOADING_FAILURE).sendToTarget();
					}
				}){
			@Override
			protected Map<String, String> getParams()
					throws AuthFailureError {
				Map<String ,String> maps = new HashMap<String, String>();
				maps.put("pageIndex", String.valueOf(pageIndex));
				maps.put("pageSize", String.valueOf(pageSize));
				maps.put("userRole", UserInfo.VISITOR_USER);
				return maps;
			}
		};
		MyTogetherAppllication.getinstance().getQuestQueue().add(sr);
	}
	
	private void initView(View view){
		setActionBarTitle("Ͷ����");
		xListView = (XListView)view.findViewById(R.id.xlistview);
		xListView.setPullRefreshEnable(false);
		xListView.setPullLoadEnable(true);
		xListView.setXListViewListener(this);
		xListView.mFooterView.setVisibility(View.VISIBLE);
		xListView.setFooterDividersEnabled(true);
		
		//dataList = VisitorInfoProduct.productList(5);
		adapter = new VisitorListAdapter(this.getActivity(), dataList);
		xListView.setAdapter(adapter);
		xListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent(VisitorListFragment.this.getActivity(),VisitorDetailActivity.class);
				intent.putExtra("visitoritem",dataList.get(arg2-1));
				startActivity(intent);
			}
		});
	}
	
	  @Override  
	    public void onActivityCreated(Bundle savedInstanceState) {  
	        super.onActivityCreated(savedInstanceState);  
	    }
	  
	@Override
	public void onRefresh() {
//		mhandler.postDelayed(new Runnable() {
//			public void run() {
//				adapter.notifyDataSetChanged();
//				xListView.stopRefresh();// ���
//			}
//		}, 2000);
	}

	@Override
	public void onLoadMore() {
		mhandler.post(new Runnable() {
			public void run() {
				pageIndex++;
				requestPartner(true);
				xListView.stopLoadMore();
			}
		});
	}
}
