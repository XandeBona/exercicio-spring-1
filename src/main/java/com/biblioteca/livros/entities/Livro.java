package com.biblioteca.livros.entities;

public class Livro {
    private Integer id;
    private String nome;
    private Integer qtd_paginas;

    public Livro(Integer id, String nome, Integer qtd_paginas) {
        this.id = id;
        this.nome = nome;
        this.qtd_paginas = qtd_paginas;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQtd_paginas() {
        return qtd_paginas;
    }
}
