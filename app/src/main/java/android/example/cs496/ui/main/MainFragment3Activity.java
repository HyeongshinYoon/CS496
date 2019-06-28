package android.example.cs496.ui.main;

import android.content.ContentValues;
import android.content.Intent;
import android.example.cs496.R;
import android.example.cs496.ui.main.fragment3.ForeCastManager;
import android.example.cs496.ui.main.fragment3.WeatherInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainFragment3Activity extends AppCompatActivity {

    public static final int THREAD_HANDLER_SUCCESS_INFO = 1;

    TextView tv_WeatherInfo;
    ForeCastManager mForeCast;
    MainFragment3Activity mThis;

    String lon = "37.5";
    String lat = "55.5";

    ArrayList<ContentValues> mWeatherData;
    ArrayList<WeatherInfo> mWeatherInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weatherinfo);
        Intent intent = getIntent();
        Initialize();
    }

    public void Initialize()
    {
        tv_WeatherInfo = (TextView)findViewById(R.id.tv_WeatherInfo);
        mWeatherInformation = new ArrayList<>();
        mThis = this;
        mForeCast = new ForeCastManager(lon, lat, mThis);
        mForeCast.run();
    }

    public String PrintValue() {
        String mData = "";
        for (int i = 0; i < 1; i++) {
            mData = mData
                    + " /City: " +mWeatherInformation.get(i).getCity() + "\r\n"
                    + " /Temperature: " +mWeatherInformation.get(i).getTemperature_Value() +' '+ mWeatherInformation.get(i).getTemperature_Unit() + "\r\n"
                    + mWeatherInformation.get(i).getTemperature_Min()+' '+ mWeatherInformation.get(i).getTemperature_Unit()+"\r\n"
                    + mWeatherInformation.get(i).getTemperature_Max()+' '+ mWeatherInformation.get(i).getTemperature_Unit()+"\r\n"
                    + " /Humidity: " + mWeatherInformation.get(i).getHumidity_Value() + mWeatherInformation.get(i).getHumidity_Unit() + "\r\n"
                    + " /Wind: " + mWeatherInformation.get(i).getWind_Name() + "\r\n"
                    + " /Clouds: " + mWeatherInformation.get(i).getClouds_Name() + "\r\n"
                    + " /Precipitation: " + mWeatherInformation.get(i).getPrecipitation_Mode() + "\r\n"
                    + "/Weather Value: " + mWeatherInformation.get(i).getWeather_Value() + "\r\n"
                    + "/Last Update: " + mWeatherInformation.get(i).getLast_update() + "\r\n";

            mData = mData + "\r\n" + "----------------------------------------------" + "\r\n";
        }
        return mData;
    }


    public void DataToInformation()
    {
        for(int i = 0; i < mWeatherData.size(); i++)
        {
            mWeatherInformation.add(new WeatherInfo(
                    String.valueOf(mWeatherData.get(i).get("city")),  String.valueOf(mWeatherData.get(i).get("temperature_Value")), String.valueOf(mWeatherData.get(i).get("temperature_Min")),
                    String.valueOf(mWeatherData.get(i).get("temperature_Max")),  String.valueOf(mWeatherData.get(i).get("temperature_Unit")),  String.valueOf(mWeatherData.get(i).get("humidity_Value")),
                    String.valueOf(mWeatherData.get(i).get("humidity_Unit")),  String.valueOf(mWeatherData.get(i).get("wind_Name")),  String.valueOf(mWeatherData.get(i).get("clouds_Name")),
                    String.valueOf(mWeatherData.get(i).get("precipitation_Mode")),  String.valueOf(mWeatherData.get(i).get("weather_Value")),  String.valueOf(mWeatherData.get(i).get("last_update"))
            ));
        }
    }

    public Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case THREAD_HANDLER_SUCCESS_INFO :
                    mWeatherData = mForeCast.getmWeather();
                    if(mWeatherData.size() ==0) {
                        tv_WeatherInfo.setText("No Data :(");
                    }
                    DataToInformation(); // 자료 클래스로 저장,
                    String data = "";

                    data = PrintValue();
//                    data = data + PrintValue();

                    tv_WeatherInfo.setText(data);
                    break;
                default:
                    break;
            }
        }
    };
}


