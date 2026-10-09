package edu.klu.foodwaste.model;
import jakarta.persistence.*;import java.time.LocalDate;
@Entity @Table(name="meals")
public class Meal{
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String name;
 @Column(nullable=false) private String mealType;
 @Column(length=1200) private String menuItems;
 @Column(nullable=false) private LocalDate mealDate;
 private String servingTime;
 private String status="PLANNED";
 public Long getId(){return id;}public String getName(){return name;}public void setName(String v){name=v;}
 public String getMealType(){return mealType;}public void setMealType(String v){mealType=v;}
 public String getMenuItems(){return menuItems;}public void setMenuItems(String v){menuItems=v;}
 public LocalDate getMealDate(){return mealDate;}public void setMealDate(LocalDate v){mealDate=v;}
 public String getServingTime(){return servingTime;}public void setServingTime(String v){servingTime=v;}
 public String getStatus(){return status;}public void setStatus(String v){status=v;}
}
