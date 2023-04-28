package com.test.app;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.test.exception.InValidParameterException;
import com.test.model.Input;
import com.test.enums.ValidShapeType;

public class PlotLineRectInCanvasApplication {

	private CommandContext commandContext;

	public static final String regexPattern = "[a-zA-Z]{1}(\\s\\d+)*";
	

	public static void main(String[] args) {

		PlotLineRectInCanvasApplication plotLineRectInCanvasApplication = new PlotLineRectInCanvasApplication();
		
		Scanner scanner = null;

		try{
			scanner = new Scanner(System.in);
			do {
				try 
				{
					System.out.print("Enter command: ");
					plotLineRectInCanvasApplication.getUserInputParams(scanner.nextLine());

				} 
				catch (InValidParameterException invalidInputException) 
				{
					System.err.println(invalidInputException.getMessage());
				}
			}while (true);
		}
		catch(Exception exception)
		{
			System.err.println(exception.getMessage());

		}finally{
				scanner.close();
			}		
			
	}

	private void getUserInputParams(String inputs) {
		
		parametersValidation(inputs);

		Input input = new Input(inputs);

		//System.out.println("commandContext ----> "+ commandContext );

		if (commandContext == null) {

			//System.out.println("commandContext 1----> "+ commandContext );

			if (!(input.getValidShapeType().equals(ValidShapeType.CANVAS) || input.getValidShapeType().equals(ValidShapeType.QUIT))) {
				throw new InValidParameterException(
						"No Canvas is available to plot shapes. Please create a canvas with Width X Height.");
			} else {
				commandContext = new CommandContext();
				//System.out.println("commandContext 3 ----> "+ commandContext );
			}
		}
		
		commandContext.setCommand(input);
		commandContext.executeCommand(input.getParams());
	}

	private void parametersValidation(String inputs) {

		Matcher matcher = Pattern.compile( regexPattern ).matcher(inputs);

		if (!matcher.matches()) 
		{
			throw new InValidParameterException("Given input values are invalid.");
		}

		String shape = String.valueOf( inputs.charAt(0)).toUpperCase();

		if (null == ValidShapeType.get(shape)) 
		{
			throw new InValidParameterException("Given shape type '" + shape + "' is not a valid shape type. Allowed params -> C for Creating a canvas, L for line, R for rectangle and Q for quit.");
		}
	}
	
}
