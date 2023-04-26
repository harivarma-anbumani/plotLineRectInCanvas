package com.test.draw;

import java.util.List;

import com.test.exception.InValidParameterException;

public interface Command {
	public void execute(List<String> params) throws InValidParameterException;
}
