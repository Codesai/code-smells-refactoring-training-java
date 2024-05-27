package birthdaygreetings.infrastructure.repositories;

import birthdaygreetings.core.Employee;
import birthdaygreetings.core.EmployeesRepository;

import java.util.List;

public class FileEmployeesRepository implements EmployeesRepository {
    private final String path;

    public FileEmployeesRepository(String path) {
        this.path = path;
    }

    @Override
    public List<Employee> getAll() {
        EmployeesFile employeesFile = EmployeesFile.loadFrom(path);
        return employeesFile.extractEmployees();
    }

}
