package com.biblioteca.livros.entities;

public class Usuario {
    private Integer id;
    private String nome;
    private String cpf;
    private Integer qtdLivros;

    public Usuario(Integer id, String nome, String cpf, Integer qtd_Livros) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.qtdLivros = qtd_Livros;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Integer getQtdLivros() {
        return qtdLivros;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setQtdLivros(Integer qtdLivros) {
        this.qtdLivros = qtdLivros;
    }
}
