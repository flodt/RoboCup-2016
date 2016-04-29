package flodt.rcup.main;

import lejos.hardware.Button;
import flodt.rcup.libs.LeJOSColors;
import flodt.rcup.libs.SensorData;
import flodt.rcup.libs.SensorPort;

public class ReadSensorsColor {
	public static void main (String[]args) {
		System.out.println("Initializing...");
		SensorData sensor = new SensorData(SensorPort.ONE, SensorPort.TWO, SensorPort.FOUR);
		
		while (Button.ESCAPE.isUp()) {
			System.out.println(LeJOSColors.getFriendlyName((int) sensor.colorl()) + " / " + LeJOSColors.getFriendlyName((int) sensor.colorr()));
		}
		System.out.println("Cleaning up...");
		sensor.close();
	}
}
