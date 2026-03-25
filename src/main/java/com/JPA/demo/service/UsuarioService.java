package com.JPA.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.JPA.demo.entity.Usuario;
import com.JPA.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public Usuario guardar(Usuario usuario) {
        return repo.save(usuario);
    }

    public List<Usuario> listar() {
        return repo.findAll();
    }

    public Usuario obtenerPorId(Long id) {
        Optional<Usuario> usuario = repo.findById(id);
        return usuario.orElse(null);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    public Usuario actualizar(Long id, Usuario datos) {
        Usuario usuario = repo.findById(id).orElse(null);

        if (usuario != null) {
            usuario.setNombre(datos.getNombre());
            usuario.setCorreo(datos.getCorreo());
            usuario.setPassword(datos.getPassword());
            return repo.save(usuario);
        }

        return null;
    }
}