package com.example.projetointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetointegrador.dao.FilmeDao;
import com.example.projetointegrador.domain.Filme;

public class AtvCadastrarFilmes extends AppCompatActivity implements View.OnClickListener{

    Button btnGravar;
    Button btnVoltar;
    Button btnExcluir;

    EditText edtId;
    EditText edtNomeP;
    EditText edtNomeE;
    EditText edtCategoria;
    EditText edtDuracao;
    EditText edtDiretor;
    EditText edtSinopse;

    String acao;
    Filme f;
    FilmeDao dao;

    private void criarComponentes(){
        btnGravar = findViewById(R.id.btnGravar);
        btnExcluir = findViewById(R.id.btnExcluir);
        if(acao.equals("Inserir"))
            btnExcluir.setVisibility(View.INVISIBLE);
        else
            btnExcluir.setVisibility(View.VISIBLE);
        btnVoltar = findViewById(R.id.btnVoltar);
        btnGravar.setOnClickListener(this);
        btnExcluir.setOnClickListener(this);
        btnVoltar.setOnClickListener(this);

        edtId = findViewById(R.id.edtId);
        edtNomeP = findViewById(R.id.edtNomeP);
        edtNomeE = findViewById(R.id.edtNomeE);
        edtCategoria = findViewById(R.id.edtCategoria);
        edtDuracao = findViewById(R.id.edtDuracao);
        edtDiretor = findViewById(R.id.edtDiretor);
        edtSinopse = findViewById(R.id.edtSinopse);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atv_cadastrar_filmes);

        acao = getIntent().getExtras().getString("acao");
        dao = new FilmeDao(this);
        criarComponentes();

        if(getIntent().getExtras().getSerializable("obj") != null){
            f = (Filme) getIntent().getExtras().getSerializable("obj");
            edtId.setText(f.getId().toString());
            edtNomeP.setText(f.getNomeP());
        }
    }

    @Override
    public void onClick(View v) {
        if(v == btnVoltar){
            finish();
        } else if (v == btnExcluir) {
            long id = dao.excluir(f);
            Toast.makeText(this, "Filme " +
                    f.getNomeP() + " foi excluído com sucesso", Toast.LENGTH_LONG).show();
        } else if (v == btnGravar) {
            f.setNomeP(edtNomeP.getText().toString());
            f.setNomeE(edtNomeE.getText().toString());
            f.setCategoria(edtCategoria.getText().toString());
            f.setDuracao(edtDuracao.getText().toString());
            f.setDiretor(edtDiretor.getText().toString());
            f.setSinopse(edtSinopse.getText().toString());

            if(acao.equals("Inserir")){
                long id = dao.inserir(f);
                Toast.makeText(this, "Filme " +
                        f.getNomeP() + " foi inserido com sucesso", Toast.LENGTH_LONG).show();
            }
            else {
                long id = dao.alterar(f);
                Toast.makeText(this, "Filme " +
                        f.getNomeP() + " foi alterado com sucesso", Toast.LENGTH_LONG).show();
            }
            finish();
        }
    }
}