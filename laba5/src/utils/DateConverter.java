package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import exceptions.WrongDateFormatException;

public class DateConverter {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss Z");
    private static DateTimeFormatter zonedDateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss Z");


    public static String dateToString(ZonedDateTime date){
        return date.format(formatter);
    }

    public static String dateToString(LocalDate date){
        return date.format(zonedDateFormatter);
    }

    public static LocalDate parseLocalDate(String s) throws WrongDateFormatException {
        try {
            return LocalDate.parse(s, zonedDateFormatter);
        } catch (java.time.format.DateTimeParseException e) {
            throw new WrongDateFormatException();
        }
    }
    public static ZonedDateTime parseDate(String s) throws WrongDateFormatException{
        try{
            return ZonedDateTime.parse(s);
            // return dateFormatter.parse(s);
        }
        catch (DateTimeParseException e){
            throw new WrongDateFormatException();
        }
    }
}
