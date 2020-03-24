package team1.spring.training;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface FileServiceInterface {
    List<File> getAllFiles();
    File getFileById(long fileId);
    boolean addFile(MultipartFile file);
//    File updateFile(MultipartFile file);
//    void deleteFile(long fileId);
}
