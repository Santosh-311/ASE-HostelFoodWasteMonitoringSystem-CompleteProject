package edu.klu.foodwaste.web;
import edu.klu.foodwaste.model.Meal;import edu.klu.foodwaste.repo.MealRepository;import jakarta.validation.Valid;import jakarta.validation.constraints.*;import org.springframework.http.*;import org.springframework.security.core.Authentication;import org.springframework.web.bind.annotation.*;import java.time.LocalDate;import java.util.*;
@RestController @RequestMapping("/api/meals") public class MealController{
 private final MealRepository repo;public MealController(MealRepository r){repo=r;}
 public record MealInput(@NotBlank String name,@NotBlank String mealType,String menuItems,@NotNull LocalDate mealDate,String servingTime){}
 @GetMapping public List<Meal> all(@RequestParam(required=false)String date){if(date!=null&&!date.isBlank()){LocalDate d=LocalDate.parse(date);return repo.findByMealDateBetweenOrderByMealDateDesc(d,d);}return repo.findAll().stream().sorted(Comparator.comparing(Meal::getMealDate).reversed()).toList();}
 @PostMapping public ResponseEntity<?> create(@Valid @RequestBody MealInput x,Authentication a){if(a==null)return ResponseEntity.status(401).body(Map.of("message","Log in first"));if(!staff(a))return ResponseEntity.status(403).body(Map.of("message","Kitchen staff or admin only"));Meal m=new Meal();fill(m,x);return ResponseEntity.status(201).body(repo.save(m));}
 @PutMapping("/{id}") public ResponseEntity<?> update(@PathVariable Long id,@Valid @RequestBody MealInput x,Authentication a){if(a==null||!staff(a))return ResponseEntity.status(403).build();return repo.findById(id).map(m->{fill(m,x);return ResponseEntity.ok(repo.save(m));}).orElseGet(()->ResponseEntity.notFound().build());}
 @DeleteMapping("/{id}") public ResponseEntity<?> delete(@PathVariable Long id,Authentication a){if(a==null||!staff(a))return ResponseEntity.status(403).build();if(!repo.existsById(id))return ResponseEntity.notFound().build();repo.deleteById(id);return ResponseEntity.noContent().build();}
 private void fill(Meal m,MealInput x){m.setName(x.name().trim());m.setMealType(x.mealType().toUpperCase());m.setMenuItems(x.menuItems());m.setMealDate(x.mealDate());m.setServingTime(x.servingTime());}
 private boolean staff(Authentication a){return a.getAuthorities().stream().anyMatch(x->Set.of("ROLE_ADMIN","ROLE_KITCHEN").contains(x.getAuthority()));}
}
