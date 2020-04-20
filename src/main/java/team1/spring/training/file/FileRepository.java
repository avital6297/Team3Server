package team1.spring.training.file;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team1.spring.training.file.File;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository <File, Long> {
      List<File> findByName(String name);
}