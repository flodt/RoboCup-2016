package flodt.rcup.test;

import lejos.hardware.Button;
import lejos.hardware.port.MotorPort;
import flodt.rcup.libs.Constants;
import flodt.rcup.libs.LargeMotor;

public class Test {
	/**
	 * Test method for experiments.
	 * @param args
	 */
	public static void main(String[] args) {
		LargeMotor l = new LargeMotor(MotorPort.A);
		LargeMotor r = new LargeMotor(MotorPort.D);
		
		while (Button.ESCAPE.isUp()) {
			Button.waitForAnyPress();
			
			l.bwd(Constants.Speeds.GREEN_DOT_BWD);
			r.fwd(Constants.Speeds.GREEN_DOT_FWD);
			
			try {
				Thread.sleep(Constants.MotorValues.TURNING_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			l.brk();
			r.brk();
		}
	}

}
