package flodt.rcup.libs;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.robotics.RegulatedMotor;

public class LargeMotor {
	private RegulatedMotor m;
	
	public LargeMotor (Port mport) {
		m = new EV3LargeRegulatedMotor(mport);
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
		m.rotate(deg, immediateReturn);
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
