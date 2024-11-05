package test.birthdaygreetings.core;

import birthdaygreetings.core.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static test.birthdaygreetings.helpers.OurDateFactory.ourDate;

public class EmployeeTest {

    @Test
    public void testBirthday() throws Exception {
        Employee employee = new Employee("foo", "bar", ourDate("1990/01/31"), "a@b.c");

        assertFalse(employee.isBirthday(ourDate("2008/01/30")), "no birthday");

        assertTrue(employee.isBirthday(ourDate("2008/01/31")), "birthday");
    }
}
