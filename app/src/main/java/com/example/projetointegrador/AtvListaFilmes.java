package com.example.projetointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.projetointegrador.dao.FilmeDao;
import com.example.projetointegrador.domain.Filme;

import java.util.ArrayList;
import java.util.List;

public class AtvListaFilmes extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    Button btnCadFilmes;
    ListView lstFilmes;
    List<Filme> listaFilme = new ArrayList<>();
    ListAdapter listAdapter;
    FilmeDao dao;
    int indice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atv_lista_filmes);

        btnCadFilmes = findViewById(R.id.btnCadFilmes);
        btnCadFilmes.setOnClickListener(this);


        lstFilmes = findViewById(R.id.lstFilmes);
        lstFilmes.setOnItemClickListener(this);

        dao = new FilmeDao(this);
        atualizarLista();
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizarLista();
    }

    private void atualizarLista(){
        listaFilme = dao.listar();
        AtvAdapter listAdapter = new AtvAdapter(this, listaFilme);
        lstFilmes.setAdapter(listAdapter);
    }

    @Override
    public void onClick(View v) {
        if(v == btnCadFilmes){
            Filme f = new Filme();
            f.setId(0L);
            abrirCadastro("Inserir", f);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        // Aqui terá que fazer o código para fazer a chamada de outra tela com o vídeo
        indice = position;
        Filme f = (Filme) lstFilmes.getAdapter().getItem(position);
        abrirCadastro("Alterar", f);
    }

    private void abrirCadastro(String acao, Filme obj){
        Intent telaCad = new Intent(this, AtvCadastrarFilmes.class);
        Bundle extras = new Bundle();
        extras.putString("acao", acao);
        extras.putSerializable("obj", obj);
        telaCad.putExtras(extras);
        startActivity(telaCad);
    }
}