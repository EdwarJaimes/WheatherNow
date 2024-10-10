package com.example.theweathernow.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.theweathernow.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherRepository {
    private static Retrofit retrofit = null;
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "e12265d9aed442947e4fd4207bbb7377"; // Coloca aquí tu API Key de OpenWeather
    private WeatherApi weatherApi;
    private MutableLiveData<WeatherResponse> weatherData = new MutableLiveData<>();
    public WeatherRepository() {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        weatherApi = retrofit.create(WeatherApi.class);
    }
    public MutableLiveData<WeatherResponse> getWeatherData() {
        return weatherData;
    }
    public void fetchWeather(String city) {
        Call<WeatherResponse> call = weatherApi.getWeather(city, API_KEY, "metric");

        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.isSuccessful()) {
                    weatherData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                weatherData.setValue(null); // Manejar errores según sea necesario
            }
        });
    }
}
