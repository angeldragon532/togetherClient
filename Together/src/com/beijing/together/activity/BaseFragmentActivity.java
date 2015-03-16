package com.beijing.together.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;

import com.actionbarsherlock.view.MenuItem;
import com.beijing.together.R;
import com.beijing.together.activity.SubMenuFragment.OnChangeMenuToggle;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

@SuppressLint("ResourceAsColor")
public class BaseFragmentActivity extends SlidingFragmentActivity {

	private int mTitleRes;
	protected Fragment mFrag;
	//private ConditionDialog dialog = null;
	private SlidingMenu sm;
	
	protected OnChangeMenuToggle toggle;
	
	public static int USER_ROLE = 0;//"0 创业者 ， 1 投资人"

	public BaseFragmentActivity(int titleRes) {
		mTitleRes = titleRes;
	}

	/* (non-Javadoc)
	 * @see com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setTitle(mTitleRes);
		// set the Behind View
		setBehindContentView(R.layout.menu_frame);
		if (savedInstanceState == null) {
			FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
			mFrag = initSubMenuFragment();
			t.replace(R.id.menu_frame, mFrag);
			t.commit();
		} else {
			mFrag = (Fragment)this.getSupportFragmentManager().findFragmentById(R.id.menu_frame);
		}

		// customize the SlidingMenu
		sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		sm.setBackgroundResource(R.color.white);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		
		//getSupportActionBar().setTitle("项目");
		//getSupportActionBar().setIcon(null);
		//getSupportActionBar().setCustomView(R.layout.actionbar_layout);
		//getSupportActionBar().setDisplayShowCustomEnabled(true);
		//getSupportActionBar().setDisplayHomeAsUpEnabled(false);
	}
	
	private Fragment initSubMenuFragment(){
		toggle = new SubMenuFragment.OnChangeMenuToggle() {
			@Override
			public void onChangMenuCallBack() {
				sm.toggle(true);
			}
		};
		Fragment frag = new SubMenuFragment(toggle); 
		return frag;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
//		switch (item.getItemId()) {
//		case R.id.project_sort:
//			Intent projectIntent = new Intent(this,ProjectAddActivity.class);
//			startActivity(projectIntent);
//			break;
//		case R.id.project_filter:
//			dialog = new ConditionDialog(this);
//			dialog.show();
//			break;
//		case R.id.project_search:
//			Intent intent = new Intent(this,ProjectSearchActivity.class);
//			startActivity(intent);
//			break;
//		default:
//			break;
//		}
		return super.onOptionsItemSelected(item);
	}
	
//	 @Override
//	 public boolean onCreateOptionsMenu(Menu menu) {
//	        this.getSupportMenuInflater().inflate(R.menu.project_menu, menu);
//	        return super.onCreateOptionsMenu(menu);  
//	 } 
}
