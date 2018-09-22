package com.t3h.weather.weatherforecast;


import android.os.AsyncTask;

import com.t3h.weather.weatherforecast.data.model.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherParseJson extends AsyncTask<String,Void,Weather> {
    private OnWeatherPasreJson listener;

    public void setListener(OnWeatherPasreJson listener) {
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Weather weather) {
        super.onPostExecute(weather);
        if(listener!=null){
            listener.onSucess(weather);
        }
        else {
            listener.onFailt(weather);
        }
    }

    @Override
    protected Weather doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer resJson = new StringBuffer();
            String leng = reader.readLine();
            while (leng!=null){
                resJson.append(leng+"\n");
                leng=reader.readLine();
            }
            //pase json to java object;
            String dataJosn = resJson.toString();
            JSONObject weatherObj= new JSONObject(dataJosn);
            JSONArray arrWeatherData = weatherObj.getJSONArray("weather");
            JSONObject weatherFirst= arrWeatherData.getJSONObject(0);
            String description = weatherFirst.getString("description");

            String icon = weatherFirst.getString("icon");


            JSONObject mainObj = weatherObj.getJSONObject("main");
            String temp = mainObj.getString("temp");
            String pressure = mainObj.getString("pressure");
            String humidity = mainObj.getString("humidity");

            JSONObject wind = weatherObj.getJSONObject("wind");
            String windSpeed = wind.getString("");

            JSONObject clouds = weatherObj.getJSONObject("clouds");
            int cloudNumber = clouds.getInt("");

            JSONObject sysObj = weatherObj.getJSONObject("sys");
            long sunrise = sysObj.getLong("sunrise");
            long sunset = sysObj.getLong("sunset");

            String address = weatherObj.getString("name");

            Weather weatherItem = new Weather();
            weatherItem.setNhietDo(temp);
            weatherItem.setIcon(icon);
            weatherItem.setDiaDiem(address);
            weatherItem.setDoAm(humidity);
            //weatherItem.setTocDoGio(cloudNumber);
            connection.disconnect();
            return weatherItem;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
