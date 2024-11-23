package com.pim.streaming;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;

public class MyModel {
    @SerializedName("titulo")
    @Expose
    String titulo = "";
    @SerializedName("descricao")
    @Expose
    String descricao = "";
    @SerializedName("nomeCriador")
    @Expose
    String nomeCriador = "";

    @NonNull
    @Override
    public String toString() {
        return "MyModel{" +
                "titulo='" + titulo + '\'' +
                ", descricao=" + descricao + '\'' +
                ", nomeCriador=" + nomeCriador +
                '}';
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
