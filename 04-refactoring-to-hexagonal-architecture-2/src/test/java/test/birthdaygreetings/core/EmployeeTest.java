package test.birthdaygreetings.core;

import birthdaygreetings.core.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static test.birthdaygreetings.helpers.OurDateFactory.ourDateFromString;

public class EmployeeTest {

    @Test
    public void testBirthday() throws Exception {
        Employee employee = new Employee("foo", "bar", ourDateFromString("1990/01/31"), "a@b.c");

        assertFalse(employee.isBirthday(ourDateFromString("2008/01/30")), "no birthday");

        assertTrue(employee.isBirthday(ourDateFromString("2008/01/31")), "birthday");
    }
}
