package edu.klu.foodwaste.model;
import jakarta.persistence.*;import java.time.LocalDate;import java.time.LocalDateTime;
@Entity @Table(name="waste_records")
public class WasteRecord{
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="meal_id") private Meal meal;
 @ManyToOne(optional=false) @JoinColumn(name="recorded_by") private AppUser recordedBy;
 @Column(nullable=false) private double preparedKg;
 @Column(nullable=false) private double consumedKg;
 @Column(nullable=false) private double wasteKg;
 @Column(nullable=false) private double wastePercentage;
 @Column(nullable=false) private LocalDate recordDate;
 @Column(length=1000) private String notes;
 private LocalDateTime createdAt=LocalDateTime.now();
 public Long getId(){return id;}public Meal getMeal(){return meal;}public void setMeal(Meal v){meal=v;}
 public AppUser getRecordedBy(){return recordedBy;}public void setRecordedBy(AppUser v){recordedBy=v;}
 public double getPreparedKg(){return preparedKg;}public void setPreparedKg(double v){preparedKg=v;}
 public double getConsumedKg(){return consumedKg;}public void setConsumedKg(double v){consumedKg=v;}
 public double getWasteKg(){return wasteKg;}public void setWasteKg(double v){wasteKg=v;}
 public double getWastePercentage(){return wastePercentage;}public void setWastePercentage(double v){wastePercentage=v;}
 public LocalDate getRecordDate(){return recordDate;}public void setRecordDate(LocalDate v){recordDate=v;}
 public String getNotes(){return notes;}public void setNotes(String v){notes=v;}
 public LocalDateTime getCreatedAt(){return createdAt;}
}
