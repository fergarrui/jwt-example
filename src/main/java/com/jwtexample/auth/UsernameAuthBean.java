package com.jwtexample.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * Authentication hardcoded values.
 * 
 * @author fernandog
 *
 */
@Component
public class UsernameAuthBean {

	private Map<String,String> userSecret = new HashMap<>();
	private Map<String,String> userRoles = new HashMap<>();
	
	public UsernameAuthBean () {
		
		userSecret.put("user1", "secret");
		userSecret.put("user2", "secret");
		userSecret.put("user3", "secret");
		
		userRoles.put("user1", "ROLE_TUBE");
		userRoles.put("user2", "ROLE_WEATHER");
		userRoles.put("user3", "ROLE_ADMIN");
	}

	public Map<String, String> getUserSecret() {
		return userSecret;
	}

	public Map<String, String> getUserRoles() {
		return userRoles;
	}
}