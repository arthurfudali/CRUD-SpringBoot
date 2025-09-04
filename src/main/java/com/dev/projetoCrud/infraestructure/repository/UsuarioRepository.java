package com.dev.projetoCrud.infraestructure.repository;

import com.dev.projetoCrud.infraestructure.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional <Usuario> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);

}
