import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException {

        try {
            DbHandler dbHandler = new DbHandler();

            System.out.println(dbHandler.getAllRequestHandler());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println(RequestHandler.getCity());
        System.out.println(RequestHandler.getForecastForDay());
        System.out.println(RequestHandler.getDate());

        

    }
}
