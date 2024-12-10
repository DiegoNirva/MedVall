package com.medvoll.apirest.Controller;

import com.medvoll.apirest.DTO.DatosUsuario;
import com.medvoll.apirest.Model.Usuario;
import com.medvoll.apirest.inf.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosUsuario datosUsuario){
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosUsuario.login(), datosUsuario.clave());
        var usuarioAtenticado =  authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAtenticado.getPrincipal());
        return ResponseEntity.ok(JWTtoken);
    }
}
