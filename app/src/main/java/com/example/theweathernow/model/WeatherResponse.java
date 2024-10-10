package com.example.theweathernow.model;
//creamos el modelo de datos que obtenderemos de la API

public class WeatherResponse {
    private Main main;
    private Weather[] weather;

    public String getName() {
        return name;
    }

    private String name;

    public Main getMain() {
        return main;
    }

    public Weather[] getWeather() {
        return weather;
    }

}
