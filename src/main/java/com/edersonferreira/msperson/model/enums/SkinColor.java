package com.edersonferreira.msperson.model.enums;

public enum SkinColor {
	BLACK(1),WHITE(2),BROWN(3),YELLOW(4),INDIGENOUS(5);
	
	private int code;
	
	private SkinColor(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static SkinColor valueOf(int code) {
		for(SkinColor value : SkinColor.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid skin color");
	}
}
