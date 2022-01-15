package loginapp.demo.loginapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class customUserDetailsService implements UserDetailsService {
	
	@Autowired
	private userrepo repo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		user user = repo.findByEmail(email);
		
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new customUserDetails(user);
	}

}
