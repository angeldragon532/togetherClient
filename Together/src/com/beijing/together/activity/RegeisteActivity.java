package com.beijing.together.activity;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.json.JSONException;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.InputType;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.beijing.together.R;
import com.beijing.together.animation.CustomZoomAnimation;
import com.beijing.together.utils.DialogUtils;
import com.beijing.together.utils.SHA1;
import com.beijing.together.utils.Utils;

public class RegeisteActivity extends BaseActivity implements OnClickListener{
	
	private ImageView backImageView;
	
	private EditText usernameEditText;
	
	private EditText phoneEditText;
	
	private EditText validateEditText;
	
	private EditText passwordText;
	
	private ImageView showPassword;
	
	private TextView getValidaText;
	
	private Button button;
	
	private boolean isShowPassword;
	
	private TimeCount timeCount;
	
	private RadioGroup radioGroup;
	
	private RadioButton createRadioButton;
	
	private RadioButton patenerRadioButton;
	
	private RadioButton visitorRadioButton;
	
	private String roleID;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.regeiste);
		initView();
		initData();
	}
	
	private void initView(){
		backImageView = (ImageView)findViewById(R.id.login_back_id);
		usernameEditText = (EditText)findViewById(R.id.login_name_edit_id);
		phoneEditText = (EditText)findViewById(R.id.login_phone_edit_id);
		validateEditText = (EditText)findViewById(R.id.login_validate_edit_id);
		passwordText = (EditText)findViewById(R.id.login_passwrod_edit_id);
		button = (Button)findViewById(R.id.loginregeiste_user_id);
		showPassword = (ImageView)findViewById(R.id.login_passwrod_edit_icea_id);
		getValidaText = (TextView)findViewById(R.id.login_validate_editext_get_id);
		
		createRadioButton = (RadioButton)findViewById(R.id.login_role_select_creater_id);
		patenerRadioButton = (RadioButton)findViewById(R.id.login_role_select_partener_id);
		visitorRadioButton = (RadioButton)findViewById(R.id.login_role_select_investor_id);
		radioGroup = (RadioGroup)findViewById(R.id.regeist_user_role_id);
		
		backImageView.setOnClickListener(this);
		button.setOnClickListener(this);
		showPassword.setOnClickListener(this);
		getValidaText.setOnClickListener(this);
		usernameEditText.addTextChangedListener(new MyTextWitch(usernameEditText));
		phoneEditText.addTextChangedListener(new MyTextWitch(phoneEditText));
		validateEditText.addTextChangedListener(new MyTextWitch(validateEditText));
		passwordText.addTextChangedListener(new MyTextWitch(passwordText));
		
	}
	
	private void initData(){
		timeCount = new TimeCount(60000, 1000);//构造CountDownTimer对象
		initRoleInfo(createRadioButton);
		initRoleInfo(patenerRadioButton);
		initRoleInfo(visitorRadioButton);
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
				passwordText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD); 
				showPassword.setImageResource(R.drawable.login_icea_show_not);
			} 
			break;
		case R.id.login_validate_editext_get_id:
			timeCount.start();
			break;
		case R.id.loginregeiste_user_id://注册登录
			if(createRadioButton.isChecked()){
				roleID = "0";
			}else if(patenerRadioButton.isChecked()){
				roleID = "1";
			}else if(visitorRadioButton.isChecked()){
				roleID = "2";
			}else{
				Toast.makeText(this,"请选择用户角色",Toast.LENGTH_SHORT).show();
				return;
			}
			dialog = DialogUtils.createProgressDialog(this);
			Request sr = new StringRequest(Request.Method.POST,
					Constant.USERREGEIST_ACTION,
					new Response.Listener<String>() {
						@Override
						public void onResponse(String response) {
//							String vasdString = response;
//							org.json.JSONObject jsonObject;
//							try {
//								jsonObject = new org.json.JSONObject(response);
//							} catch (JSONException e) {
//								e.printStackTrace();
//							}
							Utils.saveObject(Utils.CACHEDIR + Utils.USER_INFO,response);
							RegeisteActivity.this.handler.sendEmptyMessage(CLOSE_MyDIALOG);
							System.out.println("----longlong--"+response);
							Toast.makeText(RegeisteActivity.this,"注册登陆成功",Toast.LENGTH_SHORT).show();
							Intent intent = new Intent(RegeisteActivity.this,CustomZoomAnimation.class);
							RegeisteActivity.this.startActivity(intent);
							RegeisteActivity.this.finish();
						}
					}, new Response.ErrorListener() {
						@Override
						public void onErrorResponse(VolleyError error) {
							RegeisteActivity.this.handler.sendEmptyMessage(CLOSE_MyDIALOG);
							Toast.makeText(RegeisteActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
							System.out.println("----longlong--"+error.getMessage());
						}
					}) {
				@Override
				protected Map<String, String> getParams() throws AuthFailureError {
					super.getParams();
					Map<String, String> map = new HashMap<String, String>();
					map.put("roleID",roleID);
					if("2".equals(roleID)){//投资人注册
						map.put("visitorinfo.userRole",roleID);
						map.put("visitorinfo.name", usernameEditText.getText().toString());
						map.put("visitorinfo.password",passwordText.getText().toString());
						map.put("visitorinfo.city","北京");
						map.put("visitorinfo.phone",phoneEditText.getText().toString());
					}else{//发起人。合伙人注册
						map.put("userinfo.userRole",roleID);
						map.put("userinfo.name", usernameEditText.getText().toString());
						map.put("userinfo.nikeName",usernameEditText.getText().toString());
						map.put("userinfo.password",passwordText.getText().toString());
						map.put("userinfo.city","北京");
						map.put("userinfo.phone",phoneEditText.getText().toString());
					}
					return map;
				};
			};
			MyTogetherAppllication.getinstance().getQuestQueue().add(sr);
			break;
		default:
			break;
		}
	}
	
	private void initRoleInfo(RadioButton radioButton){
		SpannableStringBuilder builder = new SpannableStringBuilder(radioButton.getText().toString());
		builder.setSpan(new RelativeSizeSpan(2),0, 3,SpannableStringBuilder.SPAN_INCLUSIVE_EXCLUSIVE);
		radioButton.setText(builder);
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
			
			switch (view.getId()) {
			case R.id.login_name_edit_id:
				if(nullData){
					showDanymicLeftDrable(view,getResources().getDrawable(R.drawable.login_username_edit_finished_not));
				}else{
					showDanymicLeftDrable(view,getResources().getDrawable(R.drawable.login_username_edit_finished));
				}
				break;
			case R.id.login_phone_edit_id:
				if(nullData){
					showDanymicLeftDrable(view,getResources().getDrawable(R.drawable.login_phone_edit_finished_not));
				}else{
					showDanymicLeftDrable(view,getResources().getDrawable(R.drawable.login_phone_edit_finished));
				}
				break;
			case R.id.login_validate_edit_id:
				if(nullData){
					showDanymicLeftDrable(view,getResources().getDrawable(R.drawable.login_validate_edit_finished_not));
				}else{
					showDanymicLeftDrable(view,getResources().getDrawable(R.drawable.login_validate_edit_finished));
				}
				break;
			case R.id.login_passwrod_edit_id:
				if(nullData){
					showPassword.setVisibility(View.GONE);
					showDanymicLeftDrable(view,getResources().getDrawable(R.drawable.login_password_edit_finished_not));
				}else{
					if (passwordText.hasFocus()) {
						showPassword.setVisibility(View.VISIBLE);
					}
					showDanymicLeftDrable(view,getResources().getDrawable(R.drawable.login_password_edit_finished));
				}
				break;
			default:
				break;
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
	
	class TimeCount extends CountDownTimer {
		public TimeCount(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);// 参数依次为总时长,和计时的时间间隔
		}
		@Override
		public void onFinish() {// 计时完毕时触发
			getValidaText.setText("获取验证码");
			getValidaText.setClickable(true);
		}
		@Override
		public void onTick(long millisUntilFinished) {// 计时过程显示
			getValidaText.setClickable(false);
			getValidaText.setText(millisUntilFinished /1000+"s后重新发送");
		}
	}
}
