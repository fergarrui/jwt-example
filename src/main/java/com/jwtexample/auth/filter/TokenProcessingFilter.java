package com.jwtexample.auth.filter;

import com.jwtexample.auth.token.JWTToken;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component
public class TokenProcessingFilter extends GenericFilterBean {

    private final AuthenticationManager authenticationManager;
    private static final Logger logger = LoggerFactory.getLogger(TokenProcessingFilter.class);

    public TokenProcessingFilter(AuthenticationManager authenticationManager) {
        super();
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain fc) throws IOException, ServletException {

        String token = request.getParameter("token");
        if (token == null) {
            throw new IllegalArgumentException("Token parameter cannot be null");
        }

        JWTToken jwtToken = new JWTToken(token);
        SecurityContextHolder.getContext().setAuthentication(authenticationManager.authenticate(jwtToken));
        fc.doFilter(request, response);

    }
}