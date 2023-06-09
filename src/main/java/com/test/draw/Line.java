package com.test.draw;

import java.util.ArrayList;
import java.util.List;

import com.test.exception.InValidParameterException;

public class Line extends AbstractCommand {

	@Override
	public void execute(List<String> params) throws InValidParameterException {

		if (params.size() < 4) {
			throw new InValidParameterException(
					"Line command requires 4 parameters, " + params.size() + " params provided.");
		}

		int x1 = Integer.parseInt(params.get(0));
		int y1 = Integer.parseInt(params.get(1));
		int x2 = Integer.parseInt(params.get(2));
		int y2 = Integer.parseInt(params.get(3));

		validate(x1, y1, x2, y2);

		String line = getLine(x1, y1, x2, y2);

		// Draw line
		System.out.print(line);

	}

	private String getLine(int x1, int y1, int x2, int y2) {
		draw(x1, y1, x2, y2, 'x');
		return getShapeAsString();
	}

	public static void main(String[] args) throws InValidParameterException {
		Canvas canvas = new Canvas();
		List<String> params = new ArrayList<>();
		params.add("20");
		params.add("20");

		canvas.execute(params);

		Line line = new Line();
		params = new ArrayList<>();

		params.add("5");
		params.add("2");
		params.add("15");
		params.add("2");

		line.setHeight(20);
		line.setWidth(20);

		line.shape = canvas.shape;

		line.execute(params);

		params.clear();
				
		params.add("15");
		params.add("3");
		params.add("15");
		params.add("15");

		line.execute(params);
	}
}
