package com.beijing.together.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.beijing.together.R;

public class DialogUtils {

	private static final String TAG = "MyDialog";

	public static Dialog createDialog(Context con ,int layoutID,final DialogCallBack callback) {
		final Dialog dlg = new AlertDialog.Builder(con).create();
		dlg.show();
		View view = LayoutInflater.from(con).inflate(layoutID, null);
		dlg.getWindow().setContentView(view);
		TextView finished = (TextView)view.findViewById(R.id.project_add_dialog_commit_id);
		final RadioGroup rp1= (RadioGroup)view.findViewById(R.id.radiogroup_1_id);
		//final RadioGroup rp2= (RadioGroup)view.findViewById(R.id.radiogroup_2_id);
		rp1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {
			}
		});
//		rp2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
//			public void onCheckedChanged(RadioGroup group, int checkedId) {
//				rp1.clearCheck();
//			}
//		});
		finished.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String value = "";
				for(int i=0;i<rp1.getChildCount();i++){
					RadioButton rButton  = (RadioButton)rp1.getChildAt(i);
					if(rButton.isChecked()){
						value+=rButton.getText().toString()+" ";
					}
				}
//				for(int i=0;i<rp2.getChildCount();i++){
//					RadioButton rButton  = (RadioButton)rp1.getChildAt(i);
//					if(rButton.isChecked()){
//						value+=rButton.getText().toString()+" ";
//					}
//				}
				callback.onDialogListener(value);
				dlg.dismiss();
			}
		});
		return dlg;
	}
	
	
	/**
	 * ͨѶ��ʾ��
	 */
	public static Dialog createProgressDialog(Context con) {
		Dialog dlg = new AlertDialog.Builder(con).create();
		dlg.show();
		dlg.setCancelable(false);
		View view = LayoutInflater.from(con).inflate(R.layout.progress_dialog,
				null);
		dlg.getWindow().setContentView(view);
		return dlg;
	}
	
	/***
	 * Զ��ʧЧ��ʾ�Ի���
	 * @param msg
	 * @param con
	 * @param onclick
	 * @return
	 */
	public static Dialog showAlert(String msg, Context con,
			DialogInterface.OnClickListener onclick) {
		AlertDialog.Builder builder = new AlertDialog.Builder(con);
		builder.setCancelable(false);
		builder.setTitle(R.string.alert).setMessage(msg).
		setPositiveButton(R.string.confirm,onclick).show();
		Dialog dialog = builder.create();
		setDialogCansalSearch(dialog);
		return dialog;
	}
	
	/***
	 * ��ֹ���������ťʱ  ȡ�������Ŀ�
	 * @param dialog
	 */
	private static void setDialogCansalSearch(Dialog dialog){
		dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
			public boolean onKey(DialogInterface dialog, int keyCode,
					KeyEvent event) {
				 if (keyCode == KeyEvent.KEYCODE_SEARCH){
				     return true;
				 }else{
				     return false; //Ĭ�Ϸ��� false
				 }
			}
		});
	}
	
	/**
	 * ��ͨ��ʾ�򣬰���һ��ȷ����ť
	 * 
	 * @param msg
	 *            ��ʾ��Ϣ
	 */
	public static Dialog showAlert(String msg, Context con) {
		AlertDialog.Builder builder = new AlertDialog.Builder(con);
		builder.setTitle(R.string.alert).setMessage(msg).
		setPositiveButton(R.string.confirm,new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		}).show();
		return builder.create();
	}
	
	
	public interface DialogCallBack{
		public void onDialogListener(String value);
	}

}
