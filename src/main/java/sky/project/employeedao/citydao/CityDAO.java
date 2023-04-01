package sky.project.employeedao.citydao;

import sky.project.models.City;

import java.sql.SQLException;

public interface CityDAO {

    City findCityById(Integer id) throws SQLException;
}
