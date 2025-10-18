package org.example.movieflix.controller;

import lombok.RequiredArgsConstructor;
import org.example.movieflix.config.TokenComponente;
import org.example.movieflix.entity.Usuario;
import org.example.movieflix.exception.UsernameOrPasswordInvalidException;
import org.example.movieflix.mapper.UsuarioMapper;
import org.example.movieflix.request.LoginRequest;
import org.example.movieflix.request.UsuarioRequest;
import org.example.movieflix.response.LoginResponse;
import org.example.movieflix.response.UsuarioResponse;
import org.example.movieflix.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;

    private final AuthenticationManager authenticationManager;

    private final TokenComponente tokenService;

    @PostMapping("/save")
    public ResponseEntity<UsuarioResponse> registrar(@RequestBody UsuarioRequest usuarioRequest){
        Usuario salvarUsuario = usuarioService.registrar(UsuarioMapper.toUsuario(usuarioRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toUsuarioResponse(salvarUsuario));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        try{
        UsernamePasswordAuthenticationToken usuarioesenha = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.senha());
        Authentication authenticado = authenticationManager.authenticate(usuarioesenha);
        Usuario usuario = (Usuario) authenticado.getPrincipal();
        String token = tokenService.gerartoken(usuario);
        return ResponseEntity.ok(new LoginResponse(token));
        }catch (BadCredentialsException e){
            throw new UsernameOrPasswordInvalidException("Usuario ou senha invalido.");
        }
    }
}