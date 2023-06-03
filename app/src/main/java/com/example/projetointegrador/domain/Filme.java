package com.example.projetointegrador.domain;

import java.io.Serializable;

public class Filme implements Serializable {

    private Long id;
    private String nomeP;

    private String nomeE;

    private String categoria;

    private String duracao;

    private String diretor;

    private String sinopse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getNomeP() {
        return nomeP;
    }

    public void setNomeP(String nomeP) {
        this.nomeP = nomeP;
    }

    public String getNomeE() {
        return nomeE;
    }

    public void setNomeE(String nomeE) {
        this.nomeE = nomeE;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
}
