package flodt.rcup.libs;
import flodt.rcup.main.Main;

/**
 * Evade an object on the line.
 * @author Flo
 *
 */
public class Evade {
	
	/**
	 * Evade any object on the line. Dependant on the constant Arena.TURNING_DIRECTION.
	 */
	public static void evadeObject() {
		if (Constants.Arena.TURNING_DIRECTION.equals(Constants.Arena.LEFT_DIRECTION)) {
			System.out.println("Preset is " + Constants.Arena.LEFT_DIRECTION);
			evadeObjectLeft();
		}
		if (Constants.Arena.TURNING_DIRECTION.equals(Constants.Arena.RIGHT_DIRECTION)) {
			System.out.println("Preset is " + Constants.Arena.RIGHT_DIRECTION);
			evadeObjectRight();
		}
	}
	
	/**
	 * Evade an object to the left.
	 */
	private static void evadeObjectLeft() {
		//Zurück fahren
		Main.l.resetTacho();
		Main.r.resetTacho();
		Main.l.bwd(Constants.Speeds.SLOWER);
		Main.r.bwd(Constants.Speeds.SLOWER);
		while (Main.l.getTacho() > Constants.MotorValues.EVADE_BACK) {
			System.out.println("Back " + Main.l.getTacho() + " / " + Constants.MotorValues.EVADE_BACK);
		}
		
		//Links drehen
		Main.l.resetTacho();
		Main.r.resetTacho();
		Main.l.bwd(Constants.Speeds.SLOWER);
		Main.r.fwd(Constants.Speeds.SLOWER);
		while (Main.r.getTacho() < Constants.MotorValues.EVADE_TURN_1) {
			System.out.println("Left " + Main.r.getTacho() + " / " + Constants.MotorValues.EVADE_TURN_1);
		}
		Main.l.brk();
		Main.r.brk();
		
		//Vorwärts fahren
		Main.l.resetTacho();
		Main.r.resetTacho();
		Main.l.fwd(Constants.Speeds.SLOWER);
		Main.r.fwd(Constants.Speeds.SLOWER);
		while (Main.r.getTacho() < Constants.MotorValues.EVADE_FWD) {
			System.out.println("Fwd " + Main.r.getTacho() + " / " + Constants.MotorValues.EVADE_FWD);
		}
		Main.l.brk();
		Main.r.brk();
		
		
		//Rechts drehen
		Main.l.resetTacho();
		Main.r.resetTacho();
		Main.l.fwd(Constants.Speeds.SLOWER);
		Main.r.bwd(Constants.Speeds.SLOWER);
		while (Main.l.getTacho() < Constants.MotorValues.EVADE_TURN_2) {
			System.out.println("Right " + Main.l.getTacho() + " / " + Constants.MotorValues.EVADE_TURN_2);
		}
		Main.l.brk();
		Main.r.brk();
		
		//Linie suchen
		Main.l.resetTacho();
		Main.r.resetTacho();
		Main.l.fwd(Constants.Speeds.SLOW);
		Main.r.fwd(Constants.Speeds.SLOWER);
		
		while (Main.sensor.brghtl() > Constants.SensorValues.SCHWELLE) {
			System.out.println("Srchng Line / " + Main.sensor.brghtl());
		}
		return;
	}
	
	/**
	 * Evade an object to the right.
	 */
	private static void evadeObjectRight() {
		//Zurück fahren
		Main.l.resetTacho();
		Main.r.resetTacho();
		Main.l.bwd(Constants.Speeds.SLOWER);
		Main.r.bwd(Constants.Speeds.SLOWER);
		while (Main.l.getTacho() > Constants.MotorValues.EVADE_BACK) {
			System.out.println("Back " + Main.l.getTacho() + " / " + Constants.MotorValues.EVADE_BACK);
		}
		
		//Rechts drehen
		Main.l.resetTacho();
		Main.r.resetTacho();
		Main.l.fwd(Constants.Speeds.SLOWER);
		Main.r.bwd(Constants.Speeds.SLOWER);
		while (Main.l.getTacho() < Constants.MotorValues.EVADE_TURN_1) {
			System.out.println("Right " + Main.l.getTacho() + " / " + Constants.MotorValues.EVADE_TURN_1);
		}
		Main.l.brk();
		Main.r.brk();
		
		//Vorwärts fahren
		Main.l.resetTacho();
		Main.r.resetTacho();
		Main.l.fwd(Constants.Speeds.SLOWER);
		Main.r.fwd(Constants.Speeds.SLOWER);
		while (Main.l.getTacho() < Constants.MotorValues.EVADE_FWD) {
			System.out.println("Fwd " + Main.l.getTacho() + " / " + Constants.MotorValues.EVADE_FWD);
		}
		Main.l.brk();
		Main.r.brk();
		
		//Links drehen
		Main.l.resetTacho();
		Main.r.resetTacho();
		Main.l.bwd(Constants.Speeds.SLOWER);
		Main.r.fwd(Constants.Speeds.SLOWER);
		while (Main.r.getTacho() < Constants.MotorValues.EVADE_TURN_2) {
			System.out.println("Left " + Main.r.getTacho() + " / " + Constants.MotorValues.EVADE_TURN_2);
		}
		Main.l.brk();
		Main.r.brk();
		
		//Linie suchen
		Main.l.resetTacho();
		Main.r.resetTacho();
		Main.l.fwd(Constants.Speeds.SLOWER);
		Main.r.fwd(Constants.Speeds.SLOW);
		
		while (Main.sensor.brghtr() > Constants.SensorValues.SCHWELLE) {
			System.out.println("Srchng Line / " + Main.sensor.brghtr());
		}
		return;
	}
}
