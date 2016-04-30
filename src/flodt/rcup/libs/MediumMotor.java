package flodt.rcup.libs;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.robotics.RegulatedMotor;

public class MediumMotor {
	private RegulatedMotor m;
	
	/**
	 * Control medium EV3 motors with this class.
	 * @param mport MotorPort of the motor you want to access.
	 */
	public MediumMotor (Port mport) {
		m = new EV3MediumRegulatedMotor(mport);
	}
	
	/**
	 * Drive forward at a set speed.
	 * @param speed
	 */
	public void fwd (int speed) {
		m.setSpeed(speed);
		m.forward();
	}
	
	/**
	 * Drive backwards at a set speed.
	 * @param speed
	 */
	public void bwd (int speed) {
		m.setSpeed(speed);
		m.backward();
	}
	
	/**
	 * Turn a set amount of degrees at a set speed.
	 * @param speed The speed to drive at.
	 * @param deg The amount of degrees to turn.
	 * @param immediateReturn Return immediately and continue if true
	 */
	public void deg (int speed, int deg, boolean immediateReturn) {
		m.setSpeed(speed);
		m.rotate(deg,immediateReturn);
	}
	
	/**
	 * Turn to a set degree number at a set speed.
	 * @param speed The speed to drive at.
	 * @param deg The degree number to turn to.
	 * @param immediateReturn Return immediately and continue if true
	 */
	public void toDeg (int speed, int deg, boolean immediateReturn) {
		m.setSpeed(speed);
		m.rotateTo(deg,immediateReturn);
	}
	
	/**
	 * Reset the tacho count of the motor.
	 */
	public void resetTacho () {
		m.resetTachoCount();
	}
	
	/**
	 * Get the current tacho count of the motor.
	 * @return The tacho count in degrees
	 */
	public int getTacho () {
		return m.getTachoCount();
	}
	
	/**
	 * Brakes the motor.
	 */
	public void brk () {
		m.stop();
	}
	
	/**
	 * Cuts power to the motor.
	 */
	public void flt () {
		m.flt();
	}
	
	/**
	 * Cuts power and disconnects from the motor.
	 */
	public void fstop () {
		m.flt();
		m.close();
	}
	
	/**
	 * Disconnects from the motor.
	 */
	public void close () {
		m.close();
	}
}
