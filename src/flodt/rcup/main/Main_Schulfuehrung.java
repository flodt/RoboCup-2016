package flodt.rcup.main;

import flodt.rcup.libs.*;
import lejos.hardware.*;
import lejos.hardware.port.MotorPort;
import lejos.robotics.Color;

/*
 * Colors
 * Green:	1
 * Black:	7
 * Blue: 	2
 * Yellow:	3
 * Red:		0
 * White:	6
 * Brown:	13
 */

public class Main_Schulfuehrung {
	public static LargeMotor l;
	public static LargeMotor r;
	public static SensorData sensor;
	
	public static void main(String[] args) {
		System.out.println("Initializing...");
		
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
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Hauptschleife
		while (Button.ESCAPE.isUp()) {
			//US-Sensor testen
			//		Objekt ausweichen
			if (sensor.us() < 0.2F) {
				l.brk();
				r.brk();
				try {
					Thread.sleep(2000);
					continue;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			// O | | O
			//Sensoren auf weiß
			//		geradeaus fahren
			if (sensor.brghtl() > Constants.SensorValues.SCHWELLE && sensor.brghtr() > Constants.SensorValues.SCHWELLE) {
				System.out.println("^ / " + sensor.brghtl() + " / " + sensor.brghtr());
				l.fwd(Constants.Speeds.FASTER);
				r.fwd(Constants.Speeds.FASTER);
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
					l.bwd(Constants.Speeds.MED);
					r.fwd(Constants.Speeds.FAST);
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
					System.out.println("> / " + sensor.brghtl() + " / " + sensor.brghtr());					l.fwd(Constants.Speeds.FAST);					r.bwd(Constants.Speeds.MED);
					
				}
			}
			
			// -------
			// beide Sensoren auf Linie / beide sehen schwarz
			if (sensor.brghtl() < Constants.SensorValues.SCHWELLE && sensor.brghtr() < Constants.SensorValues.SCHWELLE) {
				System.out.println("^ / " + sensor.brghtl() + " / " + sensor.brghtr());
				l.fwd(Constants.Speeds.FASTER);
				r.fwd(Constants.Speeds.FASTER);
			}
		}
		System.out.println("Cleaning up...");
		sensor.close();
		l.close();
		r.close();
	}
}