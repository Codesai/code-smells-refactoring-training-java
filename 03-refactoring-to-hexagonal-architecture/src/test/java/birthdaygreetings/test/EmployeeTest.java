package birthdaygreetings.test;

import static org.junit.jupiter.api.Assertions.*;

import birthdaygreetings.Employee;
import birthdaygreetings.OurDate;

import org.junit.jupiter.api.Test;

public class EmployeeTest {

    @Test
    public void testBirthday() throws Exception {
        Employee employee = new Employee("foo", "bar", "1990/01/31", "a@b.c");
        assertFalse(employee.isBirthday(new OurDate("2008/01/30")),
                "not his birthday");
        assertTrue(employee.isBirthday(new OurDate("2008/01/31")),
                "his birthday");
    }
}
