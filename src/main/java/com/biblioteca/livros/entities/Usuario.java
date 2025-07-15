package com.biblioteca.livros.entities;

public class Usuario {
    private Integer id;
    private String nome;
    private String cpf;
    private Integer qtd_Livros;

    public Usuario(Integer id, String nome, String cpf, Integer qtd_Livros) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.qtd_Livros = qtd_Livros;
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

    public Integer getQtd_Livros() {
        return qtd_Livros;
    }
}
