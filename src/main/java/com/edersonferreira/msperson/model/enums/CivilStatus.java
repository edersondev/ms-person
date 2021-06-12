package com.edersonferreira.msperson.model.enums;

public enum CivilStatus {
	SINGLE(1),MARRIED(2),DIVORCED(3),WIDOWED(4),SEPARATED(5),STABLE_UNION(6);
	
	private int code;
	
	private CivilStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static CivilStatus valueOf(int code) {
		for(CivilStatus value: CivilStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid civil status");
	}
}
