package com.test.draw;

import java.util.List;

import com.test.exception.InValidParameterException;

public class Quit extends AbstractCommand {

	@Override
	public void execute(final List<String> params) throws InValidParameterException {
		System.exit(0);
	}
}
