package com.shin.pay.entity;

public class SysDic extends Entity {
	private static final long serialVersionUID = 1L;

	private String title;

	private String dicType;
	
	private String code;
	
	private String shortName;
	
	private String fullName;
	
	private String aliasShortName;
	
	private String aliasFullName;

	public String getDicType() {
		return dicType;
	}

	public void setDicType(String dicType) {
		this.dicType = dicType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAliasShortName() {
		return aliasShortName;
	}

	public void setAliasShortName(String aliasShortName) {
		this.aliasShortName = aliasShortName;
	}

	public String getAliasFullName() {
		return aliasFullName;
	}

	public void setAliasFullName(String aliasFullName) {
		this.aliasFullName = aliasFullName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("SysDic{");
		sb.append("title='").append(title).append('\'');
		sb.append(", dicType='").append(dicType).append('\'');
		sb.append(", code='").append(code).append('\'');
		sb.append(", shortName='").append(shortName).append('\'');
		sb.append(", fullName='").append(fullName).append('\'');
		sb.append(", aliasShortName='").append(aliasShortName).append('\'');
		sb.append(", aliasFullName='").append(aliasFullName).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
