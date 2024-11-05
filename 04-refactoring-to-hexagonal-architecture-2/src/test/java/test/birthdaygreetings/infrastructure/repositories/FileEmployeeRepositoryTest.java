package test.birthdaygreetings.infrastructure.repositories;

import birthdaygreetings.core.CannotReadEmployeesException;
import birthdaygreetings.core.EmployeesRepository;
import birthdaygreetings.infrastructure.repositories.FileEmployeesRepository;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileEmployeeRepositoryTest {

    @Test
    public void fails_when_the_file_does_not_exist() {
        EmployeesRepository employeesRepository = new FileEmployeesRepository("non-existing.file");

        final CannotReadEmployeesException exception = assertThrows(CannotReadEmployeesException.class,
                employeesRepository::getAll);

        assertThat(exception.getMessage(), containsString("cannot loadFrom file"));
        assertThat(exception.getMessage(), containsString("non-existing.file"));
    }

    @Test
    public void fails_when_file_contains_wrongly_formatted_birthdate() {
        EmployeesRepository employeesRepository = new FileEmployeesRepository(
                "src/test/resources/contains-employee-with-wrongly-formatted-birthdate.csv"
        );

        final CannotReadEmployeesException exception = assertThrows(CannotReadEmployeesException.class,
                employeesRepository::getAll);

        assertThat(exception.getMessage(), containsString("Badly formatted employee birth date in"));
    }
}