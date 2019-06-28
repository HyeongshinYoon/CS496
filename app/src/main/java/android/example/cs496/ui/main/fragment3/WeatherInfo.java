package android.example.cs496.ui.main.fragment3;

public class WeatherInfo {
    String city;
    String temperature_Value;
    String temperature_Min;
    String temperature_Max;
    String temperature_Unit;
    String humidity_Value;
    String humidity_Unit;
    String wind_Name;
    String clouds_Name;
    String precipitation_Mode;
    String weather_Value;
    String last_update;

    public WeatherInfo(String city, String temperature_Value, String temperature_Min, String temperature_Max,
                       String temperature_Unit, String humidity_Value, String humidity_Unit, String wind_Name,
                       String clouds_Name, String precipitation_Mode, String weather_Value, String last_update)
    {
        this.city = city;
        this.temperature_Value = temperature_Value;
        this.temperature_Max = temperature_Max;
        this.temperature_Min = temperature_Min;
        this.temperature_Unit = temperature_Unit;
        this.humidity_Value = humidity_Value;
        this.humidity_Unit = humidity_Unit;
        this.wind_Name = wind_Name;
        this.clouds_Name = clouds_Name;
        this.precipitation_Mode = precipitation_Mode;
        this.weather_Value = weather_Value;
        this.last_update = last_update;
    }

    public String getCity() {return city;}

    public String getTemperature_Value() {return temperature_Value;}

    public String getTemperature_Min() {return temperature_Min;}

    public String getTemperature_Max() {return temperature_Max;}

    public String getTemperature_Unit() {return temperature_Unit;}

    public String getHumidity_Value() {return humidity_Value;}

    public String getHumidity_Unit() {return humidity_Unit;}

    public String getWind_Name() {return wind_Name;}

    public String getClouds_Name() {return clouds_Name;}

    public String getPrecipitation_Mode() {return precipitation_Mode;}

    public String getWeather_Value() {return weather_Value;}

    public String getLast_update() {return last_update;}
}
