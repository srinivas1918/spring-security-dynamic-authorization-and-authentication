package com.exp.dynamicroles.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
/**
 * 
 * @author Srinivas Nalla
 *
 */
public class LoggedUser implements UserDetails{
	
	private User user;
	private List<String> roles;
	
	public LoggedUser(User user, List<String> roles){
		this.user=user;
		this.roles=roles;
	}
	
	

	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities=new ArrayList<SimpleGrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

	public String getPassword() {
		return user.getPassword();
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
