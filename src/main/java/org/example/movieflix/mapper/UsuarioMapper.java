package org.example.movieflix.mapper;

import lombok.experimental.UtilityClass;
import org.example.movieflix.entity.Usuario;
import org.example.movieflix.request.UsuarioRequest;
import org.example.movieflix.response.UsuarioResponse;

@UtilityClass
public class UsuarioMapper {

    public static Usuario toUsuario(UsuarioRequest usuarioRequest) {
            return Usuario.builder()
                    .nome(usuarioRequest.nome())
                    .email(usuarioRequest.email())
                    .senha(usuarioRequest.senha())
                    .build();

    }

    public static UsuarioResponse toUsuarioResponse(Usuario usuario) {
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .build();
    }
}
