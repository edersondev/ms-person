package com.edersonferreira.msperson.model.enums;

public enum BondType {
	GENETIC(1), SOCIAL(2);
	
	private int code;
	
	private BondType(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static BondType valueOf(int code) {
		for(BondType value : BondType.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid type bond");
	}
}
