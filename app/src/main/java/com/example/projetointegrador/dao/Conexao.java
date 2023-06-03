package com.example.projetointegrador.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {

    private static final String NAME = "banco.db";

    private static final int VERSION = 1;

    private static final String SQL_CREATE_FILME = "create table filme ( " +
            " id integer primary key autoincrement, " +
            " nomeP  varchar(20), " +
            " nomeE  varchar(20), " +
            " categoria varchar(20), " +
            " duracao varchar(20), " +
            " diretor varchar(20), " +
            " sinopse varchar );";

    public Conexao(@Nullable Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_FILME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
