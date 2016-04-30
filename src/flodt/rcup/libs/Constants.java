package flodt.rcup.libs;

public class Constants {
	public class General {
		public static final int BUILD = 254;
		public static final String VOEH = "RCJ Qualifikation Voehringen";
		public static final String VOEH_SHORT = "Vhrg";
		public static final String MGDB = "RCJ Finale Magdeburg";
		public static final String MGDB_SHORT = "Mgdb";
		public static final String LOC = MGDB;
		public static final String LOC_SHORT = MGDB_SHORT;
	}
	public class Speeds {
		public static final int FASTER = 400;
		public static final int FAST = 360;
		public static final int MED = 300;
		public static final int SLOW = 270;
		public static final int SLOWER = 180;
		public static final int GREEN_DOT_FWD = 300;
		public static final int GREEN_DOT_BWD = 360;
	}
	
	public class SensorValues {
		public static final float SCHWELLE = 0.25F;
		public static final float US_SCHWELLE = 0.1F;
	}
	
	public class Arena {
		public static final String LEFT_DIRECTION = "LEFT";
		public static final String RIGHT_DIRECTION = "RIGHT";
		public static final String TURNING_DIRECTION = RIGHT_DIRECTION;
	}
	
	public class MotorValues {
		public static final int TURNING_TIME = 500;
		public static final int ADVANCE_DEGS = 300;
		
		public static final int EVADE_BACK = -200;
		public static final int EVADE_TURN_1 = 350;
		public static final int EVADE_FWD = 950;
		public static final int EVADE_TURN_2 = (int) ((int) EVADE_TURN_1 * 1.3);
	}
}
