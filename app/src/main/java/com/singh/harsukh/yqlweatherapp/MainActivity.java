package com.singh.harsukh.yqlweatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.singh.harsukh.yqlweatherapp.service.WeatherService;

public class MainActivity extends AppCompatActivity {
    private final String URL = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20location%3D20770&format=json&diagnostics=true&callback=";
    private Button enter_button;
    private EditText zip_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enter_button = (Button) findViewById(R.id.enter_button);
        zip_text = (EditText) findViewById(R.id.zip_text);
    }

    public void sendIntent(View v)
    {
        if(v.getId() == R.id.enter_button)
        {
            String text = zip_text.getText().toString();
            if(text.equals("") || text == null || isNumeric(text) == false )
            {
                Toast.makeText(this, "Please enter a valid zip code", Toast.LENGTH_LONG).show();
                return;
            }
            Intent intent = WeatherService.getIntent(getApplicationContext());
            intent.putExtra("zip", text);
            Log.e("MainActivity", text);
            startService(intent);
        }
    }

    private static  boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
            if(d > 99999) return false;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
        return true;
    }
}
