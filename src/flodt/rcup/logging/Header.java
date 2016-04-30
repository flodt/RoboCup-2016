package flodt.rcup.logging;

import flodt.rcup.libs.Constants;

public class Header {
	public static DateTime time;
	
	/**
	 * Generates the header for the log files.
	 */
	public Header() {
		time = new DateTime();
	}
	
	/**
	 * Get the version number for the currently running program.
	 * @return The version number of the currently running program.
	 */
	public static String getVersionNumber() {
		return Constants.General.LOC_SHORT + "_" + Constants.General.BUILD;
	}
	
	/**
	 * Generates the prefix for each log line.
	 * @return The prefix in brackets for each logging line.
	 */
	public static String generatePrefix() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(time.getCurrent());
		sb.append(" - ");
		sb.append(getVersionNumber());
		sb.append("]");
		return sb.toString();
	}
	
	/**
	 * Generates the file name for the log files.
	 * @return The file name with extension for each log file.
	 */
	public static String generateFileName() {
		StringBuilder sb = new StringBuilder();
		sb.append(time.getCurrentInFormat("dd-MM-yy_HH-mm-ss"));
		sb.append(" ");
		sb.append(getVersionNumber());
		return sb.toString();
	}
}
