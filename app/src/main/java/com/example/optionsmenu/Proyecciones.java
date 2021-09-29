package com.example.optionsmenu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Proyecciones extends BaseActivity {

    TextView tvMes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyecciones);

        tvMes = findViewById(R.id.tvMes);

        Intent intent = getIntent();
        int mes = intent.getIntExtra("Mes",0);

        tvMes.setText(getString(R.string.mes,mes));


    }
}
