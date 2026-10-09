package edu.klu.foodwaste.security;
import io.jsonwebtoken.*;import io.jsonwebtoken.security.Keys;import javax.crypto.SecretKey;import org.springframework.beans.factory.annotation.Value;import org.springframework.stereotype.Service;import java.nio.charset.StandardCharsets;import java.util.Date;
@Service public class JwtService{
 private final SecretKey key;private final long expiry;
 public JwtService(@Value("${app.jwt.secret}")String s,@Value("${app.jwt.expiration-ms}")long e){key=Keys.hmacShaKeyFor(s.getBytes(StandardCharsets.UTF_8));expiry=e;}
 public String generate(String email,String role){return Jwts.builder().subject(email).claim("role",role).issuedAt(new Date()).expiration(new Date(System.currentTimeMillis()+expiry)).signWith(key).compact();}
 public String subject(String token){return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject();}
}
