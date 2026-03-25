package com.JPA.demo.controller;

import com.JPA.demo.entity.Usuario;
import com.JPA.demo.service.UsuarioService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> obtenerTodos() {
        return usuarioService.listar();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable("id") Long id) {
        return usuarioService.obtenerPorId(id);
    }

    @PostMapping
    public Usuario guardarUsuario(@RequestBody Usuario nuevoUsuario) {
        return usuarioService.guardar(nuevoUsuario);
    }

    @PutMapping("/{id}")
    public Usuario editarUsuario(@PathVariable Long id, @RequestBody Usuario datosActualizados) {
        return usuarioService.actualizar(id, datosActualizados);
    }

    @DeleteMapping("/{id}")
    public String borrarUsuario(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return "Usuario eliminado";
    }
}
