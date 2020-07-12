package pl.coderslab.medbaseproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.medbaseproject.entity.Drug;

import java.util.List;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Long> {
}
