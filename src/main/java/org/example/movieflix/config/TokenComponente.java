package org.example.movieflix.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.example.movieflix.entity.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenComponente {

    @Value("${movieflix.security.secret}")
    private String secret;

    public String gerartoken(Usuario usuario){
        Algorithm algo = Algorithm.HMAC256(secret);

        return JWT.create()
                .withSubject(usuario.getEmail())
                .withClaim("usuarioId", usuario.getId())
                .withClaim("nome", usuario.getNome())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .withIssuer("API MovieFlix")
                .sign(algo);
    }

    public Optional<JWTUserData> verificarToken(String token){
    try{
        Algorithm algo = Algorithm.HMAC256(secret);
        DecodedJWT jwt =JWT.require(algo)
                .build()
                .verify(token);

        return Optional.of(JWTUserData
                .builder()
                .id(jwt.getClaim("usuarioid").asLong())
                .nome(jwt.getClaim("nome").asString())
                .email(jwt.getSubject())
                .build());
    }catch (JWTVerificationException ex){
        return Optional.empty();
    }

           }
}
