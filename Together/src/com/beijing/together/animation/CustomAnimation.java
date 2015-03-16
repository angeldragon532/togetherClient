package com.beijing.together.animation;


import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import android.os.Bundle;
import android.util.Log;

import com.beijing.together.R;
import com.beijing.together.activity.BaseFragment;
import com.beijing.together.activity.BaseFragmentActivity;
import com.beijing.together.activity.Constant;
import com.beijing.together.activity.ProjectListFragment;
import com.beijing.together.activity.SubMenuFragment;
import com.beijing.together.utils.Utils;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.CanvasTransformer;

public abstract class CustomAnimation extends BaseFragmentActivity{
	
	private CanvasTransformer mTransformer;
	
	public CustomAnimation(int titleRes, CanvasTransformer transformer) {
		super(titleRes);
		mTransformer = transformer;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		// set the Above View
		setContentView(R.layout.content_frame);
		BaseFragment fragmment = new ProjectListFragment();
		fragmment.setOnMenuToggle(toggle);
		getSupportFragmentManager().beginTransaction()
		.replace(R.id.content_frame, fragmment,SubMenuFragment.PROJECT_TAG)
		.commit();
		
		SlidingMenu sm = getSlidingMenu();
		setSlidingActionBarEnabled(true);
		sm.setBehindScrollScale(0.0f);
		sm.setBehindCanvasTransformer(mTransformer);
		
      try {
    	    String rongyunToken = Utils.getRongyunTokenString();
    	    System.out.println("----longlong-----rongyunToken="+rongyunToken);
			RongIM.connect(rongyunToken, new RongIMClient.ConnectCallback() {
			    @Override
			    public void onSuccess(String s) {
			        // 此处处理连接成功。
			    	System.out.println("---longlong----sucess="+s);
			        Log.d("Connect:", "Login successfully.");
			    }

			    @Override
			    public void onError(ErrorCode errorCode) {
			        // 此处处理连接错误。
			    	System.out.println("---longlong----failure="+errorCode.getMessage());
			        Log.d("Connect:", "Login failed.");
			    }
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
