package com.example.optionsmenu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import java.util.Locale;

public class Ajustes extends BaseActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        getSupportFragmentManager().beginTransaction().
                replace(R.id.preferences,new PreferencesAjustes()).commit();

        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {

                // Handle the back button event
                startActivity(new Intent(getBaseContext(), MainActivity.class));
                setEnabled(false);
                finish();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);
    }
}
