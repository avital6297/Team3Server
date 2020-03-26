package team1.spring.training;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository <File, Long> {
      List<File> findByName(String name);
}