package com.t3h.weather.weatherforecast;

import com.t3h.weather.weatherforecast.data.model.Weather;

public interface OnWeatherPasreJson {
    void onSucess(Weather weather);
    void onFailt(Weather weather);

}
