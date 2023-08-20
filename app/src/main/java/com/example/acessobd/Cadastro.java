package com.example.acessobd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void salvar(View view) {
        EditText txtNome = findViewById(R.id.txtNome);
        EditText txtTelefone = findViewById(R.id.txtTelefone);

        Pessoa p =new Pessoa();
        p.nome = txtNome.getText().toString();
        p.telefone = txtTelefone.getText().toString();

        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "contatos").build();
                    PessoaDAO dao = db.pessoaDAO();

                    dao.insert(p);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Cadastro.this);
                            builder.setMessage("Salvo com sucesso");
                            builder.create().show();
                        }
                    });
                }
            }).start();


        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void voltar(View view) {
        finish();
    }
}