package com.test.app;

import java.util.List;

import com.test.draw.AbstractCommand;
import com.test.exception.InValidParameterException;
import com.test.model.Input;

public class CommandContext {

	private AbstractCommand command;

	private final CommandFactory factory = new CommandFactory();

	public void setCommand(final Input input) throws InValidParameterException {
		var newCommand = factory.getCommand(input);
		if (this.command != null) {
			newCommand.setHeight(this.command.getHeight());
			newCommand.setWidth(this.command.getWidth());
			newCommand.setShape(this.command.getShape());
		}
		this.command = newCommand;
	}

	public void executeCommand(final List<String> params) throws InValidParameterException {
		command.execute(params);
	}
}
