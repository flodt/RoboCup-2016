package flodt.rcup.libs;

import lejos.robotics.Color;

public class LeJOSColors {
	public static String getFriendlyName(int color) {
		switch (color) {
			case Color.GREEN:
				return "Green";
			case Color.BLACK:
				return "Black";
			case Color.BLUE:
				return "Blue";
			case Color.YELLOW:
				return "Yellow";
			case Color.RED:
				return "Red";
			case Color.WHITE:
				return "White";
			case Color.BROWN:
				return "Brown";
			case Color.CYAN:
				return "Cyan";
			case Color.DARK_GRAY:
				return "Dark Gray";
			case Color.GRAY:
				return "Gray";
			case Color.LIGHT_GRAY:
				return "Light Gray";
			case Color.MAGENTA:
				return "Magenta";
			case Color.ORANGE:
				return "Orange";
			case Color.PINK:
				return "Pink";
			case Color.NONE:
				return "None";
			default:
				return "ERR";
		}
	}
}
