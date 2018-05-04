package com.boot.security.server.model;

import java.util.Date;

public class BCrud extends BaseEntity<Long> {

	private String bname;
	private Date bdate;

	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

}
