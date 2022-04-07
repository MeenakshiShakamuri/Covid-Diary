package uk.ac.tees.MAD.W9560777.coviddiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity_Weather extends AppCompatActivity {

    final String APP_ID = "39d521675a61b6649d9dcaa53e0292c3";
    final String URL_Weather = "https://api.openweathermap.org/data/2.5/weather";

    final long MINIMUM_Time = 5000;
    final float MINIMUM_DISTANCE = 1000;
    final int REQ_CODE = 101;

    RelativeLayout finder_City;
    ImageView back1;
    ImageView icon_weather;
    TextView current_temperature;
    TextView name_of_city;
    TextView condition_Weather;
    String locateP = LocationManager.GPS_PROVIDER;

    LocationListener listener;
    LocationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_weather);


        condition_Weather = findViewById(R.id.condition_Weather);
        back1 = findViewById(R.id.back1);
        current_temperature = findViewById(R.id.current_temperature);
        icon_weather = findViewById(R.id.icon_weather);
        name_of_city = findViewById(R.id.name_of_city);
        finder_City = findViewById(R.id.finder_City);

        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity_Weather.this, Intro_2.class);
                startActivity(i);
            }
        });


        finder_City.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity_Weather.this, MainActivity_Finder_City.class);
                startActivity(i);
            }

        });
    }

/*    @Override
    protected void onResume() {
        super.onResume();
        findWeatherOnCurrentLocation();
    }*/


    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        String city = intent.getStringExtra("city");
        if (city != null)
        {
            weatherOfNewCity(city);
        }
        else
        {
            findWeatherOnCurrentLocation();
        }

    }

    private void weatherOfNewCity(String city) {
        RequestParams params = new RequestParams();
        params.put("q", city);
        params.put("appid", APP_ID);
        networkingCreate(params);
    }

    private void findWeatherOnCurrentLocation() {
        manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        listener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {

                String lat = String.valueOf(location.getLatitude());
                String lon = String.valueOf(location.getLongitude());

                RequestParams requestParams = new RequestParams();
                requestParams.put("lat", lat);
                requestParams.put("lon", lon);
                requestParams.put("appid", APP_ID);

                networkingCreate(requestParams);

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderDisabled(@NonNull String provider) {

            }

            @Override
            public void onProviderEnabled(@NonNull String provider) {

            }
        };


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQ_CODE);
            return;
        }
        manager.requestLocationUpdates(locateP, MINIMUM_Time, MINIMUM_DISTANCE, listener);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode==REQ_CODE)
        {
            if (grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(MainActivity_Weather.this, "Location Successfully Tracked", Toast.LENGTH_SHORT).show();
                findWeatherOnCurrentLocation();
            }
            else
            {
                Toast.makeText(MainActivity_Weather.this, "No Enough Permission", Toast.LENGTH_SHORT).show();

            }
        }
    }

    private void networkingCreate(RequestParams requestParams)
    {
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get(URL_Weather,requestParams,new JsonHttpResponseHandler()
        {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Toast.makeText(MainActivity_Weather.this, "Pulled the Data Successfully", Toast.LENGTH_SHORT).show();

                Data_Weather dataWeather = Data_Weather.fromJson(response);
                ui_Update(dataWeather);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                //super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(MainActivity_Weather.this, "Wrong Credentials! Please Enter Correct City Name...",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void ui_Update(Data_Weather weather){
        current_temperature.setText(weather.getTemperature_current());
        name_of_city.setText(weather.getCity());
        condition_Weather.setText(weather.getType_of_weather());


        int id_Resource = getResources().getIdentifier(weather.getIcon(), "drawable", getPackageName());
        icon_weather.setImageResource(id_Resource);

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (manager!= null)
        {
            manager.removeUpdates(listener);
        }
    }
}