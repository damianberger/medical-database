package pl.coderslab.medbaseproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.medbaseproject.entity.Disease;




@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {
}
