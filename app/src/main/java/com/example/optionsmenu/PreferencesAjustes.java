package com.example.optionsmenu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreference;

public class PreferencesAjustes extends PreferenceFragmentCompat {


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences_ajustes,rootKey);

        SwitchPreference modoOscuro = findPreference("modoOscuro");
        ListPreference idiomas  = findPreference("idiomas");

        assert modoOscuro != null;
        modoOscuro.setOnPreferenceChangeListener((preference, newValue) -> {

            if (Boolean.parseBoolean(newValue.toString())){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);}

            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);}

            return true;
        });

        assert idiomas != null;
        idiomas.setOnPreferenceChangeListener((preference, newValue) -> {

            if(newValue.toString().equals("español"))
                Toast.makeText(requireActivity(), "Español", Toast.LENGTH_SHORT).show();
            else  Toast.makeText(requireActivity(), "English", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getActivity(),Ajustes.class);
            startActivity(intent);
            requireActivity().finish();

            return true;
        });
    }
}

