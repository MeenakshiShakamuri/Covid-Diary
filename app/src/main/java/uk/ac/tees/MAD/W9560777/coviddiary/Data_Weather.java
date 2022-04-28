package uk.ac.tees.MAD.W9560777.coviddiary;

import org.json.JSONException;
import org.json.JSONObject;

public class Data_Weather {

    private String temperature_current;
    private String icon;
    private String city;
    private String type_of_weather;
    private int condition;

    public static Data_Weather fromJson(JSONObject object)
    {
        try
        {
           Data_Weather dataWeather = new Data_Weather();
           dataWeather.city = object.getString("name");
           dataWeather.condition = object.getJSONArray("weather").getJSONObject(0).getInt("id");
           dataWeather.type_of_weather = object.getJSONArray("weather").getJSONObject(0).getString("main");
           dataWeather.icon = weatherUpdate(dataWeather.condition);
           double resultTemp = object.getJSONObject("main").getDouble("temp")-273.15;

           int valueRounded = (int) Math.rint(resultTemp);
           dataWeather.temperature_current = Integer.toString(valueRounded);

           return dataWeather;
        }
        catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String weatherUpdate(int con)
    {
        if (con>=0 && con<= 300)
        {
            return "thunderstorm";
        }
        else if (con>=300 && con<= 500)
        {
            return "rain_light";
        }
        else if (con>=500 && con<= 600)
        {
            return "heavy_rain";
        }
        else if (con>=600 && con<= 701)
        {
            return "night_snow";
        }
        else if (con>=702 && con<= 772)
        {
            return "fog";
        }
        else if (con>=773 && con<= 800)
        {
            return "cloud_overcast";
        }
        else if (con == 800)
        {
            return "hot_sunny";
        }
        else if (con>= 801 && con<=804)
        {
            return "weather_cloudy";
        }
        else if (con>= 900 && con<=902)
        {
            return "thunderstorm";
        }
        else if (con == 903)
        {
            return "morning_snow";
        }
        else if (con == 904)
        {
            return "hot_sunny";
        }
        else if (con>= 905 && con<=1000)
        {
            return "night_thunderstorm";
        }
        return "No Weather";
    }

    public String getTemperature_current() {
        return temperature_current + "°C";
    }

    public String getIcon() {
        return icon;
    }

    public String getCity() {
        return city;
    }

    public String getType_of_weather() {
        return type_of_weather;
    }
}
