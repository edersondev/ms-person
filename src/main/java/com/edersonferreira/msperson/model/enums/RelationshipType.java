package com.edersonferreira.msperson.model.enums;

public enum RelationshipType {
	FATHER(1), MOTHER(2), CHILDREN(3), SPOUSE(4);
	
	private int code;
	
	private RelationshipType(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static RelationshipType valueOf(int code) {
		for(RelationshipType value : RelationshipType.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid type relationship");
	}
}
