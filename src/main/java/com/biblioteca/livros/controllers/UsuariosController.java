package com.biblioteca.livros.controllers;

import com.biblioteca.livros.entities.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/clientes")
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
            if(Objects.equals(usuario.getId(), idUsuario)) {
                return usuario;
            }
        }
        return null;
    }
}
