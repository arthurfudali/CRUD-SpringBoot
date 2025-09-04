package com.dev.projetoCrud.business;

import com.dev.projetoCrud.infraestructure.entity.Usuario;
import com.dev.projetoCrud.infraestructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void salvarUsuario(Usuario usuario) {
        usuarioRepository.saveAndFlush(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Erro ao buscar usuario por email")
        );
    }

    public void deletarUsuarioPorEmail(String email) {
        usuarioRepository.deleteByEmail(email);
    }

    public void atualizarUsuarioPorId(Long id, Usuario usuario){
        Usuario usuarioEntity = usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuario nao encontrado")
        );
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();
        usuarioRepository.saveAndFlush(usuarioAtualizado);
    }

}
