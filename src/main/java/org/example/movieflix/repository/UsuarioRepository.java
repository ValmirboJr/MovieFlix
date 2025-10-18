package org.example.movieflix.repository;

import org.example.movieflix.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<UserDetails>findUsuarioByEmail(String email);
    Optional<Usuario> findByEmail(String email);
}
