package utils;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * created by Andrey Melnichenko at 17:48 11-09-2018
 */

public class MyTestClass {

    public static String getTime(String time, String inFormat, String outFormat) {
        DateTimeFormatter simpleFormet = DateTimeFormatter.ofPattern(inFormat);
        DateTimeFormatter simpleFormet2 = DateTimeFormatter.ofPattern(outFormat);
        LocalDateTime date = LocalDateTime.parse(time, simpleFormet);
        return date.format(simpleFormet2);
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println(getTime(
                "Tue Sep 11 08:28:59 EDT 2018",
                "EEE MMM d HH:mm:ss z yyyy",
                "dd.MM.yyyy HH:mm"
        ));
    }
}
