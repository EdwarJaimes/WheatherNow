package com.example.theweathernow.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.theweathernow.model.WeatherResponse;
import com.example.theweathernow.repository.WeatherRepository;

public class WeatherViewModel extends ViewModel {
    private MutableLiveData<WeatherResponse> weatherData;
    private WeatherRepository repository;

    public WeatherViewModel() {
        repository = new WeatherRepository();
        weatherData = repository.getWeatherData();
    }
    public LiveData<WeatherResponse> getWeatherData() {
        return weatherData;
    }

    public void fetchWeather(String city) {
        repository.fetchWeather(city);
    }
}
