import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbHandler {

    private final static String PATH_DB = "jdbc:sqlite:C:\\Admin\\Java\\HomeWork7\\src\\main\\resources\\homeWork8.db";

    private Connection connection;

    public DbHandler() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(PATH_DB);
    }

    public void addRequestHandler(RequestHandler requestHandler) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("" + "INSERT INTO AccuWeather('CityName', 'Temperature', 'Date') " +
                "VALUES(?, ?, ?)");
        statement.setObject(1, requestHandler.getCityName);
        statement.setObject(1, requestHandler.getTemperature);
        statement.setObject(1, requestHandler.getDate);
        statement.execute();
    }

    public List<RequestHandler> getAllRequestHandler() throws SQLException {
        List<RequestHandler> requests = new ArrayList<>();
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM AccuWeather");

        while (resultSet.next()) {
            String cityName = resultSet.getString("CityName");
            double temperature = resultSet.getDouble("Temperature");
            double date = resultSet.getDouble("Date");

            RequestHandler requestHandler = new RequestHandler(cityName, temperature, date);
            requests.add(requestHandler);

        }

        return requests;

    }

}
