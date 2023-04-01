package sky.project.employeedao;

import sky.project.connection.ApplicationConnection;
import sky.project.dao.employeedao.citydao.CityDAO;
import sky.project.dao.employeedao.citydao.CityDAOImpl;
import sky.project.models.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private final ApplicationConnection applicationConnection = new ApplicationConnection();

    private final CityDAO cityDAO = new CityDAOImpl();

    @Override
    public Employee findById(Integer id) throws SQLException {

        try (PreparedStatement statement = applicationConnection.getPreparedStatement
                ("SELECT * FROM employee WHERE id = (?) ")) {
            statement.setInt(1, id);
            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            return new Employee(resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getInt("age"),
                    cityDAO.findCityById(resultSet.getInt("city_id")));

        }
    }

    @Override
    public void hireNewEmployee(String firstName, String lastName,
                                Integer age, Integer cityId) throws SQLException {
        try (PreparedStatement statement = applicationConnection.getPreparedStatement
                ("INSERT INTO employee (first_name,last_name,age,city_id) VALUES (?,?,?,?)")) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.setInt(4, cityId);
            statement.executeUpdate();


        }

    }

    @Override
    public void refactorEmployee(Integer id, String firstName, String lastName,
                                 Integer age, Integer cityId) throws SQLException {
        try (PreparedStatement statement = applicationConnection.getPreparedStatement(
                "UPDATE employee SET first_name = ?, " +
                        "last_name= ?, age=?,city_id=? WHERE id = (?)")) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.setInt(4, cityId);
            statement.setInt(5, id);
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteEmployeeById(Integer id) throws SQLException {
        try (PreparedStatement statement = applicationConnection.getPreparedStatement
                ("DELETE FROM employee WHERE id =(?)")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    @Override
    public List<Employee> getEmployees() throws SQLException {
        try (PreparedStatement statement =
                     applicationConnection.getPreparedStatement(
                             "SELECT * FROM employee")) {
            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();
            List<Employee> employees = new ArrayList<>();
            while (resultSet.next()) {
                employees.add(new Employee(
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("age"),
                        cityDAO.findCityById(resultSet.getInt("city_id"))));
            }
            return employees;

        }
    }
}



