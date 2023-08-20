package com.example.acessobd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cadastro(View view) {
        Intent m = new Intent(this, Cadastro.class);
        startActivity(m);
    }

    public void listagem(View view) {
        Intent m = new Intent(this, Listagem.class);
        startActivity(m);

    }
}