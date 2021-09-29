package com.example.optionsmenu;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import java.util.Locale;

public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String idioma = preferences.getString("idiomas","");

        Locale locale;
        Configuration config;
        DisplayMetrics displayMetrics;
        config = new Configuration();

        switch (idioma) {

            case "ingles":
                locale = new Locale("en");
                Locale.setDefault(locale);
                config.locale = locale;
                break;

            case "español":
                locale = new Locale("es");
                Locale.setDefault(locale);
                config.locale = locale;
                break;
        }

        displayMetrics = getResources().getDisplayMetrics();
        getResources().updateConfiguration(config, displayMetrics);
    }
}
