package com.example.projetointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.projetointegrador.domain.Filme;

import java.util.List;

public class AtvAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List lista;

    private TextView txtNomeP;
    private TextView txtNomeE;
    private TextView txtDuracao;
    private TextView txtDiretor;

    public AtvAdapter(Context context, List lista){
        this.lista = lista;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Object obj = lista.get(position);
        view = mInflater.inflate(R.layout.activity_atv_adapter, null);

        txtNomeP = (TextView) view.findViewById(R.id.txtNomeP);
        txtNomeE = (TextView) view.findViewById(R.id.txtNomeE);
        txtDuracao = (TextView) view.findViewById(R.id.txtDuracao);
        txtDiretor = (TextView) view.findViewById(R.id.txtDiretor);

        if(obj instanceof Filme){
            txtNomeP.setText(((Filme) obj).getNomeP());
            txtNomeE.setText(((Filme) obj).getNomeE());
            txtDuracao.setText(((Filme) obj).getDuracao());
            txtDiretor.setText(((Filme) obj).getDiretor());
        }
        return view;
    }
}