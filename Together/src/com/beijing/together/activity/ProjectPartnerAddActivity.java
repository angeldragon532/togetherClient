package com.beijing.together.activity;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.beijing.together.R;
import com.beijing.together.entity.ProjectPartnerInfo;

public class ProjectPartnerAddActivity extends BaseActivity implements OnClickListener{
	
	public static final int RQUEST_CODE_PARTNER = 1;
	
	private TextView backText;
	private TextView titleText;
	private TextView commitText;
	
	private CheckBox techlogicBox;
	private LinearLayout techeLayout;
	private Spinner techWorkwaySpinner;
	private Spinner techOptionSpinner;
	private Spinner techSalarySpinner;
	private EditText techOtherEditText;
	
	private ArrayList<ProjectPartnerInfo> partnerInfo = new ArrayList<ProjectPartnerInfo>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.partner_info_add);
		initView();
		initData();
	}
	
	private void initView(){
		
		backText = (TextView)findViewById(R.id.title_back_id);
		titleText = (TextView)findViewById(R.id.title_text_mid_id);
		commitText = (TextView)findViewById(R.id.title_right_text_id);
		backText.setOnClickListener(this);
		commitText.setOnClickListener(this);
		
		techlogicBox = (CheckBox)findViewById(R.id.partner_add_technogic_checkbox_id);
		techeLayout = (LinearLayout)findViewById(R.id.partner_add_technogic_checkbox_content_id);
		techWorkwaySpinner = (Spinner)findViewById(R.id.partner_add_technogic_spiner_workways_id);
		techOptionSpinner = (Spinner)findViewById(R.id.partner_add_technogic_spiner_opion_id);
		techSalarySpinner = (Spinner)findViewById(R.id.partner_add_technogic_spiner_salary_id);
		techOtherEditText = (EditText)findViewById(R.id.partner_add_technogic_edit_other_id);
	}
	
	private void initData(){
		titleText.setText("’ŸªΩ∫œªÔ»À");
		techWorkwaySpinner.setAdapter(productArrayAdapte(R.array.partner_work_ways));
		techOptionSpinner.setAdapter(productArrayAdapte(R.array.partner_opion));
		techSalarySpinner.setAdapter(productArrayAdapte(R.array.partner_salary));
		
		techlogicBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
					techWorkwaySpinner.showContextMenu();
					techeLayout.setVisibility(View.VISIBLE);
				}else{
					techeLayout.setVisibility(View.GONE);
				}
			}
		});
	}
	
	private ArrayAdapter productArrayAdapte(int arraysId){
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this,
				arraysId, android.R.layout.simple_spinner_item); 
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
		return adapter;
	}
	
	
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.title_back_id:
			finished();
			break;
		case R.id.title_right_text_id:
			if(techlogicBox.isChecked()){
				ProjectPartnerInfo info = new ProjectPartnerInfo();
				info.setWorkway(techWorkwaySpinner.getSelectedItem().toString());
				info.setOption(techOptionSpinner.getSelectedItem().toString());
				info.setSalary(techSalarySpinner.getSelectedItem().toString());
				info.setRoleName(techlogicBox.getText().toString());
				info.setOthere(techOtherEditText.getText()!=null?techOtherEditText.getText().toString():"");
				partnerInfo.add(info);
			}
			Intent intent = new Intent();
			intent.putExtra("partnerlistinfo",partnerInfo);
			setResult(RQUEST_CODE_PARTNER,intent);
			finished();
			break;
		default:
			break;
		}
	}
}
