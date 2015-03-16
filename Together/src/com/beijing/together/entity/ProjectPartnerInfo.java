package com.beijing.together.entity;

import java.io.Serializable;

public class ProjectPartnerInfo implements Serializable{
	
	private String roleName;
	private String workway;
	private String option;//ÆÚÈ¨
	private String salary;
	private String othere;
	
   public String getOthere() {
		return othere;
	}

	public void setOthere(String othere) {
		this.othere = othere;
	}

public ProjectPartnerInfo() {
   }	
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getWorkway() {
		return workway;
	}
	public void setWorkway(String workway) {
		this.workway = workway;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
}
