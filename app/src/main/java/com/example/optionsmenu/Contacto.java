package com.example.optionsmenu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Contacto extends BaseActivity {

    Button enviarCorreo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        enviarCorreo = findViewById(R.id.enviarCorreo);
        enviarCorreo.setOnClickListener(v -> {

            //String[] destinatario = new String[]{"...@gmail.com"};

            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:"));
            //emailIntent.putExtra(Intent.EXTRA_EMAIL,destinatario);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Options Menu");
            startActivity(Intent.createChooser(emailIntent, getString(R.string.enviar_correo)));

        });
    }
}
