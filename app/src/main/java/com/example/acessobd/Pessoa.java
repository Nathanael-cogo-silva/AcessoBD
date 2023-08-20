package com.example.acessobd;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pessoa {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "nome")
    public String nome;

    @ColumnInfo(name = "telefone")
    public String telefone;
}
