package com.jwtexample.auth.token;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jwtexample.auth.jwtpayload.JwtPayload;

public class JWTToken implements Authentication {

    private final Jwt jwt;
    private JwtPayload claims;
    private final String token;
    private List<GrantedAuthority> authorities;
    private Boolean authenticated;

    public JWTToken(String token) throws IOException {
        authorities = new ArrayList<>();
        this.token = token;
        this.jwt = JwtHelper.decode(token);
        ObjectMapper mapper = new ObjectMapper();
        this.claims = mapper.readValue(jwt.getClaims(), JwtPayload.class);
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Object getCredentials() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getDetails() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getPrincipal() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean auth) throws IllegalArgumentException {
        this.authenticated = auth;

    }

    public String getToken() {
        return token;
    }

    public Jwt getJwt() {
        return jwt;
    }

    public JwtPayload getClaims() {
        return claims;
    }

    public void addRole(String role) {
        GrantedAuthority r = new SimpleGrantedAuthority(role);
        this.authorities.add(r);
    }

}
