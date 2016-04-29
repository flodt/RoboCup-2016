package flodt.rcup.logging;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import flodt.rcup.libs.Constants;

public class Logging {
	private static PrintStream printStream;
	public static Header header;
	
	long startTime;
	long endTime;
	long runTime;
	double runTimeSecs;

    public Logging () {
        try {
        	header = new Header();
            printStream = new PrintStream(new File(Header.generateFileName()));
            writeHeader();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void writeHeader () {
    	write("RUN LOG");
    	write("-------");
    	writeNewLine();
    	write("Start Time: " + new DateTime().getCurrent());
    	writeNewLine();
    	write("Location: " + Constants.General.LOC);
    	write("Speeds (FASTER,FAST,MED,SLOW,SLOWER): " + Constants.Speeds.FASTER + "," + Constants.Speeds.FAST + "," + Constants.Speeds.MED + "," + Constants.Speeds.SLOW + "," + Constants.Speeds.SLOWER);
    	write("Sensor Presets (Light thrshld, Dist thrshld): " + Constants.SensorValues.SCHWELLE + ", " + Constants.SensorValues.US_SCHWELLE);
    	write("Evade direction: " + Constants.Arena.TURNING_DIRECTION);
    	write("Values (turntime,back,turn1,fwd,turn2): " + Constants.MotorValues.TURNING_TIME + "," + Constants.MotorValues.EVADE_BACK + "," + Constants.MotorValues.EVADE_TURN_1 + "," + Constants.MotorValues.EVADE_FWD + "," + Constants.MotorValues.EVADE_TURN_2);
    	writeNewLine();
    	writeNewLine();
    }

    public boolean write (String msg) {
        try {
            System.out.println(msg);
            printStream.print(msg + "\n");
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean writeNewLine () {
        try {
            printStream.print("\n");
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void logStart() {
    	log("Starting now");
    	startTime = System.nanoTime();
    }
    
    public void logEnd() {
    	log("Run finished");
    	endTime = System.nanoTime();
    	runTime = endTime - startTime;
    	runTimeSecs = runTime/1000000000;
    	log("Runtime was " + runTimeSecs);
    }
    
    public void logObstacleDetected() {
    	log("Obstacle found, evading now");
    }
    
    public void logObstacleSuccessfullyEvaded() {
    	log("Evaded successfully - returned to line");
    }
    
    public void logLineAdjust() {
    	log("Following line - adjusting");
    }
    
    public void logLeftTurn() {
    	log("Turning left");
    }
    
    public void logRightTurn() {
    	log("Turning right");
    }
    
    public static boolean log (String msg) {
        try {
            String logStr = Header.generatePrefix() + " " + msg + "\n";
            printStream.print(logStr);
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public void close () {
    	printStream.flush();
    	printStream.close();
    }
}
