package co.com.demo.product;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class ProductApplication {

	private static final String SECRET_KEY = "e24b28b1ee775b6e693d3f80b1f56c8e4f4a8a42f8db1c2f7c2bef5578c6a5d4";

	public static void main(String[] args) {
		String jwtToken = generateJwtToken();
		System.out.println("JWT Token: " + jwtToken);
		SpringApplication.run(ProductApplication.class, args);
	}


	public static String generateJwtToken() {
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		long expMillis = nowMillis + 3600000;
		Date exp = new Date(expMillis);

		return Jwts.builder()
				.setSubject("usuario")
				.setIssuedAt(now)
				.setExpiration(exp)
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes())
				.compact();
	}

}
