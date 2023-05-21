package sky.project;

import sky.project.employeedao.EmployeeDAO;
import sky.project.employeedao.EmployeeDAOImpl;
import sky.project.employeedao.citydao.CityDAO;
import sky.project.employeedao.citydao.CityDAOImpl;
import sky.project.exceptions.NotFoundInDataBaseException;
import sky.project.models.City;
import sky.project.models.Employee;

import java.sql.SQLException;

public class Application {

    private static CityDAO cityDAO = new CityDAOImpl();

    private static EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    private static void printEmployees() {
        for (Employee employee : employeeDAO.getEmployees())
            System.out.println(employee);
    }

    private static void printCities() {
        for (City city : cityDAO.cities())
            System.out.println(city);
    }

    private static Object findEmployee(Long id) {
        try {
            return employeeDAO.findEmployeeById(id);
        } catch (NotFoundInDataBaseException e) {
            return e.getMessage();
        }
    }

    private static void deleteEmployeeFromDB(Long id) {
        try {
            employeeDAO.fireEmployee(employeeDAO.findEmployeeById(id));
        } catch (NotFoundInDataBaseException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void refactorEmployeeById(Employee employee) {
        try {
            employeeDAO.findEmployeeById(employee.getId());
            employeeDAO.refactorEmployee(employee);
        } catch (NotFoundInDataBaseException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws SQLException {

        printCities();

    }
}