package com.example.acessobd;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PessoaDAO {

        @Query("SELECT * FROM pessoa")
        List<Pessoa> listar();


        @Insert
        void insert(Pessoa... pessoas);

        @Delete
        void remover(Pessoa pessoa);
}
