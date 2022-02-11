package book.inventory.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import book.inventory.repository.UserRepository;
import book.inventory.entity.UserDtls; 

public class CustomUserDtlsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String em) throws UsernameNotFoundException {
		
		try {
			UserDtls u = repo.findByEmail(em);
			if(u==null) {
				throw new UsernameNotFoundException("No User");
			}else {
				return new CustomUserDtls(u);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}
