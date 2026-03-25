package com.JPA.demo.service;

import com.JPA.demo.entity.Usuario;
import com.JPA.demo.repository.UsuarioRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario actualizarUsuario(Long id, Usuario nuevosDatos) {
        Usuario existente = usuarioRepository.findById(id).orElse(null);

        if (existente == null) {
            return null;
        }

        existente.setNombre(nuevosDatos.getNombre());
        existente.setCorreo(nuevosDatos.getCorreo());
        existente.setPassword(nuevosDatos.getPassword());

        return usuarioRepository.save(existente);
    }

    public Usuario buscarPorCorreo(String correo) {
        return usuarioRepository.buscarPorCorreo(correo).orElse(null);
    }
}
