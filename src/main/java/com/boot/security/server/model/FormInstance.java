package com.boot.security.server.model;

import java.util.Date;

public class FormInstance extends BaseEntity<Long> {

	private Integer ID;
	private Integer FORMID;
	private Integer INSTANCEID;
	private String INSTANCENAME;
	private Integer RESPONDENTID;
	private Date STARTDATE;
	private Date ENDDATE;
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
	public Integer getFORMID() {
		return FORMID;
	}
	public void setFORMID(Integer FORMID) {
		this.FORMID = FORMID;
	}
	public Integer getINSTANCEID() {
		return INSTANCEID;
	}
	public void setINSTANCEID(Integer INSTANCEID) {
		this.INSTANCEID = INSTANCEID;
	}
	public String getINSTANCENAME() {
		return INSTANCENAME;
	}
	public void setINSTANCENAME(String INSTANCENAME) {
		this.INSTANCENAME = INSTANCENAME;
	}
	public Integer getRESPONDENTID() {
		return RESPONDENTID;
	}
	public void setRESPONDENTID(Integer RESPONDENTID) {
		this.RESPONDENTID = RESPONDENTID;
	}
	public Date getSTARTDATE() {
		return STARTDATE;
	}
	public void setSTARTDATE(Date STARTDATE) {
		this.STARTDATE = STARTDATE;
	}
	public Date getENDDATE() {
		return ENDDATE;
	}
	public void setENDDATE(Date ENDDATE) {
		this.ENDDATE = ENDDATE;
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
