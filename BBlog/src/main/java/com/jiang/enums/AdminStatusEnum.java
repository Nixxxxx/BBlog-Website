package com.jiang.enums;

public enum AdminStatusEnum {
	
	NORMAL(0, "正常"),
	DISABLE(1, "已禁用");
	
	private Integer code;
	private String message;

	private AdminStatusEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
