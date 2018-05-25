package com.boot.security.server.model;

import java.util.Date;

public class FormDefinition extends BaseEntity<Long> {

	private Integer formId;
	private String formName;
	private Integer elementId;
	private Integer elementSeq;
	private Integer elementType;
	private Integer createBy;
	private Date createDate;
	private Integer updateBy;
	private Date updateDate;

	public Integer getFormId() {
		return formId;
	}
	public void setFormId(Integer formId) {
		this.formId = formId;
	}
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public Integer getElementId() {
		return elementId;
	}
	public void setElementId(Integer elementId) {
		this.elementId = elementId;
	}
	public Integer getElementSeq() {
		return elementSeq;
	}
	public void setElementSeq(Integer elementSeq) {
		this.elementSeq = elementSeq;
	}
	public Integer getElementType() {
		return elementType;
	}
	public void setElementType(Integer elementType) {
		this.elementType = elementType;
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
