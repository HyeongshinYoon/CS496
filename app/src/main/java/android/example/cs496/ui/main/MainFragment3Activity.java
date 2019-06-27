package android.example.cs496.ui.main;

import android.content.ContentValues;
import android.content.Intent;
import android.example.cs496.R;
import android.example.cs496.ui.main.fragment3.ForeCastManager;
import android.example.cs496.ui.main.fragment3.WeatherInfo;
import android.example.cs496.ui.main.fragment3.WeatherToHanguel;
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
        for (int i = 0; i < mWeatherInformation.size(); i++) {
            mData = mData + mWeatherInformation.get(i).getWeather_Day() + "\r\n"
                    + mWeatherInformation.get(i).getWeather_Name() + "\r\n"
                    + mWeatherInformation.get(i).getClouds_Sort()
                    + " /Cloud amount: " + mWeatherInformation.get(i).getClouds_Value()
                    + mWeatherInformation.get(i).getClouds_Per() + "\r\n"
                    + mWeatherInformation.get(i).getWind_Name()
                    + " /WindSpeed: " + mWeatherInformation.get(i).getWind_Speed() + " mps" + "\r\n"
                    + "Max: " + mWeatherInformation.get(i).getTemp_Max() + "℃"
                    + " /Min: " + mWeatherInformation.get(i).getTemp_Min() + "℃" + "\r\n"
                    + "Humidity: " + mWeatherInformation.get(i).getHumidity() + "%";

            mData = mData + "\r\n" + "----------------------------------------------" + "\r\n";
        }
        return mData;
    }

    public void DataChangedToHangeul()
    {
        for(int i = 0 ; i <mWeatherInformation.size(); i ++)
        {
            WeatherToHanguel mHanguel = new WeatherToHanguel(mWeatherInformation.get(i));
            mWeatherInformation.set(i,mHanguel.getHangeulWeather());
        }
    }

    public void DataToInformation()
    {
        for(int i = 0; i < mWeatherData.size(); i++)
        {
            mWeatherInformation.add(new WeatherInfo(
                    String.valueOf(mWeatherData.get(i).get("weather_Name")),  String.valueOf(mWeatherData.get(i).get("weather_Number")), String.valueOf(mWeatherData.get(i).get("weather_Much")),
                    String.valueOf(mWeatherData.get(i).get("weather_Type")),  String.valueOf(mWeatherData.get(i).get("wind_Direction")),  String.valueOf(mWeatherData.get(i).get("wind_SortNumber")),
                    String.valueOf(mWeatherData.get(i).get("wind_SortCode")),  String.valueOf(mWeatherData.get(i).get("wind_Speed")),  String.valueOf(mWeatherData.get(i).get("wind_Name")),
                    String.valueOf(mWeatherData.get(i).get("temp_Min")),  String.valueOf(mWeatherData.get(i).get("temp_Max")),  String.valueOf(mWeatherData.get(i).get("humidity")),
                    String.valueOf(mWeatherData.get(i).get("Clouds_Value")),  String.valueOf(mWeatherData.get(i).get("Clouds_Sort")), String.valueOf(mWeatherData.get(i).get("Clouds_Per")),String.valueOf(mWeatherData.get(i).get("day"))
            ));
        }
    }

    public Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case THREAD_HANDLER_SUCCESS_INFO :
                    mForeCast.getmWeather();
                    mWeatherData = mForeCast.getmWeather();
                    if(mWeatherData.size() ==0)
                        tv_WeatherInfo.setText("데이터가 없습니다");

                    DataToInformation(); // 자료 클래스로 저장,
                    String data = "";

                    data = PrintValue();
                    DataChangedToHangeul();
                    data = data + PrintValue();

                    tv_WeatherInfo.setText(data);
                    break;
                default:
                    break;
            }
        }
    };

}


