package com.biblioteca.livros.entities;

public class Funcionario {
    private Integer id;
    private String nome;
    private String cpf;

    public Funcionario(Integer id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
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

}
