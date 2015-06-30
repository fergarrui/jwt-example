package com.jwtexample.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.InvalidSignatureException;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.stereotype.Component;
import com.jwtexample.auth.token.JWTToken;

@Component("jwtAuthenticationProvider")
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UsernameAuthBean usernameAuthBean;

    @Override
    public Authentication authenticate(Authentication t)
            throws AuthenticationException {
        JWTToken jwtToken = (JWTToken) t;
        try {
        	String username = jwtToken.getClaims().getUsername();
        	String secret = usernameAuthBean.getUserSecret().get(username);
        	if (secret != null) {
        		MacSigner signer = new MacSigner(secret);
        		JwtHelper.decodeAndVerify(jwtToken.getToken(), signer);
        		jwtToken.setAuthenticated(Boolean.TRUE);
        		String role = usernameAuthBean.getUserRoles().get(username);
        		jwtToken.addRole(role);
        		
        	}
            
        } catch (InvalidSignatureException e) {
            return null;
        }
        return jwtToken;
    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(JWTToken.class);
    }

}
