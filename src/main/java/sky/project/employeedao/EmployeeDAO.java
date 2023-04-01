package sky.project.employeedao;

import sky.project.models.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    Employee findById(Integer id) throws SQLException;

    void hireNewEmployee(String firstName, String lastName,
                         Integer age, Integer cityId) throws SQLException;

    void refactorEmployee(Integer id, String firstName, String lastName,
                          Integer age, Integer cityId) throws SQLException;

    void deleteEmployeeById(Integer id) throws SQLException;

    List<Employee> getEmployees() throws SQLException;
}
