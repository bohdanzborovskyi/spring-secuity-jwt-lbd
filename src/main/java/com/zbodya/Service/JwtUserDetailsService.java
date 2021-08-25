package com.zbodya.Service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		if ("user".equals(username)) {
//			return User.withUsername("user").password("$2a$12$ADRL3qWhSyK9pjsjaWYEu.9rW76N6apmGmAOtI5W6bs5QUgmG0vBG").roles("USER").build();
			return User.withUsername("user").password("$2a$12$ADRL3qWhSyK9pjsjaWYEu.9rW76N6apmGmAOtI5W6bs5QUgmG0vBG").authorities("USER_EDIT").build();
		} else if("admin".equals(username)) 
		{
//			return User.withUsername("admin").password("$2a$12$AAHuSXpMIy57xkSrP8Vfs.292.oUycMlMw4xeOHjSalROZ7UWYjPO").roles("ADMIN").build();
			return User.withUsername("admin").password("$2a$12$AAHuSXpMIy57xkSrP8Vfs.292.oUycMlMw4xeOHjSalROZ7UWYjPO").authorities("ADMIN").build();
		}else if("spectator".equals(username)) 
		{
			return User.withUsername("spectator").password("$2a$12$6eEWHbxlXC9euolZMJJ0MunOe6pcYmZFWl/OqW1xw8p/Q/YZEceou").authorities("USER_READ").build();
		}
		else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
