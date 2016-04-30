package flodt.rcup.main;

import lejos.hardware.Button;
import flodt.rcup.libs.Constants;
import flodt.rcup.libs.SensorData;
import flodt.rcup.libs.SensorPort;

public class ReadSensorsBrght {
	/**
	 * Read and print out sensor values for brightness.
	 * @param args
	 */
	public static void main (String[]args) {
		System.out.println("Initializing...");
		SensorData sensor = new SensorData(SensorPort.ONE, SensorPort.TWO, SensorPort.FOUR);
		
		while (Button.ESCAPE.isUp()) {
			System.out.println(sensor.brghtl() + "/" + sensor.brghtr() + "/" + Constants.SensorValues.SCHWELLE);
		}
		System.out.println("Cleaning up...");
		sensor.close();
	}
}
