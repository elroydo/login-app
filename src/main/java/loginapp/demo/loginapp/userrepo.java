package loginapp.demo.loginapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface userrepo extends JpaRepository<user, Long> {
	@Query("SELECT u FROM user u WHERE u.email = ?1")
	user findByEmail(String email);
}
