package com.boot.security.server.model;

import java.util.Date;

public class FormResult extends BaseEntity<Long> {

	private Integer instanceId;
	private Integer userId;
	private Integer elementId;
	private String elementAnswer;
	private Integer createBy;
	private Date createDate;
	private Integer updateBy;
	private Date updateDate;

	public Integer getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(Integer instanceId) {
		this.instanceId = instanceId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getElementId() {
		return elementId;
	}
	public void setElementId(Integer elementId) {
		this.elementId = elementId;
	}
	public String getElementAnswer() {
		return elementAnswer;
	}
	public void setElementAnswer(String elementAnswer) {
		this.elementAnswer = elementAnswer;
	}
	public Integer getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
