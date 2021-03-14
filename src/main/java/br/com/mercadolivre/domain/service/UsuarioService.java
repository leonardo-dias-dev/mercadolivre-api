package br.com.mercadolivre.domain.service;

import br.com.mercadolivre.domain.exception.UsuarioNaoEncontradoException;
import br.com.mercadolivre.domain.model.Usuario;
import br.com.mercadolivre.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(String.format("Não exite um usuário com o e-mail %s", email)));
    }

}
