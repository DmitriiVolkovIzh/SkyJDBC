package sky.project.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ApplicationConnection {

    private Connection getConnection() throws SQLException {
        String URL = "jdbc:postgresql://localhost:8080/skypro";
        String USERNAME = "postgres";
        String PASSWORD = "(B1maga10)";

        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }

    public PreparedStatement getPreparedStatement(String sql) throws SQLException {

        return getConnection().prepareStatement(sql);
    }
}
