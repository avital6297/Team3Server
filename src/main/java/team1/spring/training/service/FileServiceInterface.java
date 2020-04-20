package team1.spring.training.service;

import org.springframework.web.multipart.MultipartFile;
import team1.spring.training.file.File;

import java.util.List;


public interface FileServiceInterface {
    List<File> getAllFiles();
    File getFileById(long fileId);
    boolean addFile(MultipartFile file);
//    File updateFile(MultipartFile file);
//    void deleteFile(long fileId);
}
