package sky.project;

import sky.project.employeedao.EmployeeDAO;
import sky.project.employeedao.EmployeeDAOImpl;
import sky.project.employeedao.citydao.CityDAO;
import sky.project.employeedao.citydao.CityDAOImpl;
import sky.project.models.Employee;

import java.sql.SQLException;

public class Application {

    private static CityDAO cityDAO = new CityDAOImpl();

    private static EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    public static void main(String[] args) throws SQLException {

        // System.out.println(cityDAO.findById(2));

        // System.out.println(employeeDAO.findById(2));

        // employeeDAO.hireNewEmployee("Данил","Ханов",87, 3);

        //employeeDAO.refactorEmployee(1,"Алексей","Грачев",46,1);

        //employeeDAO.deleteEmployeeById(2);

        //for (Employee employee:employeeDAO.getEmployees().toArray(new Employee[0]));

    }
}