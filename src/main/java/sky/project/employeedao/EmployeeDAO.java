package sky.project.employeedao;

import sky.project.models.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    Employee findEmployeeById(Long id);

    void createNewEmployee(Employee employee);

    List<Employee> getEmployees();

    void refactorEmployee(Employee employee);

    void fireEmployee(Employee employee);
}
