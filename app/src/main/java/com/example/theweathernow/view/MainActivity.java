package com.example.theweathernow.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.theweathernow.R;
import com.example.theweathernow.viewModel.WeatherViewModel;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    WeatherViewModel weatherViewModel;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView temperatureTextView, descriptionTextView, cityTextView;
        ImageView weatherIconImageView;

        temperatureTextView = findViewById(R.id.temperatureTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);
        cityTextView = findViewById(R.id.cityTextView);
        weatherIconImageView = findViewById(R.id.imageIcoView);

        temperatureTextView.setText("fetching");
        descriptionTextView.setText("data");
        cityTextView.setText("Cargando...");

        weatherViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);

        weatherViewModel.getWeatherData().observe(this, weatherResponse -> {
            if (weatherResponse != null) {
                String temperature = weatherResponse.getMain().getTemp() + "°C";
                String description = weatherResponse.getWeather()[0].getDescription();

                temperatureTextView.setText(temperature);
                descriptionTextView.setText(description);
                cityTextView.setText(weatherResponse.getName());
                String iconCode = weatherResponse.getWeather()[0].getIcon();

                String iconUrl = "https://openweathermap.org/img/w/" + iconCode + ".png";

                Picasso.get().load(iconUrl).into(weatherIconImageView);
            }
        });

        weatherViewModel.fetchWeather("Bogota");
    }
}