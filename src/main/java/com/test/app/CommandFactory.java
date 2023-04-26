package com.test.app;

import com.test.draw.AbstractCommand;
import com.test.draw.Canvas;
import com.test.draw.Line;
import com.test.draw.Quit;
import com.test.draw.Rectangle;
import com.test.exception.InValidParameterException;
import com.test.model.Input;

public class CommandFactory {

	public final AbstractCommand getCommand(Input input) throws InValidParameterException {
		var command = switch (input.getValidShapeType()) {
		case CANVAS -> new Canvas();
		case LINE -> new Line();
		case RECTANGLE -> new Rectangle();		
		case QUIT -> new Quit();
		default -> throw new InValidParameterException("Invalid command!");
		};
		return command;
	}
}
