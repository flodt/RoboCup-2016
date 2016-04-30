package flodt.rcup.logging;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
	private final String stdFormat = "dd/MM/yy HH:mm:ss";
    private DateFormat stdDF;

    /**
     * Access date and time in different formats.
     */
    public DateTime () {
        stdDF = new SimpleDateFormat(stdFormat);
    }
    
    /**
     * Access date and time in different formats.
     * @param standardFormat The standard format to use. If not specified, "dd/MM/yy HH:mm:ss" will be used.
     */
    public DateTime (String standardFormat) {
        stdDF = new SimpleDateFormat(standardFormat);
    }

    /**
     * Gets the current time and date.
     * @return The current time and date in the specified standard format.
     */
    public String getCurrent () {
        Date date = new Date();
        return stdDF.format(date);
    }
    
    /**
     * Gets the current time and date.
     * @param dateFormat Specifies the format in which the date and time will be formatted.
     * @return The current time and date in the given format.
     */
    public String getCurrentInFormat (String dateFormat) {
        DateFormat userFormat1 = new SimpleDateFormat(dateFormat);
        Date date = new Date();
        return userFormat1.format(date);
    }

    /**
     * Gets the current time and date in brackets.
     * @return The current time and date in the specified standard format in brackets.
     */
    public String getCurrentInBrackets () {
        Date date = new Date();
        return "[" + stdDF.format(date) + "]";
    }
    
    /**
     * Gets the current time and date in brackets.
     * @param dateFormat Specifies the format in which the date and time will be formatted.
     * @return The current time and date in the given format in brackets.
     */
    public String getCurrentInBracketsInFormat (String dateFormat) {
        DateFormat userFormat2 = new SimpleDateFormat(dateFormat);
        Date date = new Date();
        return "[" + userFormat2.format(date) + "]";
    }
}
