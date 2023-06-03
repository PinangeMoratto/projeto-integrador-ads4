package com.example.projetointegrador.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.projetointegrador.domain.Filme;

import java.util.ArrayList;
import java.util.List;

public class FilmeDao {

    private final String TABELA = "filme";
    private final String[] CAMPOS = {"id, nomeP, nomeE, categoria, duracao, diretor, sinopse"};
    private Conexao conexao;
    private SQLiteDatabase banco;

    public FilmeDao(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    private ContentValues preencherValores(Filme filme){
        ContentValues values = new ContentValues();

        values.put("nomeP", filme.getNomeP());
        values.put("nomeE", filme.getNomeE());
        values.put("categoria", filme.getCategoria());
        values.put("duracao", filme.getDuracao());
        values.put("diretor", filme.getDiretor());
        values.put("sinopse", filme.getSinopse());

        return values;
    }

    public long inserir (Filme filme){
        ContentValues values = preencherValores(filme);
        return banco.insert(TABELA, null, values);
    }

    public long alterar (Filme filme){
        ContentValues values = preencherValores(filme);
        return banco.update(TABELA, values, "id = ?", new String[] {filme.getId().toString()});
    }

    public long excluir (Filme filme){
        return banco.delete(TABELA, "id = ?", new String[]{filme.getId().toString()});
    }


    public List<Filme> listar(){
        Cursor f = banco.query(TABELA, CAMPOS,
                null, null, null, null, null);

        List<Filme> lista = new ArrayList<>();
        while (f.moveToNext()){
            Filme filme = new Filme();
            filme.setId(f.getLong(0));
            filme.setNomeP(f.getString(1));
            filme.setNomeE(f.getString(2));
            filme.setCategoria(f.getString(3));
            filme.setDuracao(f.getString(4));
            filme.setDiretor(f.getString(5));
            filme.setSinopse(f.getString(6));

            lista.add(filme);
        }
        return lista;
    }
}
