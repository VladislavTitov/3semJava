import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import pojo.AllWeather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CityWeather {

    public static AllWeather getWeather(String cityName){
        return parseJsonString(getJsonString(createUrl(cityName)));
    }

    private static URL createUrl(String cityName){
        String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q="+ cityName +"&appid=f504d1ab2430389753698888dc84a889";
        try {
            return new URL(apiUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String getJsonString(URL url){
        StringBuilder builder = new StringBuilder();
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            if (connection.getResponseCode() == 200) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                connection.getInputStream()
                        )
                );
                String readedLine = null;
                while ((readedLine = reader.readLine()) != null){
                    builder.append(readedLine);
                }
                connection.disconnect();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    private static AllWeather parseJsonString(String jsonString){
        Gson gson = new GsonBuilder().create();
        try {
            AllWeather allWeather = gson.fromJson(jsonString, AllWeather.class);
            return allWeather;
        }catch (JsonSyntaxException e){
            String error = gson.fromJson(jsonString, String.class);
            AllWeather allWeather = new AllWeather();
            allWeather.setError(error);
            return allWeather;
        }

    }

}
