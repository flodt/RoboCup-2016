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

	/**
	 * Manages logging.
	 */
    public Logging () {
        try {
        	header = new Header();
            printStream = new PrintStream(new File(Header.generateFileName()));
            writeHeader();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Write the header of the log to the file. Only called by the constructor.
     */
    private void writeHeader () {
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

    /**
     * Write somehting to the log and print without a prefix.
     * @param msg The line to write to the log.
     * @return
     */
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

    /**
     * Write a new line to the log.
     * @return Error check boolean
     */
    public boolean writeNewLine () {
        try {
            printStream.print("\n");
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Log the start of the run and start timer.
     */
    public void logStart() {
    	log("Starting now");
    	startTime = System.nanoTime();
    }
    
    /**
     * Log the end of the run, end the timer and calculate the time that was needed for the run.
     */
    public void logEnd() {
    	log("Run finished");
    	endTime = System.nanoTime();
    	runTime = endTime - startTime;
    	runTimeSecs = runTime/1000000000;
    	log("Runtime was " + runTimeSecs);
    }
    
    /**
     * Log an obstacle detected.
     */
    public void logObstacleDetected() {
    	log("Obstacle found, evading now");
    }
    
    /**
     * Log an obstacle successfully evaded.
     */
    public void logObstacleSuccessfullyEvaded() {
    	log("Evaded successfully - returned to line");
    }
    
    /**
     * Log the robot adjusting it's position to continue following the line.
     */
    public void logLineAdjust() {
    	log("Following line - adjusting");
    }
    
    /**
     * Log a left turn at a crossing.
     */
    public void logLeftTurn() {
    	log("Turning left");
    }
    
    /**
     * Log a right turn at a crossing.
     */
    public void logRightTurn() {
    	log("Turning right");
    }
    
    /**
     * Log a message including prefix.
     * @param msg The String to log to the file.
     * @return Error check boolean.
     */
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
    
    /**
     * Flush the stream and disconnect from the file.
     */
    public void close () {
    	printStream.flush();
    	printStream.close();
    }
}
