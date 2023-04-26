package com.test.model;

import java.util.Arrays;
import java.util.List;
import com.test.enums.ValidShapeType;

public class Input 
{

	private ValidShapeType validShapeType;
	private List<String> params;

	public Input() {
	}

	public Input(String input) {
		String[] tokens = input.split(" ");
		this.validShapeType = ValidShapeType.get(tokens[0].toUpperCase());

		//removed the first shape letter and create parameter list
		this.params = Arrays.asList( Arrays.copyOfRange(tokens, 1, tokens.length));
		
		//System.out.println(this.validShapeType+ " ----> "+ this.params);
	}

	public ValidShapeType getValidShapeType() {
		return validShapeType;
	}

	public void setValidShapeType(ValidShapeType validShapeType) {
		this.validShapeType = validShapeType;
	}


	public List<String> getParams() {
		return params;
	}


	public void setParams(List<String> params) {
		this.params = params;
	}

		
}
