package book.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import book.inventory.entity.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls, Integer > {
	
	public UserDtls findByEmail(String em);
	

}
