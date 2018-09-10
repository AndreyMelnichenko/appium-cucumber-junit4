package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * created by Andrey Melnichenko at 17:15 10-09-2018
 */

public class TimeConvertor {
    public static String getTime(String time, String inFormat, String outFormat){
        String deviceTime = time;

        SimpleDateFormat simpleFormet = new SimpleDateFormat(inFormat); //"EEE MMM d HH:mm:ss z yyyy"
        SimpleDateFormat simpleFormet2 = new SimpleDateFormat(outFormat); //"dd.MM.yyyy HH:mm"
        Date date = null;
        try {
            date = simpleFormet.parse(deviceTime);
        } catch (ParseException e) {
            System.out.println("\n\n\nWRONG FORMAT\n\n\n");
            e.printStackTrace();
        }
/*        System.out.println(date);
        System.out.println(simpleFormet.format(date));
        System.out.println(simpleFormet2.format(date));*/

        return simpleFormet2.format(date);
    }

    public static String getTime (String time){
        String deviceTime = time;
        SimpleDateFormat simpleFormet = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
        SimpleDateFormat simpleFormet2 = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Date date = null;
        try {
            date = simpleFormet.parse(deviceTime);
        } catch (ParseException e) {
            System.out.println("\n\n\nWRONG FORMAT\n\n\n");
            e.printStackTrace();
        }
        return simpleFormet2.format(date);
    }
}
