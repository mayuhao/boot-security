package com.boot.security.server.model;

import java.util.Date;

public class Respondent extends BaseEntity<Long> {

	private Integer ID;
	private Integer INSTANCEID;
	private Integer RESPONDENTID;
	private Integer USERID;
	private Integer RESPONSESTATUS;
	private Integer CREATEBY;
	private Date CREATEDATE;
	private Integer UPDATEBY;
	private Date UPDATEDATE;

	public Integer getID() {
		return ID;
	}
	public void setID(Integer ID) {
		this.ID = ID;
	}
	public Integer getINSTANCEID() {
		return INSTANCEID;
	}
	public void setINSTANCEID(Integer INSTANCEID) {
		this.INSTANCEID = INSTANCEID;
	}
	public Integer getRESPONDENTID() {
		return RESPONDENTID;
	}
	public void setRESPONDENTID(Integer RESPONDENTID) {
		this.RESPONDENTID = RESPONDENTID;
	}
	public Integer getUSERID() {
		return USERID;
	}
	public void setUSERID(Integer USERID) {
		this.USERID = USERID;
	}
	public Integer getRESPONSESTATUS() {
		return RESPONSESTATUS;
	}
	public void setRESPONSESTATUS(Integer RESPONSESTATUS) {
		this.RESPONSESTATUS = RESPONSESTATUS;
	}
	public Integer getCREATEBY() {
		return CREATEBY;
	}
	public void setCREATEBY(Integer CREATEBY) {
		this.CREATEBY = CREATEBY;
	}
	public Date getCREATEDATE() {
		return CREATEDATE;
	}
	public void setCREATEDATE(Date CREATEDATE) {
		this.CREATEDATE = CREATEDATE;
	}
	public Integer getUPDATEBY() {
		return UPDATEBY;
	}
	public void setUPDATEBY(Integer UPDATEBY) {
		this.UPDATEBY = UPDATEBY;
	}
	public Date getUPDATEDATE() {
		return UPDATEDATE;
	}
	public void setUPDATEDATE(Date UPDATEDATE) {
		this.UPDATEDATE = UPDATEDATE;
	}

}
