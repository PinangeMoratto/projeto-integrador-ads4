package com.example.projetointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.bumptech.glide.Glide;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imgGif;
    Button btnAcessar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgGif = findViewById(R.id.imgGif);
        Glide.with(this).load(R.drawable.libra).into(imgGif);
        btnAcessar = findViewById(R.id.btnAcessar);
        btnAcessar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == btnAcessar) {
            Intent intent = new Intent(this, AtvListaFilmes.class);
            startActivity(intent);
        }
    }
}