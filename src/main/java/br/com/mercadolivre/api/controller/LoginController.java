package br.com.mercadolivre.api.controller;

import br.com.mercadolivre.api.dto.request.LoginRequest;
import br.com.mercadolivre.api.dto.response.TokenResponse;
import br.com.mercadolivre.core.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class LoginController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @PostMapping("/login")
    public TokenResponse entrar(@RequestBody LoginRequest loginRequest) {
        Authentication authenticate = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        UserDetails userDetails = (UserDetails) authenticate.getPrincipal();

        final String token = jwtTokenUtil.generateToken(userDetails);

        return new TokenResponse(token);
    }

}
