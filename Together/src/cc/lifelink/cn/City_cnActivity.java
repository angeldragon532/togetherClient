package cc.lifelink.cn;

import java.util.ArrayList;
import java.util.List;

import com.beijing.together.R;
import com.beijing.together.activity.InitUserInfoActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;


public class City_cnActivity extends Activity {
    /** Called when the activity is first created. */
	private DBManager dbm;
	private SQLiteDatabase db;
	private Spinner spinner1 = null;
	private Spinner spinner2=null;
	private String province=null;
	private String city=null;
	private String district=null;
	private boolean isFirst = false;
	
	private ImageView backImageView;
	private TextView titleView;
	
	public static final int CITY = 10;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_select);
        backImageView = (ImageView)findViewById(R.id.title_back_id);
        titleView = (TextView)findViewById(R.id.title_text_mid_id);
        titleView.setText("选择城市");
        spinner1=(Spinner)findViewById(R.id.spinner1);
        spinner2=(Spinner)findViewById(R.id.spinner2);
		spinner1.setPrompt("省");
		spinner2.setPrompt("城市");		
		
        initSpinner1();
        backImageView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("cityvalue",province+" "+city);
				setResult(CITY, intent);
				finish();
			}
		});
    }
    
    public void initSpinner1(){
		dbm = new DBManager(this);
	 	dbm.openDatabase();
	 	db = dbm.getDatabase();
	 	List<MyListItem> list = new ArrayList<MyListItem>();
		
	 	try {    
	        String sql = "select * from province";  
	        Cursor cursor = db.rawQuery(sql,null);  
	        cursor.moveToFirst();
	        while (!cursor.isLast()){ 
		        String code=cursor.getString(cursor.getColumnIndex("code")); 
		        byte bytes[]=cursor.getBlob(2); 
		        String name=new String(bytes,"gbk");
		        MyListItem myListItem=new MyListItem();
		        myListItem.setName(name);
		        myListItem.setPcode(code);
		        list.add(myListItem);
		        cursor.moveToNext();
	        }
	        String code=cursor.getString(cursor.getColumnIndex("code")); 
	        byte bytes[]=cursor.getBlob(2); 
	        String name=new String(bytes,"gbk");
	        MyListItem myListItem=new MyListItem();
	        myListItem.setName(name);
	        myListItem.setPcode(code);
	        list.add(myListItem);
	        
	    } catch (Exception e) {  
	    } 
	 	dbm.closeDatabase();
	 	db.close();	
	 	
	 	MyAdapter myAdapter = new MyAdapter(this,list);
	 	spinner1.setAdapter(myAdapter);
		spinner1.setOnItemSelectedListener(new SpinnerOnSelectedListener1());
	}
    public void initSpinner2(String pcode){
		dbm = new DBManager(this);
	 	dbm.openDatabase();
	 	db = dbm.getDatabase();
	 	List<MyListItem> list = new ArrayList<MyListItem>();
		
	 	try {    
	        String sql = "select * from city where pcode='"+pcode+"'";  
	        Cursor cursor = db.rawQuery(sql,null);  
	        cursor.moveToFirst();
	        while (!cursor.isLast()){ 
		        String code=cursor.getString(cursor.getColumnIndex("code")); 
		        byte bytes[]=cursor.getBlob(2); 
		        String name=new String(bytes,"gbk");
		        MyListItem myListItem=new MyListItem();
		        myListItem.setName(name);
		        myListItem.setPcode(code);
		        list.add(myListItem);
		        cursor.moveToNext();
	        }
	        String code=cursor.getString(cursor.getColumnIndex("code")); 
	        byte bytes[]=cursor.getBlob(2); 
	        String name=new String(bytes,"gbk");
	        MyListItem myListItem=new MyListItem();
	        myListItem.setName(name);
	        myListItem.setPcode(code);
	        list.add(myListItem);
	        
	    } catch (Exception e) {  
	    } 
	 	dbm.closeDatabase();
	 	db.close();	
	 	
	 	MyAdapter myAdapter = new MyAdapter(this,list);
	 	spinner2.setAdapter(myAdapter);
		spinner2.setOnItemSelectedListener(new SpinnerOnSelectedListener2());
	}
//    public void initSpinner3(String pcode){
//		dbm = new DBManager(this);
//	 	dbm.openDatabase();
//	 	db = dbm.getDatabase();
//	 	List<MyListItem> list = new ArrayList<MyListItem>();
//		
//	 	try {    
//	        String sql = "select * from district where pcode='"+pcode+"'";  
//	        Cursor cursor = db.rawQuery(sql,null);  
//	        cursor.moveToFirst();
//	        while (!cursor.isLast()){ 
//		        String code=cursor.getString(cursor.getColumnIndex("code")); 
//		        byte bytes[]=cursor.getBlob(2); 
//		        String name=new String(bytes,"gbk");
//		        MyListItem myListItem=new MyListItem();
//		        myListItem.setName(name);
//		        myListItem.setPcode(code);
//		        list.add(myListItem);
//		        cursor.moveToNext();
//	        }
//	        String code=cursor.getString(cursor.getColumnIndex("code")); 
//	        byte bytes[]=cursor.getBlob(2); 
//	        String name=new String(bytes,"gbk");
//	        MyListItem myListItem=new MyListItem();
//	        myListItem.setName(name);
//	        myListItem.setPcode(code);
//	        list.add(myListItem);
//	        
//	    } catch (Exception e) {  
//	    } 
//	 	dbm.closeDatabase();
//	 	db.close();	
//	 	
//	 	MyAdapter myAdapter = new MyAdapter(this,list);
//	}
    
	class SpinnerOnSelectedListener1 implements OnItemSelectedListener{
		
		public void onItemSelected(AdapterView<?> adapterView, View view, int position,
				long id) {
			province=((MyListItem) adapterView.getItemAtPosition(position)).getName();
			String pcode =((MyListItem) adapterView.getItemAtPosition(position)).getPcode();
			initSpinner2(pcode);
		}

		public void onNothingSelected(AdapterView<?> adapterView) {
			// TODO Auto-generated method stub
		}		
	}
	class SpinnerOnSelectedListener2 implements OnItemSelectedListener{
		
		public void onItemSelected(AdapterView<?> adapterView, View view, int position,
				long id) {
			city=((MyListItem) adapterView.getItemAtPosition(position)).getName();
			String pcode =((MyListItem) adapterView.getItemAtPosition(position)).getPcode();
		}

		public void onNothingSelected(AdapterView<?> adapterView) {
			// TODO Auto-generated method stub
		}		
	}
	
//	class SpinnerOnSelectedListener3 implements OnItemSelectedListener{
//		
//		public void onItemSelected(AdapterView<?> adapterView, View view, int position,
//				long id) {
//			district=((MyListItem) adapterView.getItemAtPosition(position)).getName();
//			Toast.makeText(City_cnActivity.this, province+" "+city+" "+district, Toast.LENGTH_LONG).show();
//		}
//
//		public void onNothingSelected(AdapterView<?> adapterView) {
//			// TODO Auto-generated method stub
//		}		
//	}
}