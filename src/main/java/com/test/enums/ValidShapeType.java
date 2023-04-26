
package com.test.enums;

import java.util.HashMap;
import java.util.Map;


public enum ValidShapeType {

	CANVAS("C", 2), LINE("L", 4), RECTANGLE("R", 4), QUIT("Q", 0);

	private static final Map<String, ValidShapeType> lookup = new HashMap<>();

	static {
		for (ValidShapeType t : ValidShapeType.values()) {
			lookup.put(t.firstChar, t);
		}	
	}

	private final String firstChar;
	private final Integer allowedParams;

	private ValidShapeType(String firstChar, Integer allowedParams) {
		this.firstChar = firstChar;
		this.allowedParams = allowedParams;
	}

	public boolean equalsFirstChar(String other) {
		return firstChar.equals(other);
	}

	public String toString() {
		return this.firstChar;
	}

	public static ValidShapeType get(String firstChar) {
		return lookup.get(firstChar);
	}
}
