package com.biblioteca.livros.entities;

public class Livro {
    private Integer id;
    private String nome;
    private Integer qtdPaginas;

    public Livro(Integer id, String nome, Integer qtdPaginas) {
        this.id = id;
        this.nome = nome;
        this.qtdPaginas = qtdPaginas;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQtdPaginas() {
        return qtdPaginas;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQtdPaginas(Integer qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }
}
