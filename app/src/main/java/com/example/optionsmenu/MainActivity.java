package com.example.optionsmenu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.PreferenceManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Locale;

public class MainActivity extends BaseActivity {

    BottomNavigationView bottomNavigationView;

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onCreate(Bundle savedInstanceState) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean modoOscuro = preferences.getBoolean("modoOscuro",false);
        if (modoOscuro) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES); else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.proveedores:
                    Intent intentProveedores = new Intent(this, Proveedores.class);
                    startActivity(intentProveedores);
                    break;

                case R.id.clientes:
                    Intent intentClientes = new Intent(this, Clientes.class);
                    startActivity(intentClientes);
                    break;

                case R.id.stock:
                    Intent intentStock = new Intent(this, Stock.class);
                    startActivity(intentStock);
                    break;

                case R.id.proyecciones:
                    Intent intentProyecciones = new Intent(this, Proyecciones.class);
                    intentProyecciones.putExtra("Mes",1 );
                    startActivity(intentProyecciones);
                    break;
            }
            return true;
        });
    }

    @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.action_bar_menu, menu);
            return super.onCreateOptionsMenu(menu);
        }

    @SuppressLint("NonConstantResourceId")
    @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            switch(item.getItemId()){

                case R.id.ajustes:
                    Intent intentAjustes = new Intent(this, Ajustes.class);
                    startActivity(intentAjustes);
                    finish();
                    return true;
                case R.id.acercaDe:
                    Intent intentAcercaDe = new Intent(this, AcercaDe.class);
                    startActivity(intentAcercaDe);
                    return true;
                case R.id.contacto:
                    Intent intentContacto = new Intent(this, Contacto.class);
                    startActivity(intentContacto);
                    return true;

                default:
                    return super.onOptionsItemSelected(item);
            }
        }
}