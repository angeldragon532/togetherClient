package com.beijing.together.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.beijing.together.entity.UserInfo;
import com.beijing.together.entity.VisitorInfo;

import android.util.Log;


public class Utils {
	
	public static final String USER_INFO = "initUser.log";//初始化登陆用户信息
	public static final String PROJECT_INFO = "initProject.log";//添加的项目信息
	
	public final static String CACHEDIR = "/data/data/com.beijing.together/cache/";

	private static String TAG = "Utils";
	
	/**
	 * 得到用户基本信息
	 * @return
	 */
	public static Object getUserInfo(){
		Object userObject = Utils.restoreObject(Utils.CACHEDIR + Utils.USER_INFO);
		Object result = null;
		if(userObject != null){
			String value = (String)userObject;
			JSONObject object = JSONObject.parseObject(value);
			if("2".equals(object.getString("userRole"))){
				result = JSON.parseObject(value,VisitorInfo.class);
			}else{
				result = JSON.parseObject(value,UserInfo.class);
			}
		}
		return result;
	}
	
	public static String getRongyunTokenString(){
		Object userObject = Utils.restoreObject(Utils.CACHEDIR + Utils.USER_INFO);
		String rongyunToken = null;
		if(userObject != null){
			String value = (String)userObject;
			JSONObject object = JSONObject.parseObject(value);
			if("2".equals(object.getString("userRole"))){
				VisitorInfo info = JSON.parseObject(value,VisitorInfo.class);
				rongyunToken = info.getRongyunToken();
			}else{
				UserInfo info = JSON.parseObject(value,UserInfo.class);
				rongyunToken = info.getRongyunToken();
			}
		}
		return rongyunToken;
	}
	
	
	public static String getLoginUserName(){
		Object userObject = Utils.restoreObject(Utils.CACHEDIR + Utils.USER_INFO);
		String userName = null;
		if(userObject != null){
			String value = (String)userObject;
			JSONObject object = JSONObject.parseObject(value);
			if("2".equals(object.getString("userRole"))){
				VisitorInfo info = JSON.parseObject(value,VisitorInfo.class);
				userName = info.getName();
			}else{
				UserInfo info = JSON.parseObject(value,UserInfo.class);
				userName = info.getName();
			}
		}
		return userName;
	}
	
	
	/**
	 * 
	 * @Title: saveObject
	 * @Description: 保存对象到制定目录
	 * @param path
	 * @param saveObject
	 * @return void
	 * @throws
	 */
	public static final void saveObject(String path, Object saveObject) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		File f = new File(path);
		try {
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(saveObject);
		} catch (Exception e) {
			e.printStackTrace();
			Log.e(TAG,e.getMessage());
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				Log.e(TAG,e.getMessage());
			}
		}
	}

	/**
	 * 
	 * @Title: restoreObject
	 * @Description: 从文件中读取对象
	 * @param path
	 * @return Object
	 * @throws
	 */
	public static final Object restoreObject(String path) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Object object = null;
		File f = new File(path);
		if (!f.exists()) {
			return null;
		}
		try {
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			object = ois.readObject();
			return object;

		} catch (Exception e) {
			Log.e(TAG,e.getMessage());
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				Log.e(TAG,e.getMessage());
			}
		}
		return object;
	}
}
