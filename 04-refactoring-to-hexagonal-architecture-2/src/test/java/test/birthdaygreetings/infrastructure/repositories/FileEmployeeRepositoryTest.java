package test.birthdaygreetings.infrastructure.repositories;

import birthdaygreetings.core.CannotReadEmployeesException;
import birthdaygreetings.core.EmployeesRepository;
import birthdaygreetings.core.OurDate;
import birthdaygreetings.infrastructure.repositories.FileEmployeesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static test.birthdaygreetings.helpers.OurDateFactory.ourDateFromString;

public class FileEmployeeRepositoryTest {

    private OurDate ANY_DATE;

    @BeforeEach
    public void setUp() throws Exception {
        ANY_DATE = ourDateFromString("2016/01/01");
    }

    @Test
    public void fails_when_the_file_does_not_exist() {
        EmployeesRepository employeesRepository = new FileEmployeesRepository("non-existing.file");

        final CannotReadEmployeesException exception = assertThrows(CannotReadEmployeesException.class,
                employeesRepository::getAll);

        assertThat(exception.getMessage(), containsString("cannot loadFrom file"));
        assertThat(exception.getMessage(), containsString("non-existing.file"));
    }

    @Test
    public void fails_when_the_file_does_not_have_the_necessary_fields() {
        EmployeesRepository employeesRepository = new FileEmployeesRepository("src/test/resources/wrong_data__wrong-date-format.csv");

        final CannotReadEmployeesException exception = assertThrows(CannotReadEmployeesException.class,
                employeesRepository::getAll);

        assertThat(exception.getMessage(), containsString("Badly formatted employee birth date in"));
    }
}