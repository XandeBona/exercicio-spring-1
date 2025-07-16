package com.biblioteca.livros.controllers;

import com.biblioteca.livros.entities.Funcionario;
import com.biblioteca.livros.entities.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    private List<Usuario> lista;

    public UsuariosController() {
        Usuario usuario1 = new Usuario(1, "Cristiano", "12345678903", 2);
        Usuario usuario2 = new Usuario(2, "Messi", "22335658678", 1);
        Usuario usuario3 = new Usuario(3, "Kaká", "62375478553", 4);

        ArrayList<Usuario> lista = new ArrayList<>();
        lista.add(usuario1);
        lista.add(usuario2);
        lista.add(usuario3);
        this.lista = lista;
    }

    @GetMapping
    public List<Usuario> listar() {
        return lista;
    }

    @GetMapping("/{idUsuario}")
    public Usuario buscarUsuario(@PathVariable Integer idUsuario) {
        for (Usuario usuario : lista) {
            if (Objects.equals(usuario.getId(), idUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    @PostMapping
    public Usuario adicionarUsuario(@RequestBody Usuario usuario) {
        usuario.setId(new Random().nextInt());
        lista.add(usuario);
        return usuario;
    }

    @PutMapping("/{idUsuario}")
    public Usuario alterarUsuario(@PathVariable Integer idUsuario, @RequestBody Usuario usuario) {
        for (Usuario usuarioAlterar : lista) {
            if (usuarioAlterar.getId().equals(idUsuario)) {
                usuarioAlterar.setNome(usuario.getNome());
                usuarioAlterar.setCpf(usuario.getCpf());
                usuarioAlterar.setQtdLivros(usuario.getQtdLivros());
                return usuarioAlterar;
            }
        }
        return null;
    }

    @DeleteMapping("/{idUsuario}")
    public Usuario deletarUsuario(@PathVariable Integer idUsuario) {
        for (Usuario usuarioRemover : lista) {
            if (usuarioRemover.getId().equals(idUsuario)) {
                lista.remove(usuarioRemover);
                return usuarioRemover;
            }
        }
        return null;
    }
}

