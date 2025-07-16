package com.biblioteca.livros.controllers;

import com.biblioteca.livros.entities.Funcionario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

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

    @PostMapping
    public Funcionario adicionarFuncionario(@RequestBody Funcionario funcionario) {
        funcionario.setId(new Random().nextInt());
        lista.add(funcionario);
        return funcionario;
    }

    @PutMapping("/{idFuncionario}")
    public Funcionario alterarFuncionario(@PathVariable Integer idFuncionario, @RequestBody Funcionario funcionario) {
        for (Funcionario funcionarioAlterar : lista) {
            if (funcionarioAlterar.getId().equals(idFuncionario)) {
                funcionarioAlterar.setNome(funcionario.getNome());
                funcionarioAlterar.setCpf(funcionario.getCpf());
                return funcionarioAlterar;
            }
        }
        return null;
    }

    @DeleteMapping("/{idFuncionario}")
    public Funcionario deletarFuncionario(@PathVariable Integer idFuncionario) {
        for (Funcionario funcionarioRemover : lista) {
            if (funcionarioRemover.getId().equals(idFuncionario)) {
                lista.remove(funcionarioRemover);
                return funcionarioRemover;
            }
        }
        return null;
    }
}
