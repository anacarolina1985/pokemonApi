package br.com.ana.alves.araujo.pokemon.util;

import java.security.Key;
import java.util.Calendar;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import br.com.ana.alves.araujo.pokemon.model.Login;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class LoginJWTUtils {

	// Sample method to construct a JWT
	public static String createJWT(final Login login) {

		// The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		Calendar now = Calendar.getInstance();

		// We will sign our JWT with our ApiKey secret
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("12345678");
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		// Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder().setId(login.getUsername()).setIssuedAt(now.getTime())
				.setSubject(login.getPassword()).setIssuer("12345678").signWith(signatureAlgorithm, signingKey);

		// if it has been specified, let's add the expiration
		Calendar exp = Calendar.getInstance();
		exp.setTime(now.getTime());
		exp.add(Calendar.HOUR_OF_DAY, 3);
		builder.setExpiration(exp.getTime());

		// Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();

	}

	public static Login parseJWT(String jwt) {

		// This line will throw an exception if it is not a signed JWS (as
		// expected)
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary("12345678OD"))
				.parseClaimsJws(jwt).getBody();
		Login login = new Login();
		login.setUsername(claims.getId());
		login.setPassword(claims.getSubject());
		return login;
	}

}
