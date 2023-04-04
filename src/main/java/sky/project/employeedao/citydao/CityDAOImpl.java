package sky.project.employeedao.citydao;

import sky.project.connection.ApplicationConnection;
import sky.project.models.City;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDAOImpl implements CityDAO {

    private final ApplicationConnection applicationConnection = new ApplicationConnection();

    @Override
    public City findCityById(Integer id) throws SQLException {
        try (PreparedStatement statement =
                     applicationConnection.getPreparedStatement
                             ("SELECT * FROM city WHERE city_id=(?)")) {
            statement.setInt(1, id);
            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();
            if (resultSet != null && resultSet.next()) {
                return new City(resultSet.getString("city_name"));
            }
            throw new SQLException("Результат запроса пустой!");
        }
    }
}


