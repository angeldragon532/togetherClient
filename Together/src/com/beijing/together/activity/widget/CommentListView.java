package com.beijing.together.activity.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;

public class CommentListView extends ListView{
	
	private final static String TAG = "CommentListView";
	
	public CommentListView(Context context) {
		super(context);
	}
	
	public CommentListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}


	@Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                setParentScrollAble(false);//当手指触到listview的时候，让父ScrollView交出ontouch权限，也就是让父scrollview 停住不能滚动
               Log.i(TAG,"onInterceptTouchEvent down");
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG,"onInterceptTouchEvent move");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG,"onInterceptTouchEvent up");
            case MotionEvent.ACTION_CANCEL:
                Log.i(TAG,"onInterceptTouchEvent cancel");
                setParentScrollAble(true);//当手指松开时，让父ScrollView重新拿到onTouch权限
               break;
            default:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
	
	  /**
     * 是否把滚动事件交给父scrollview
     * 
     * @param flag
     */
    private void setParentScrollAble(boolean flag) {
    	View view = (View)this.getParent();
    	if(!(view instanceof ScrollView)){
    		((ScrollView)view.getParent()).requestDisallowInterceptTouchEvent(!flag);
    	}else if(view instanceof ScrollView){
    		((ScrollView)view).requestDisallowInterceptTouchEvent(!flag);//这里的parentScrollView就是listview外面的那个scrollview
    	}
    }


}
