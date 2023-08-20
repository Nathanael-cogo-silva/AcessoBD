package com.example.acessobd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class Listagem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);
    }

    public void carregar(View view) {
        LinearLayout lnlPessoas = findViewById(R.id.lnlPessoas);
        lnlPessoas.removeAllViews();

        new Thread(new Runnable() {
            @Override
            public void run() {
                AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "contatos").build();
                PessoaDAO dao = db.pessoaDAO();

                List<Pessoa> pessoas =dao.listar();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (Pessoa p: pessoas){
                            TextView t = new TextView(Listagem.this);
                            t.setText(p.nome);

                            lnlPessoas.addView(t);
                        }
                    }
                });
            }
        }).start();

    }

    public void voltar(View view) {
        finish();

    }
}