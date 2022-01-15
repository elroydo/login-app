package loginapp.demo.loginapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class userrepotest {
	@Autowired
	private userrepo repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		user user = new user();
		user.setEmail("rin@makise.com");
		user.setPassword("pepper5050");
		user.setFirstName("Rin");
		user.setLastName("Makise");
		
		user savedUser = repo.save(user);
		
		user existUser = entityManager.find(user.class, savedUser.getId());
		
		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
	}
	
	@Test
	public void testFindUserByEmail() {
		String email = "test@email.com";
		
		user user = repo.findByEmail(email);
		assertThat(user).isNotNull();
	}
}
