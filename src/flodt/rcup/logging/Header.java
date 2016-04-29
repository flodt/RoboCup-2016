package flodt.rcup.logging;

import flodt.rcup.libs.Constants;

public class Header {
	public static DateTime time;
	public Header() {
		time = new DateTime();
	}
	
	public static String getVersionNumber() {
		return Constants.General.LOC_SHORT + "_" + Constants.General.BUILD;
	}
	
	public static String generatePrefix() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(time.getCurrent());
		sb.append(" - ");
		sb.append(getVersionNumber());
		sb.append("]");
		return sb.toString();
	}
	
	public static String generateFileName() {
		StringBuilder sb = new StringBuilder();
		sb.append(time.getCurrentInFormat("dd-MM-yy_HH-mm-ss"));
		sb.append(" ");
		sb.append(getVersionNumber());
		return sb.toString();
	}
}
