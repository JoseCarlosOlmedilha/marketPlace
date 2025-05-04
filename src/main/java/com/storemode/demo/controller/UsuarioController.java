package com.storemode.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.storemode.demo.entity.UsuarioEntity;
import com.storemode.demo.service.UsuarioService;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    public final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioEntity> cadastrar(@RequestBody UsuarioEntity usuario){
       UsuarioEntity salvo =  usuarioService.cadastrarUsuario(usuario);

       return ResponseEntity.ok(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity> bsucarId(@PathVariable Long id){
        UsuarioEntity salvo = usuarioService.buscarUsuario(id);

        return ResponseEntity.ok(salvo);
    }
    

}
