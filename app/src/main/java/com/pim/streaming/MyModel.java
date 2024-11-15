package com.pim.streaming;

public class MyModel {
    String titulo = "";
    String descricao = "";
    String nomeCriador = "";

    public MyModel(String titulo, String descricao, String nomeCriador) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.nomeCriador = nomeCriador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeCriador() {
        return nomeCriador;
    }

    public void setNomeCriador(String nomeCriador) {
        this.nomeCriador = nomeCriador;
    }
}
