package edu.klu.foodwaste.model;
import jakarta.persistence.*;import java.time.LocalDateTime;
@Entity @Table(name="meal_feedback")
public class Feedback{
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="meal_id") private Meal meal;
 @ManyToOne(optional=false) @JoinColumn(name="user_id") private AppUser user;
 @Column(nullable=false) private int rating;
 @Column(length=1000) private String comment;
 private LocalDateTime createdAt=LocalDateTime.now();
 public Long getId(){return id;}public Meal getMeal(){return meal;}public void setMeal(Meal v){meal=v;}
 public AppUser getUser(){return user;}public void setUser(AppUser v){user=v;}
 public int getRating(){return rating;}public void setRating(int v){rating=v;}
 public String getComment(){return comment;}public void setComment(String v){comment=v;}
 public LocalDateTime getCreatedAt(){return createdAt;}
}
