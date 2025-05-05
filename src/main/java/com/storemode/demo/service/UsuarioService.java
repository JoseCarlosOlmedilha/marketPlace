package com.storemode.demo.service;

import org.springframework.stereotype.Service;

import com.storemode.demo.entity.UsuarioEntity;
import com.storemode.demo.exception.UsuarioNullException;
import com.storemode.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository; 
    } 


    public UsuarioEntity cadastrarUsuario(UsuarioEntity usuario){;
        if (usuario.getCpf() == null) {
            throw new UsuarioNullException();  
        }

      return usuarioRepository.save(usuario);
    }

    
    public UsuarioEntity buscarUsuario(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }



}
