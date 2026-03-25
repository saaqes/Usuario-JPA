package com.JPA.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JPA.demo.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByCorreo(String correo);
}