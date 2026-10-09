package edu.klu.foodwaste.repo;
import edu.klu.foodwaste.model.WasteRecord;import org.springframework.data.jpa.repository.JpaRepository;import java.time.LocalDate;import java.util.List;
public interface WasteRepository extends JpaRepository<WasteRecord,Long>{List<WasteRecord> findByRecordDateBetweenOrderByRecordDateDesc(LocalDate start,LocalDate end);}
