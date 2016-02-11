package co.madran.beeride.security;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import co.madran.beeride.model.dao.UserRepository;

public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserDetails result = repo.findByUsername(username
				.toLowerCase(Locale.ENGLISH));
		if (result == null) {
			throw new UsernameNotFoundException("not found");
		}
		return result;
	}

}
