package team1.spring.training;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private JpaRepository<File,Long> repository;

    @Autowired
    private FileRepository fileRepository;

    String fileName = "fileName";
    String fileLoction = "C:\\Uploads";
    String newFileName = "newFileName";
    File file = new File(fileLoction, new java.util.Date().toString(),fileName);


    @Test
    public void testDelete() {
        final Long id = entityManager.persistAndGetId(file, Long.class);
        repository.delete(id);
        entityManager.flush();
        File after = entityManager.find(File.class, id);
        assertEquals(null,after);
    }

    @Test
    public void testCreate() {
        final Long id = entityManager.persistAndGetId(file, Long.class);
        saveFile(file);
        File after = entityManager.find(File.class, id);
        assertEquals(after, file);
    }

    @Test
    public void testUpdate() {
        final Long id = entityManager.persistAndGetId(file, Long.class);
        saveFile(file);

        file.setName(newFileName);
        saveFile(file);
        File after = entityManager.find(File.class, id);
        assertEquals(after.getName(), newFileName);
    }

    @Test
    public void testFindByName() {
        saveFile(file);
        saveFile(file);

        List<File> files = fileRepository.findByName(fileName);
        for(int i=0; i< files.size(); i++){
            assertEquals(files.get(i).getName(), fileName);
        }
    }

    private void saveFile(File file) {
        repository.save(file);
        entityManager.flush();
    }
}