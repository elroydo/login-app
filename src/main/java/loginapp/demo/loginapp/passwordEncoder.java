package loginapp.demo.loginapp;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class passwordEncoder {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "randompassword";
		String encodedPassword = encoder.encode(rawPassword);
		
		System.out.println(encodedPassword);
	}
}