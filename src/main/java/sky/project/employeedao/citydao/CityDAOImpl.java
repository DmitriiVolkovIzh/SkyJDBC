package sky.project.employeedao.citydao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sky.project.connection.HibernateSessionFactoryUtil;
import sky.project.exceptions.ListIsEmptyException;
import sky.project.exceptions.NotFoundInDataBaseException;
import sky.project.models.City;

import java.util.List;

public class CityDAOImpl implements CityDAO {

    @Override
    public City findCityById(Integer id) {
        City city = HibernateSessionFactoryUtil
                .getSessionFactory().openSession().get(City.class, id);
        if (city == null) throw new NotFoundInDataBaseException("Город не сущестует в базе данных");
        else return city;

    }

    @Override
    public List<City> cities() {
        List<City> cities = (List<City>) HibernateSessionFactoryUtil
                .getSessionFactory().openSession()
                .createQuery("From City").list();
        if (cities.isEmpty()) throw new ListIsEmptyException("Список городов пуст");
        else return cities;
    }

    @Override
    public void addNewCityToDataBase(City city) {
        try (Session session = HibernateSessionFactoryUtil
                .getSessionFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            session.save(city);
            transaction.commit();
        }
    }

    @Override
    public void refactorCity(City city) {
        try (Session session = HibernateSessionFactoryUtil
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }
    }

    @Override
    public void deleteCity(City city) {
        try (Session session = HibernateSessionFactoryUtil
                .getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }
    }
}
