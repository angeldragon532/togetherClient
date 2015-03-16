package com.beijing.together.activity;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.beijing.together.R;
import com.beijing.together.animation.CustomZoomAnimation;
import com.beijing.together.entity.UserInfo;
import com.beijing.together.entity.VisitorInfo;
import com.beijing.together.utils.DialogUtils;
import com.beijing.together.utils.Utils;

public class LoginActivity extends BaseActivity implements OnClickListener{
	
	private ImageView backImageView;
	
	private EditText phoneEditText;
	
	private EditText passwordText;
	
	private ImageView showPassword;
	
	private Button button;
	
	private boolean isShowPassword;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		initView();
		initData();
	}
	
	private void initView(){
		backImageView = (ImageView)findViewById(R.id.login_back_id);
		phoneEditText = (EditText)findViewById(R.id.login_phone_edit_id);
		passwordText = (EditText)findViewById(R.id.login_passwrod_edit_id);
		button = (Button)findViewById(R.id.loginpage_user_id);
		showPassword = (ImageView)findViewById(R.id.login_passwrod_edit_icea_id);
		backImageView.setOnClickListener(this);
		button.setOnClickListener(this);
		showPassword.setOnClickListener(this);
		phoneEditText.addTextChangedListener(new MyTextWitch(phoneEditText));
		passwordText.addTextChangedListener(new MyTextWitch(passwordText));
	}
	
	private void initData(){
		Object object = Utils.getUserInfo();
		if(object instanceof UserInfo){
			UserInfo userInfo  = (UserInfo)object;
			phoneEditText.setText(userInfo.getPhone());
			passwordText.setText(userInfo.getPassword());
		}else if(object instanceof VisitorInfo){
			VisitorInfo visitorInfo  = (VisitorInfo)object;
			phoneEditText.setText(visitorInfo.getPhone());
			passwordText.setText(visitorInfo.getPassword());
		}
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login_back_id:
			finished();
			break;
		case R.id.login_passwrod_edit_icea_id:
			if(isShowPassword){
				isShowPassword = false;
				showPassword.setImageResource(R.drawable.login_icea_show);
				passwordText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD); 
			}else{
				isShowPassword = true;
				showPassword.setImageResource(R.drawable.login_icea_show_not);
				passwordText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);     
			} 
			break;
		case R.id.loginpage_user_id:
			dialog = DialogUtils.createProgressDialog(this);
			Request sr = new StringRequest(Request.Method.POST,
					Constant.USERLOGIN_ACTION,
					new Response.Listener<String>() {
						@Override
						public void onResponse(String response) {
//							org.json.JSONObject jsonObject;
//							try {
								//jsonObject = new org.json.JSONObject(response);
//							   Utils.saveObject(Utils.CACHEDIR + Utils.USER_INFO,response);
//								Constant.USER_TOKEN = jsonObject.getString("token");
//								Constant.USERID = jsonObject.getString("userId");
//							} catch (JSONException e) {
//								e.printStackTrace();
//							}
							Log.i("---longlong--", response);
							Utils.saveObject(Utils.CACHEDIR + Utils.USER_INFO,response);
							LoginActivity.this.handler.sendEmptyMessage(CLOSE_MyDIALOG);
							Intent intent = new Intent(LoginActivity.this,CustomZoomAnimation.class);
							LoginActivity.this.startActivity(intent);
							Toast.makeText(LoginActivity.this,"µÇÂ½³É¹¦",Toast.LENGTH_SHORT).show();
							LoginActivity.this.finish();
						}
					}, new Response.ErrorListener() {
						@Override
						public void onErrorResponse(VolleyError error) {
							LoginActivity.this.handler.sendEmptyMessage(CLOSE_MyDIALOG);
							Toast.makeText(LoginActivity.this,"µÇÂ½Ê§°Ü",Toast.LENGTH_SHORT).show();
							System.out.println("----longlong--"+error.getMessage());
						}
					}) {
				@Override
				protected Map<String, String> getParams() throws AuthFailureError {
					super.getParams();
					Map<String, String> map = new HashMap<String, String>();
					map.put("userphone", phoneEditText.getText().toString());
					map.put("userpassword",passwordText.getText().toString());
					return map;
				};
			};
			MyTogetherAppllication.getinstance().getQuestQueue().add(sr);
			break;
		default:
			break;
		}
	}
	
	private class MyTextWitch implements TextWatcher{
		private EditText view;
		private MyTextWitch(EditText view){
			this.view = view;
		}
		@Override
		public void afterTextChanged(Editable s) {
			String keyword = s.toString();
			keyword = keyword.trim();
			Drawable result = null;
			boolean nullData = true;
			if (s == null || s.length() == 0||"".equals(s.toString().trim())) {
				nullData = true;
			}else {
				nullData = false;
			}
			
			if(view.getId() == phoneEditText.getId()){
				if(nullData){
					showDanymicLeftDrable(view,getResources().getDrawable(R.drawable.login_phone_edit_finished_not));
				}else{
					showDanymicLeftDrable(view,getResources().getDrawable(R.drawable.login_phone_edit_finished));
				}
			}else if(view.getId() == passwordText.getId()){
				if(nullData){
					showPassword.setVisibility(View.GONE);
					showDanymicLeftDrable(view,getResources().getDrawable(R.drawable.login_password_edit_finished_not));
				}else{
					if (passwordText.hasFocus()) {
						showPassword.setVisibility(View.VISIBLE);
					}
					showDanymicLeftDrable(view,getResources().getDrawable(R.drawable.login_password_edit_finished));
				}
			} 
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
		}
	}
	
	private void showDanymicLeftDrable(EditText v,Drawable drawable){
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
		v.setCompoundDrawables(drawable,null,null,null);
	}
}
