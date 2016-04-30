package flodt.rcup.libs;

import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.NXTUltrasonicSensor;
import lejos.robotics.Color;
//import lejos.hardware.sensor.EV3TouchSensor;
//import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

public class SensorData {
	//private Port touchport;
	private Port colorport;
	private Port usport;
	private Port colorport2;
	
	//private EV3TouchSensor touchs;
	private EV3ColorSensor colors;
	private EV3ColorSensor colors2;
	private NXTUltrasonicSensor uss;
	
	//private SampleProvider touchp;
	private SampleProvider brghtp;
	private SampleProvider brghtp2;
	private SampleProvider colorp;
	private SampleProvider colorp2;
	private SampleProvider usp;
	/**
	 * Access sensor data through this class
	 * @param colorl SensorPort of the left color sensor
	 * @param colorr SensorPort of the right color sensor
	 * @param us SensorPort of the ultrasonic sensor
	 */
	public SensorData (String colorl, String colorr, String us) {
		Brick b = BrickFinder.getDefault();
		
		/*touchport = b.getPort(touch);
		touchs = new EV3TouchSensor(touchport);
		touchp = touchs.getTouchMode();*/
		
		System.out.println("Color left...");
		System.out.println("Port " + colorl + "...");
		colorport = b.getPort(colorl);
		System.out.println("Sensor...");
		colors = new EV3ColorSensor(colorport);
		System.out.println("Brightness-Provider...");
		brghtp = colors.getRedMode();
		System.out.println("Color-Provider...");
		colorp = colors.getColorIDMode();
		System.out.println("");
		
		System.out.println("Color right...");
		System.out.println("Port " + colorr + "...");
		colorport2 = b.getPort(colorr);
		System.out.println("Sensor...");
		colors2 = new EV3ColorSensor(colorport2);
		System.out.println("Brightness-Provider...");		
		brghtp2 = colors2.getRedMode();
		System.out.println("Color-Provider...");
		colorp2 = colors2.getColorIDMode();
		System.out.println("");
		
		System.out.println("Ultrasonic...");
		System.out.println("Port " + us + "...");
		usport = b.getPort(us);
		System.out.println("Sensor...");
		uss = new NXTUltrasonicSensor(usport);
		System.out.println("Continuous-Pdr...");
		usp = uss.getContinuousMode();
		System.out.println("");
	}
	
	/*public float touch () {
		float[] toucha = new float[1];
		touchp.fetchSample(toucha, 0);
		return toucha[0];
	}*/
	
	/**
	 * Get the brightness value of the left color sensor.
	 * @return The brightness value of the left color sensor as a float (0-1).
	 */
	public float brghtl () {
		try {
			float[] brghta = new float[1];
			brghtp.fetchSample(brghta, 0);
			return brghta[0];
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Get the brightness value of the right color sensor.
	 * @return The brightness value of the right color sensor as a float (0-1).
	 */
	public float brghtr () {
		try {
			float[] brghta2 = new float[1];
			brghtp2.fetchSample(brghta2, 0);
			return brghta2[0];
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Get the color id of the left color sensor.
	 * @return The color id of the left color sensor as an int.
	 */
	public float colorl () {
		try {
			float[] colora = new float[1];
			colorp.fetchSample(colora, 0);
			return colora[0];
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			return Color.NONE;
		}
	}
	
	/**
	 * Get the color id of the right color sensor.
	 * @return The color id of the right color sensor as an int.
	 */
	public float colorr () {
		try {
			float[] colora2 = new float[1];
			colorp2.fetchSample(colora2, 0);
			return colora2[0];
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			return Color.NONE;
		}
	}
	
	/**
	 * Get the distance value of the ultrasonic sensor.
	 * @return The distance value of the ultrasonic sensor as a float in metres.
	 */
	public float us () {
		try {
			float[] usa = new float[1];
			usp.fetchSample(usa, 0);
			return usa[0];
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Disconnects from all sensors.
	 */
	public void close () {
		//touchs.close();
		colors.close();
		colors2.close();
		uss.close();
	}
}
