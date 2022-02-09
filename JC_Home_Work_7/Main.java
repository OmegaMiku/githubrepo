import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(RequestHandler.getCityID());
        System.out.println(RequestHandler.getForecastForDay());
        System.out.println(RequestHandler.getDate());
    }
}
