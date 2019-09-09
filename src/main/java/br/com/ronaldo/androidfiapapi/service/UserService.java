package br.com.ronaldo.androidfiapapi.service;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.ronaldo.androidfiapapi.security.UserSS;

public class UserService {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}