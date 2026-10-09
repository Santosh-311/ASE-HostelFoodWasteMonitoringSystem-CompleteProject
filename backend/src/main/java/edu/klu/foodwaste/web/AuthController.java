package edu.klu.foodwaste.web;
import edu.klu.foodwaste.model.AppUser;import edu.klu.foodwaste.repo.UserRepository;import edu.klu.foodwaste.security.JwtService;import jakarta.validation.constraints.*;import org.springframework.http.*;import org.springframework.security.crypto.password.PasswordEncoder;import org.springframework.web.bind.annotation.*;import java.util.Map;
@RestController @RequestMapping("/api/auth") public class AuthController{
 private final UserRepository users;private final PasswordEncoder encoder;private final JwtService jwt;public AuthController(UserRepository u,PasswordEncoder e,JwtService j){users=u;encoder=e;jwt=j;}
 public record Register(@NotBlank String name,@Email @NotBlank String email,@Size(min=8) String password){}
 public record Login(@Email @NotBlank String email,@NotBlank String password){}
 @PostMapping("/register") public ResponseEntity<?> register(@RequestBody Register r){String email=r.email().toLowerCase();if(users.existsByEmail(email))return ResponseEntity.badRequest().body(Map.of("message","Email already registered"));AppUser u=new AppUser();u.setName(r.name().trim());u.setEmail(email);u.setPassword(encoder.encode(r.password()));u.setRole("STUDENT");users.save(u);return ResponseEntity.status(201).body(Map.of("message","Account created"));}
 @PostMapping("/login") public ResponseEntity<?> login(@RequestBody Login r){var u=users.findByEmail(r.email().toLowerCase()).orElse(null);if(u==null||!encoder.matches(r.password(),u.getPassword()))return ResponseEntity.status(401).body(Map.of("message","Invalid email or password"));return ResponseEntity.ok(Map.of("token",jwt.generate(u.getEmail(),u.getRole()),"name",u.getName(),"email",u.getEmail(),"role",u.getRole()));}
}
