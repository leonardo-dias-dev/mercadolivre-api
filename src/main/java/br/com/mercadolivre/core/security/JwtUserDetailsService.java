package br.com.mercadolivre.core.security;

import br.com.mercadolivre.domain.exception.UsuarioNaoEncontradoException;
import br.com.mercadolivre.domain.model.Usuario;
import br.com.mercadolivre.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            Usuario usuario = usuarioService.buscarPorEmail(email);

            return new User(email, usuario.getSenha(), new ArrayList<>());
        } catch (UsuarioNaoEncontradoException e) {
            throw new UsernameNotFoundException("Usuário ou senha inválidos");
        }
    }

}
