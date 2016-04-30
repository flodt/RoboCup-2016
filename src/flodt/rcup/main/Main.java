package flodt.rcup.main;

import flodt.rcup.libs.*;
import flodt.rcup.logging.Logging;
import lejos.hardware.*;
import lejos.hardware.port.MotorPort;
import lejos.robotics.Color;

public class Main {
	public static LargeMotor l;
	public static LargeMotor r;
	public static SensorData sensor;
	
	public static Logging logger;
	
	/**
	 * Line following program.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Initializing...");
		logger = new Logging();
		
		//Motoren einrichten
		System.out.println("Motors...");
		l = new LargeMotor(MotorPort.A);
		r = new LargeMotor(MotorPort.D);
		
		//Sensoren einrichten
		System.out.println("Sensors...");
		sensor = new SensorData(SensorPort.ONE, SensorPort.TWO, SensorPort.FOUR);
		
		System.out.println("Ready!");
		
		while (Button.ENTER.isUp()) {
			System.out.print(".");
			try {
				Thread.sleep(750);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println();
		System.out.println("Go!");
		logger.logStart();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Hauptschleife
		while (Button.ESCAPE.isUp()) {
			//US-Sensor testen
			//		Objekt ausweichen
			if (sensor.us() < Constants.SensorValues.US_SCHWELLE) {
				logger.logObstacleDetected();
				Evade.evadeObject();
				logger.logObstacleSuccessfullyEvaded();
			}
			
			// O | | O
			//Sensoren auf weiß
			//		geradeaus fahren
			if (sensor.brghtl() > Constants.SensorValues.SCHWELLE && sensor.brghtr() > Constants.SensorValues.SCHWELLE) {
				System.out.println("^ / " + sensor.brghtl() + " / " + sensor.brghtr());
				logger.logLineAdjust();
				l.fwd(Constants.Speeds.FAST);
				r.fwd(Constants.Speeds.FAST);
			}
			// |O| O
			//linker Sensor auf Linie
			//		wenn grün/braun erkannt
			//			nach links abbiegen
			//		wenn kein grün/braun erkannt
			//			nach links lenken
			if (sensor.brghtl() < Constants.SensorValues.SCHWELLE && sensor.brghtr() > Constants.SensorValues.SCHWELLE) {
				if (sensor.colorl() == Color.GREEN) {
					System.out.println("<- / " + LeJOSColors.getFriendlyName((int) sensor.colorl()) + "/" + LeJOSColors.getFriendlyName((int) sensor.colorr()));
					logger.logLeftTurn();
					l.brk();
					r.fwd(Constants.Speeds.MED);
					
					try {
						Thread.sleep(Constants.MotorValues.TURNING_TIME);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					while (sensor.brghtr() > Constants.SensorValues.SCHWELLE) {
						System.out.println("<- / " + LeJOSColors.getFriendlyName((int) sensor.colorl()) + "/" + LeJOSColors.getFriendlyName((int) sensor.colorr()));
					}
				} else {
					System.out.println("< / " + sensor.brghtl() + " / " + sensor.brghtr());
					logger.logLineAdjust();
					l.bwd(Constants.Speeds.SLOW_TURN_SIDE);
					r.fwd(Constants.Speeds.FAST_TURN_SIDE);
				}
			}
			
			// O |O|
			//rechter Sensor auf Linie
				//		wenn grün/braun erkannt
				//			nach rechts abbiegen
				//		wenn kein grün/braun erkannt
				//			nach rechts lenken
			if (sensor.brghtl() > Constants.SensorValues.SCHWELLE && sensor.brghtr() < Constants.SensorValues.SCHWELLE) {
				if (sensor.colorr() == Color.GREEN) {
					System.out.println("-> / " + LeJOSColors.getFriendlyName((int) sensor.colorl()) + "/" + LeJOSColors.getFriendlyName((int) sensor.colorr()));
					logger.logRightTurn();
					l.fwd(Constants.Speeds.MED);
					r.brk();
					
					try {
						Thread.sleep(Constants.MotorValues.TURNING_TIME);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					while (sensor.brghtl() > Constants.SensorValues.SCHWELLE) {
						System.out.println("-> / " + LeJOSColors.getFriendlyName((int) sensor.colorl()) + "/" + LeJOSColors.getFriendlyName((int) sensor.colorr()));
					}
				} else {
					System.out.println("> / " + sensor.brghtl() + " / " + sensor.brghtr());					logger.logLineAdjust();
					l.fwd(Constants.Speeds.FAST_TURN_SIDE);					r.bwd(Constants.Speeds.SLOW_TURN_SIDE);
					
				}
			}
			
			// -------
			// beide Sensoren auf Linie / beide schwarz
			if (sensor.brghtl() < Constants.SensorValues.SCHWELLE && sensor.brghtr() < Constants.SensorValues.SCHWELLE) {
				System.out.println("<^> / " + sensor.brghtl() + " / " + sensor.brghtr());
				logger.logLineAdjust();
				
				double x,y,z;
				int b;
				if (sensor.brghtl() > sensor.brghtr()) {
					x = sensor.brghtl();
					y = sensor.brghtr();
					b = 0;
				} else {
					x = sensor.brghtr();
					y = sensor.brghtl();
					b = 1;
				}
				
				if (x-y < 0.04F || x == 0 || y == 0) {
					l.fwd(Constants.Speeds.MED);
					r.fwd(Constants.Speeds.MED);
					continue;
				}
				
				z = (x/y)/2.5;
				if (b == 0) {
					l.fwd((int) (Constants.Speeds.SLOW * z));
					r.bwd(Constants.Speeds.SLOW);
				}				
			}
		}
		System.out.println("Cleaning up...");
		sensor.close();
		l.close();
		r.close();
		logger.close();
	}
}