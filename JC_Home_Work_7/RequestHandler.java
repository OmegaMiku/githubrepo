import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class RequestHandler {

    static OkHttpClient okHttpClient = new OkHttpClient();
    static ObjectMapper objectMapper = new ObjectMapper();

    public static String getCityID() throws IOException {

        HttpUrl detectCityId = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("cities")
                .addPathSegment("search")
                .addQueryParameter("apikey", "DTPo879ItqQbKvLmVR1LjVSFmgGmWukK")
                .addQueryParameter("q", "Moscow")
                .build();

        Request request = new Request.Builder()
                .addHeader("Accept", "application/json")
                .url(detectCityId)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String jsonOfCities = response.body().string();

        String cityId = objectMapper.readTree(jsonOfCities).get(0).at("/Key").asText();

        return cityId;
    }

    public static String getForecastForDay() throws IOException {

        HttpUrl detectForecastForDay = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("1day")
                .addPathSegment("294021")
                .addQueryParameter("apikey", "DTPo879ItqQbKvLmVR1LjVSFmgGmWukK")
                .build();

        Request request = new Request.Builder()
                .addHeader("Accept", "application/json")
                .url(detectForecastForDay)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String jsonOfForecast = response.body().string();

        String forecastForDay = objectMapper.readTree(jsonOfForecast).at("/DailyForecasts").get(0).at("/Temperature/Minimum/Value").asText();

        return forecastForDay;
    }

    public static String getDate() throws IOException {

        HttpUrl detectDate = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("1day")
                .addPathSegment("294021")
                .addQueryParameter("apikey", "DTPo879ItqQbKvLmVR1LjVSFmgGmWukK")
                .build();

        Request request = new Request.Builder()
                .addHeader("Accept", "application/json")
                .url(detectDate)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String jsonOfDate = response.body().string();

        String Date = objectMapper.readTree(jsonOfDate).at("/DailyForecasts").get(0).at("/Date").asText();

        return Date;

    }
}
