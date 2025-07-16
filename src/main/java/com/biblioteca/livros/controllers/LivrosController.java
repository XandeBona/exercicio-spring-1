package com.biblioteca.livros.controllers;

import com.biblioteca.livros.entities.Livro;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

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

    @PostMapping
    public Livro adicionarLivro(@RequestBody Livro livro) {
        livro.setId(new Random().nextInt());
        lista.add(livro);
        return livro;
    }

    @PutMapping("/{idLivro}")
    public Livro alterarLivro(@PathVariable Integer idLivro, @RequestBody Livro livro) {
        for (Livro livroAlterar : lista) {
            if (livroAlterar.getId().equals(idLivro)) {
                livroAlterar.setNome(livro.getNome());
                livroAlterar.setQtdPaginas(livro.getQtdPaginas());
                return livroAlterar;
            }
        }
        return null;
    }

    @DeleteMapping("/{idLivro}")
    public Livro deletarLivro(@PathVariable Integer idLivro) {
        for (Livro livroRemover : lista) {
            if (livroRemover.getId().equals(idLivro)) {
                lista.remove(livroRemover);
                return livroRemover;
            }
        }
        return null;
    }
}
