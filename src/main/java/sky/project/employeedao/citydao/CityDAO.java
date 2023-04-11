package sky.project.employeedao.citydao;

import sky.project.models.City;

import java.sql.SQLException;
import java.util.List;

public interface CityDAO {


    City findCityById(Integer id);

    List<City> cities();

    void addNewCityToDataBase(City city);

    void refactorCity(City city);

    void deleteCity(City city);
}
