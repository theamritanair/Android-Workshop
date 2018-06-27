package com.example.amrita.weather;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    TextView cityView, tempView,iconView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String cityName = "Delhi";
        cityView = findViewById(R.id.city);
        iconView = findViewById(R.id.icon);
        tempView = findViewById(R.id.temp);

        Typeface weatherface = Typeface.createFromAsset(getAssets(),"weather.ttf");
        iconView.setTypeface(weatherface);
        execute(new String[]{cityName});

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
            case 20:
                if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    GPSTracker gps = new GPSTracker(this);

                    if(gps.canGetLocation()){

                        String lat = gps.getLatitude();
                        String lon = gps.getLongitude();
                        execute(new String[]{lat, lon});
                    }
                    else{

                        gps.showSettingsAlert();
                    }



                }




        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_weather,menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void run(){
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this,
                   new String[] {Manifest.permission.ACCESS_COARSE_LOCATION}, 20);
        }
        else{
            GPSTracker gps = new GPSTracker(this);

            if(gps.canGetLocation()){

                String lat = gps.getLatitude();
                String lon = gps.getLongitude();
                execute(new String[]{lat, lon});
            }
        }

    }

    public void search(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater= getLayoutInflater();

        View dialogView = inflater.inflate(R.layout.layout_search,null);
        builder.setView(dialogView);
        final EditText citySearch = dialogView.findViewById(R.id.citySearch);

        builder.setTitle("CityName");
        builder.setMessage("Please enter the city name");

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String city = citySearch.getText().toString();
                execute(new String[] {city});
            }
        });

        AlertDialog alert = builder.create();
        alert.show();


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.gps){
            run();
        }
        if(id == R.id.search){
            search();
        }


        return super.onOptionsItemSelected(item);
    }

    public void execute(String[] args){

        JSONObject weather = null;
        WeatherTask task = new WeatherTask();
        try{
            if(args.length==1)
                weather = task.execute(args[0]).get();
            else
                weather = task.execute(args).get();

        }catch(InterruptedException iex){
            iex.printStackTrace();
        }catch(ExecutionException eo){
            eo.printStackTrace();
        }
        try {
            int id = weather.getJSONArray("weather").getJSONObject(0).getInt("id");
            String cityName = weather.getString("name");
            Double temp = weather.getJSONObject("main").getDouble("temp");

            cityView.setText(cityName);
            tempView.setText(temp.toString());
            String ic = Utils.setWeatherIcon(this,id);
            iconView.setText(ic);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
