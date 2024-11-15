package com.pim.streaming;

public class Conteudo {
    private int conteudoId;
    private String titulo;
    private String descricao;
    private String link;
    private int criadorId;
    private String nomeCriador;

    // Construtor para inicializar todos os campos
    public Conteudo(int conteudoId, String titulo, String descricao, String link, int criadorId, String nomeCriador) {
        this.conteudoId = conteudoId;
        this.titulo = titulo;
        this.descricao = descricao;
        this.link = link;
        this.criadorId = criadorId;
        this.nomeCriador = nomeCriador;
    }

    // Getters e setters
    public int getConteudoId() {
        return conteudoId;
    }

    public void setConteudoId(int conteudoId) {
        this.conteudoId = conteudoId;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getCriadorId() {
        return criadorId;
    }

    public void setCriadorId(int criadorId) {
        this.criadorId = criadorId;
    }

    public String getNomeCriador() {
        return nomeCriador;
    }

    public void setNomeCriador(String nomeCriador) {
        this.nomeCriador = nomeCriador;
    }
}

