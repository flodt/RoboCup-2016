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
	
	public void fwd (int speed) {
		m.setSpeed(speed);
		m.forward();
	}
	
	public void bwd (int speed) {
		m.setSpeed(speed);
		m.backward();
	}
	
	public void deg (int speed, int deg, boolean immediateReturn) {
		m.setSpeed(speed);
		m.rotate(deg,immediateReturn);
	}
	
	public void toDeg (int speed, int deg, boolean immediateReturn) {
		m.setSpeed(speed);
		m.rotateTo(deg,immediateReturn);
	}
	
	public void resetTacho () {
		m.resetTachoCount();
	}
	
	public int getTacho () {
		return m.getTachoCount();
	}
	
	public void brk () {
		m.stop();
	}
	
	public void flt () {
		m.flt();
	}
	
	public void fstop () {
		m.flt();
		m.close();
	}
	
	public void close () {
		m.close();
	}
}
