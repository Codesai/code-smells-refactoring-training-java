package test.birthdaygreetings.core;

import birthdaygreetings.core.OurDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static test.birthdaygreetings.helpers.OurDateFactory.ourDate;

public class OurDateTest {
    @Test
    public void identifies_if_two_dates_were_in_the_same_day() throws Exception {
        OurDate ourDate = ourDate("1789/01/24");
        OurDate sameDay = ourDate("2001/01/24");
        OurDate notSameDay = ourDate("1789/01/25");
        OurDate notSameMonth = ourDate("1789/02/25");

        assertTrue(ourDate.isSameDay(sameDay), "same");
        assertFalse(ourDate.isSameDay(notSameDay), "not same day");
        assertFalse(ourDate.isSameDay(notSameMonth), "not same month");
    }
}
