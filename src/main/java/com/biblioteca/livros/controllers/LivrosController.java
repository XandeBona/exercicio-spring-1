package com.biblioteca.livros.controllers;

import com.biblioteca.livros.entities.Livro;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/livros")
public class LivrosController {
    private List<Livro> lista;

    public LivrosController() {
        Livro livro1 = new Livro(1, "Livro1", 251);
        Livro livro2 = new Livro(2, "Livro2", 252);
        Livro livro3 = new Livro(3, "Livro3", 253);

        ArrayList<Livro> lista = new ArrayList<>();
        lista.add(livro1);
        lista.add(livro2);
        lista.add(livro3);
        this.lista = lista;

    }

    @GetMapping
    public List<Livro> listar() {
        return lista;
    }

    @GetMapping("/{idLivro}")
    public Livro buscarLivro(@PathVariable Integer idLivro) {
        for (Livro livro : lista) {
            if (Objects.equals(livro.getId(), idLivro)) {
                return livro;
            }
        }
        return null;
    }
    
}
