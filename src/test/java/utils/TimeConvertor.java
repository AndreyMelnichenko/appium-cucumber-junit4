package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

/**
 * created by Andrey Melnichenko at 17:15 10-09-2018
 */

public class TimeConvertor {
    public static String getTime(String time, String inFormat, String outFormat) {
        DateTimeFormatter simpleFormet = DateTimeFormatter.ofPattern(inFormat);
        DateTimeFormatter simpleFormet2 = DateTimeFormatter.ofPattern(outFormat);
        LocalDateTime date = LocalDateTime.parse(time, simpleFormet);
        return date.format(simpleFormet2);
    }

    public static String getTime(String time) {
        String inFormat = "EEE MMM d HH:mm:ss z yyyy";
        String outFormat = "dd.MM.yyyy HH:mm";
        DateTimeFormatter simpleFormet = DateTimeFormatter.ofPattern(inFormat);
        DateTimeFormatter simpleFormet2 = DateTimeFormatter.ofPattern(outFormat);
        LocalDateTime date = LocalDateTime.parse(time, simpleFormet);
        return date.format(simpleFormet2);
    }
}
