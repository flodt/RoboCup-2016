package flodt.rcup.logging;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
	private final String stdFormat = "dd/MM/yy HH:mm:ss";
    private DateFormat stdDF;

    public DateTime () {
        stdDF = new SimpleDateFormat(stdFormat);
    }
    public DateTime (String standardFormat) {
        stdDF = new SimpleDateFormat(standardFormat);
    }

    public String getCurrent () {
        Date date = new Date();
        return stdDF.format(date);
    }
    public String getCurrentInFormat (String dateFormat) {
        DateFormat userFormat1 = new SimpleDateFormat(dateFormat);
        Date date = new Date();
        return userFormat1.format(date);
    }

    public String getCurrentInBrackets () {
        Date date = new Date();
        return "[" + stdDF.format(date) + "]";
    }
    public String getCurrentInBracketsInFormat (String dateFormat) {
        DateFormat userFormat2 = new SimpleDateFormat(dateFormat);
        Date date = new Date();
        return "[" + userFormat2.format(date) + "]";
    }
}
