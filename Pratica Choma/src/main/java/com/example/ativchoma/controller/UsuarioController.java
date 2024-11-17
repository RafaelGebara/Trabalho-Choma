package com.example.ativchoma.controller;
import com.example.ativchoma.model.Usuario;
import com.example.ativchoma.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("register")
    public ResponseEntity<Usuario> registerUsuario(@RequestBody Usuario usuario){
        return usuarioService.registerUsuario(usuario);
    }
}