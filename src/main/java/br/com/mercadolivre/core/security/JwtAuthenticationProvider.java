package br.com.mercadolivre.core.security;

import br.com.mercadolivre.core.security.exception.LoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            String email = authentication.getName();
            String senha = authentication.getCredentials().toString();

            UserDetails userDetails = userDetailsService.loadUserByUsername(email);

            if (!passwordEncoder.matches(senha, userDetails.getPassword())) {
                throw new LoginException("Usuário ou senha inválidos.");
            }

            return new UsernamePasswordAuthenticationToken(userDetails, senha, userDetails.getAuthorities());
        } catch (UsernameNotFoundException e) {
            throw new LoginException("Usuário ou senha inválidos.");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}
