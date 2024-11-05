package test.birthdaygreetings.helpers;

import birthdaygreetings.core.OurDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class OurDateFactory {
    private static final String DATE_FORMAT = "yyyy/MM/dd";

    public static OurDate ourDate(String dateAsString) throws ParseException {
        return new OurDate(new SimpleDateFormat(DATE_FORMAT).parse(dateAsString));
    }
}
