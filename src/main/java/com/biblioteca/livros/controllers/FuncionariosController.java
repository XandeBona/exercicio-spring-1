package com.biblioteca.livros.controllers;

import com.biblioteca.livros.entities.Funcionario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/funcionarios")
public class FuncionariosController {
    private List<Funcionario> lista;

    public FuncionariosController() {
        Funcionario funcionario1 = new Funcionario(1, "Alexandre", "19011252102");
        Funcionario funcionario2 = new Funcionario(1, "Roberval", "08011902939");
        Funcionario funcionario3 = new Funcionario(1, "Gabriel", "09019258123");

        ArrayList<Funcionario> lista = new ArrayList<>();
        lista.add(funcionario1);
        lista.add(funcionario2);
        lista.add(funcionario3);
        this.lista = lista;

    }

    @GetMapping
    public List<Funcionario> listar() {
        return lista;
    }

    @GetMapping("/{nomeFuncionario}")
    public Funcionario buscarFuncionario(@PathVariable String nomeFuncionario) {
        for (Funcionario funcionario : lista) {
            if (Objects.equals(funcionario.getNome(), nomeFuncionario)) {
                return funcionario;

            }
        }
    return null;
    }
}
