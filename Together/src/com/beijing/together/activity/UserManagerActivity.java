//package com.beijing.together.activity;
//
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.util.HashMap;
//
//import android.annotation.SuppressLint;
//import android.app.Activity;
//import android.app.AlertDialog;
//import android.app.Dialog;
//import android.content.ActivityNotFoundException;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.net.Uri;
//import android.os.Bundle;
//import android.os.Environment;
//import android.os.Handler;
//import android.os.Message;
//import android.provider.MediaStore;
//import android.view.View;
//import android.view.Window;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.busonline.plamhall.PlamHallApplication;
//import com.busonline.plamhall.R;
//import com.busonline.plamhall.entity.AccountInfo;
//import com.busonline.plamhall.manager.LoginResourceManager;
//import com.busonline.plamhall.net.CallBackListenter;
//import com.busonline.plamhall.utils.FileUtil;
//import com.busonline.plamhall.utils.Utils;
//
///**
// * 用户管理界面的窗口
// * 
// * @author chenlong
// */
//public class UserManagerActivity extends BaseActivity implements
//		View.OnClickListener {
//	private static final int PHOTO_GRAPH = 1;// 拍照
//	private static final int PHOTO_ZOOM = 2; // 缩放
//	private static final int PHOTO_RESOULT = 3;// 结果
//	private static final String IMAGE_UNSPECIFIED = "image/*";
//	/* 用来标识请求gallery的activity */
//	private static final int PHOTO_PICKED_WITH_DATA = 3021;
//
//	private static final int OPEN_DIALOG_INFO = 0;
//	
//	private ImageView title_back;// 返回按钮
//	private TextView title_text;// 用户信息
//	private TextView title_right_text;// 用户操作按钮
//	private ImageView user_photo_info;// 用户头像信息
//	private LinearLayout user_phonto_ll;// 用户头像
//	private TextView user_name;// 用户名称
//	private TextView user_phone;// 用户手机号
//	private TextView user_belong;// 手机归属地
//	private TextView user_time;// 入网时间
//	private EditText user_address;// 用户联系地址
//	private EditText user_postcode;// 邮编
//	private EditText user_email;// 邮箱
//	//private LinearLayout receive_adder;// 收货地址
//	private LinearLayout modify_passwor;// 修改服务密码
//
//	private static final int FAILURE_FINISHED = 0;// 失败
//	private static final int SUCCESS_FINISHED = 1;// 成功
//
//	private static final int UPLOAD_PHOTO = 4;// 上传用户头像
//	private static final int DOWNLOAD_PHOTO = 5;// 下载用户头像
//	
//	private static final int CONTACT_COMMIT = 6;// 修改提交
//
//	private static final int DOWN_LOAD_PHOTO_TYPE_VALUE = 0;// 需要上传的图片类型
//
//	private Bitmap needSaveBitmap;// 需要保持的图片
//	
//	private boolean isClick = true;// 是否可以点击编辑
//
//	private Dialog dialog = null;
//	private Handler handler = new Handler() {
//		@Override
//		public void handleMessage(Message msg) {
//			super.handleMessage(msg);
////			if (dialog != null && dialog.isShowing())
////				dialog.dismiss();
////			if (msg.what == FAILURE_FINISHED) {
////				if (DOWNLOAD_PHOTO != msg.arg1)
////					Toast.makeText(UserManagerActivity.this,
////							String.valueOf(msg.obj), Toast.LENGTH_SHORT).show();
////			} else if (msg.what == SUCCESS_FINISHED) {
////				switch (msg.arg1) {
////				case UPLOAD_PHOTO:// 用户头像上传
////					HashMap<String, Object> hashValue = (HashMap<String, Object>) msg.obj;
////					String uploadImageID = (String) hashValue.get("imageID");// 上传头像成功
////																				// 返回头像ID
////					System.out.println("------uploadImageID-------"
////							+ uploadImageID);
////					File saveFile = FileUtil.getUserPhotoImage(
////							UserManagerActivity.this, PlamHallApplication
////									.getInstance().getUserPhoneNo(), uploadImageID + ".png");
////					FileUtil.saveImageToDataCachDir(needSaveBitmap,
////							saveFile.getAbsolutePath());
////					PlamHallApplication.getInstance().setUserPhoto(
////							needSaveBitmap);
////					user_photo_info.setImageBitmap(needSaveBitmap);// 把图片显示在ImageView控件上
////					break;
////				case DOWNLOAD_PHOTO:// 图片下载
////					Bitmap map = (Bitmap) msg.obj;
////					if (map != null) {
////						File userPhoto = FileUtil.getUserPhotoImage(
////								UserManagerActivity.this, PlamHallApplication
////										.getInstance().getAccountInfo()
////										.getPhoneNumber(), PlamHallApplication
////										.getInstance().getAccountInfo()
////										.getHeadImage());
////						FileUtil.saveImageToDataCachDir(map,
////								userPhoto.getAbsolutePath());
////						PlamHallApplication.getInstance().setUserPhoto(map);
////						user_photo_info.setImageBitmap(map);
////					} else {
////						user_photo_info.setImageResource(R.drawable.my_name);
////					}
////					break;
////				case CONTACT_COMMIT://修改用户信息提交
////					 title_right_text.setText("编辑");
////					 isClick = true;
////					 toggleEditeable(false);
////					Toast.makeText(UserManagerActivity.this, "你已修改用户信息成功",
////							Toast.LENGTH_SHORT).show();
////					PlamHallApplication.getInstance().updateAccountInfo(
////							user_address.getText().toString(),
////							user_postcode.getText().toString(),
////							user_email.getText().toString());
////					finish();
////					break;
////				default:
////					break;
////				}
////			}
////		}
//	};
//	
//	 private void toggleEditeable(boolean status){
//		  user_address.setEnabled(status);
//		  user_postcode.setEnabled(status);
//		  user_email.setEnabled(status);
//		  
//		  if(status)user_address.requestFocus();
////		  if(!status){
////			  user_address.setFocusable(false);
////			  user_postcode.setFocusable(false);
////			  user_email.setFocusable(false);
////		  }else{
////			  user_address.requestFocus();
////			  user_postcode.requestFocus();
////			  user_email.requestFocus();
////		  }
//		 }
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.user_manager);
//		initView();
//		initData();
//		initListener();
//	}
//
//	public void initView() {
//		title_back = (ImageView) findViewById(R.id.title_back_id);
//		title_text = (TextView) findViewById(R.id.title_text_mid_id);
//		title_right_text = (TextView) findViewById(R.id.title_right_text_id);
//		user_photo_info = (ImageView) findViewById(R.id.user_phone_id);
//		user_phonto_ll = (LinearLayout) findViewById(R.id.user_phone_ll_id);
//		user_name = (TextView) findViewById(R.id.user_name_id);
//		user_phone = (TextView) findViewById(R.id.user_number_id);
//		user_belong = (TextView) findViewById(R.id.user_belong_id);
//		user_time = (TextView) findViewById(R.id.user_net_time_id);
//		user_address = (EditText) findViewById(R.id.user_manager_receive_address_id);
//		user_postcode = (EditText) findViewById(R.id.user_manager_receive_postcode_id);
//		user_email = (EditText) findViewById(R.id.user_manager_receive_email_id);
//		//receive_adder = (LinearLayout) findViewById(R.id.user_manager_receive_address_id);
//		modify_passwor = (LinearLayout) findViewById(R.id.user_manager_modify_password_id);
//		title_text.setText("用户信息");
//		title_right_text.setText("编辑");
//	}
//
//	/**
//	 * 初始化数据
//	 */
//	private void initData() {
//		AccountInfo info = PlamHallApplication.getInstance().getAccountInfo();
//		user_name.setText(info.getAccountName());
//		user_phone.setText(info.getPhoneNumber());
//		user_belong.setText(info.getPhoneArea());
//		user_time.setText(info.getStartTime());
//		user_address.setText(info.getContactAddress());
//		user_postcode.setText(info.getPostCode());
//		user_email.setText(info.getEmail());
//		Bitmap map = FileUtil.initUserPhoto(this, "0",
//				user_photo_info,// 初始化用户头像
//				PlamHallApplication.getInstance().getAccountInfo()
//						.getHeadImage(), PlamHallApplication.getInstance()
//						.getAccountInfo().getPhoneNumber(), DOWNLOAD_PHOTO,
//				handler);
//		if (map != null) {
//			user_photo_info.setImageBitmap(map);
//		}
//		userInfoManager = new LoginResourceManager();
//	}
//
//	public void initListener() {
//		title_back.setOnClickListener(this);
//		user_phonto_ll.setOnClickListener(this);
//		//receive_adder.setOnClickListener(this);
//		title_right_text.setOnClickListener(this);
//		modify_passwor.setOnClickListener(this);
//	}
//
//	public Dialog onCreateDialog(int id) {
//		AlertDialog.Builder builder = new AlertDialog.Builder(this);
//		final String[] person_items = { "相册", "拍照" };
//		builder.setTitle("添加图片");
//		builder.setItems(person_items, new DialogInterface.OnClickListener() {
//			public void onClick(DialogInterface dialog, int item) {
//				if (item == 0) {// 相册
//				// Intent intent = new Intent(Intent.ACTION_PICK, null);
//				// intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//				// IMAGE_UNSPECIFIED);
//				// startActivityForResult(intent, PHOTO_ZOOM);
//					try {
//						final Intent intent = getPhotoPickIntent();
//						startActivityForResult(intent, PHOTO_RESOULT);
//					} catch (ActivityNotFoundException e) {
//						Toast.makeText(UserManagerActivity.this,
//								R.string.gallerynotfound, Toast.LENGTH_SHORT)
//								.show();
//					}
//				} else {
//					Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//					intent.putExtra(
//							MediaStore.EXTRA_OUTPUT,
//							Uri.fromFile(new File(Environment
//									.getExternalStorageDirectory(), "temp.jpg")));
//					// intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(
//					// FileUtil.getUserPhotoImage(this,Constants.PHOTO_IMAGE_DIRICTORY,Constants.PHOTO_IMAGE_NAME)));
//					startActivityForResult(intent, PHOTO_GRAPH);
//				}
//			}
//		});
//		AlertDialog alert = builder.create();
//		alert.show();
//		;
//		return alert;
//	}
//
//	@Override
//	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//		super.onActivityResult(requestCode, resultCode, data);
//		if (resultCode == RESULT_OK) {
//			if (requestCode == PHOTO_GRAPH) {
//				// 设置文件保存路径
//				File picture = new File(
//						Environment.getExternalStorageDirectory() + "/temp.jpg");
//				// File picture =
//				// FileUtil.createDirectory(FileUtil.getDataAreaFile(this,"img"),"temp.jpg");
//				startPhotoZoom(Uri.fromFile(picture));
//			}
//
//			if (requestCode == PHOTO_ZOOM) {// 缩放
//				startPhotoZoom(data.getData());
//			}
//
//			if (data == null)
//				return;
//			// 处理结果
//			if (requestCode == PHOTO_RESOULT) {
//				Bundle extras = data.getExtras();
//				if (extras != null) {
//					Bitmap photo = extras.getParcelable("data");
//					needSaveBitmap = photo;// 保存一份需要保持的图片
//					ByteArrayOutputStream stream = new ByteArrayOutputStream();
//					photo.compress(Bitmap.CompressFormat.JPEG, 75, stream);// (0-100)压缩文件
//					if (dialog == null || !dialog.isShowing())
//						dialog = Utils.createProgressDialog(this);
//					new LoginResourceManager().uploadUserPhoto(this,
//							stream,// 上传用户头像
//							String.valueOf(DOWN_LOAD_PHOTO_TYPE_VALUE), null,
//							new CallBackListenter(this, handler, UPLOAD_PHOTO));
//					// File file =
//					// FileUtil.getUserPhotoImage(this,Constants.PHOTO_IMAGE_DIRICTORY,Constants.PHOTO_IMAGE_NAME);
//					// new
//					// LoginResourceManager().uploadUserPhoto(this,Utils.Bitmap2InputStream(photo),//上传用户头像
//					// String.valueOf(DOWN_LOAD_PHOTO_TYPE_VALUE),null,
//					// new CallBackListenter(UPLOAD_PHOTO,this));
//
//					// File saveFile = FileUtil.getUserPhotoImage(this,
//					// Constants.PHOTO_IMAGE_DIRICTORY,PlamHallApplication.
//					// getInstance().getAccountInfo().getPhoneNumber()+".png");
//					// if(!saveFile.exists())saveFile.createNewFile();
//					// FileOutputStream save = new FileOutputStream(saveFile);
//					// photo.compress(Bitmap.CompressFormat.JPEG, 75, save);//
//					// (0-100)压缩文件
//
//				}
//			}
//		}
//	}
//
//	/**
//	 * 收缩图片
//	 * 
//	 * @param uri
//	 */
//	public void startPhotoZoom(Uri uri) {
//		Intent intent = new Intent("com.android.camera.action.CROP");
//		intent.setDataAndType(uri, IMAGE_UNSPECIFIED);
//		intent.putExtra("crop", "true");
//		// aspectX aspectY 是宽高的比例
//		intent.putExtra("aspectX", 1);
//		intent.putExtra("aspectY", 1);
//		// outputX outputY 是裁剪图片宽高
//		intent.putExtra("outputX", 100);
//		intent.putExtra("outputY", 100);
//		intent.putExtra("outputFormat", "JPEG");
//		intent.putExtra("return-data", true);
//		intent.putExtra("noFaceDetection", true);
//		startActivityForResult(intent, PHOTO_RESOULT);
//	}
//
//	@Override
//	public void onClick(View v) {
//		switch (v.getId()) {
//		case R.id.title_back_id:// 标题返回
//			finish();
//			break;
////		case R.id.user_manager_receive_address_id:// 到达收货地址
////			Intent receiveIntent = new Intent(this,
////					ReceiveAddressActivity.class);
////			startActivity(receiveIntent);
////			break;
//		case R.id.title_right_text_id://点击右边
//			 if(isClick){
//				 toggleEditeable(true);
//				 title_right_text.setText(R.string.save);
//				 isClick = false;
//			 }else{//保存修改后的数据 提交到服务器
//				 if(dialog == null || !dialog.isShowing())
//				 dialog = Utils.createProgressDialog(this);
//				 //String area = user_area.getText().toString();
//				 String address = user_address.getText().toString();
//				 String postcode = user_postcode.getText().toString();
//				 String email = user_email.getText().toString();
//				 userInfoManager.modifyAccountInfo(this,email,address,postcode,
//				 new CallBackListenter(this,handler,CONTACT_COMMIT));
//			}
//			break;
//		case R.id.user_manager_modify_password_id:// 修改服务密码
//			Intent modifyIntent = new Intent(this,
//					ModifyServerPasswordActivity.class);
//			startActivity(modifyIntent);
//			break;
//		case R.id.user_phone_ll_id:// 添加用户头像
//			showDialog(OPEN_DIALOG_INFO);
//			break;
//		default:
//			break;
//		}
//
//	}
//}
//
