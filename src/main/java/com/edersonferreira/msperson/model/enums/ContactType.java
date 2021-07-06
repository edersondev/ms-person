package com.edersonferreira.msperson.model.enums;

public enum ContactType {
	EMAIL(1),CELLPHONE(2),TELEPHONE(3);
	
	private int code;
	
	private ContactType(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static ContactType valueOf(int code) {
		for(ContactType value : ContactType.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid contact type");
	}
}
