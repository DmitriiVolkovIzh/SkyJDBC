package sky.project.employeedao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sky.project.connection.HibernateSessionFactoryUtil;
import sky.project.exceptions.ListIsEmptyException;
import sky.project.exceptions.NotFoundInDataBaseException;
import sky.project.models.Employee;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public Employee findEmployeeById(Long id) {
        Employee employee = HibernateSessionFactoryUtil
                .getSessionFactory().openSession().get(Employee.class, id);
        if (employee == null) throw new NotFoundInDataBaseException("Работник не был найден");
        else return employee;
    }

    @Override
    public void createNewEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = (List<Employee>) HibernateSessionFactoryUtil
                .getSessionFactory().openSession()
                .createQuery("From Employee").list();
        if (employees.isEmpty()) throw new ListIsEmptyException("Список работников пуст");
        else return employees;
    }

    @Override
    public void refactorEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void fireEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }


}



