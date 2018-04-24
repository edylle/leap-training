package com.vanhack.leap.javatraining.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginDetailService implements UserDetailsService {

	// load some user from database
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (!"edylle".equals(username)) {
			throw new UsernameNotFoundException("user not found");
		}

		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		auths.add(new SimpleGrantedAuthority("ROLE_".concat("ADMIN")));

		return new User(username, "$2a$10$qHpgPCEbPnJmQ5LELIR3GefrLWKP1MMYlWlKQ8qIh29quOPTZ9fMC", auths);
	}

}
