package team1.spring.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import team1.spring.training.file.File;
import team1.spring.training.file.FileRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FileService implements FileServiceInterface {

    @Autowired
    private FileRepository fileRepository ;

    @Override
    public List<File> getAllFiles() {
        List<File> list = new ArrayList<>();
        fileRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public File getFileById(long fileId) {
        File obj = fileRepository.findOne(fileId);
        return obj;
    }

    @Override
    public boolean addFile(MultipartFile file) {
        File myfile = MultipartFileToFile (file);
        List<File> list = fileRepository.findByName(myfile.getName());
        if (list.size() > 0) {
            return false;
        } else {
            fileRepository.save(myfile);
            return true;
        }
    }

    public File MultipartFileToFile (MultipartFile multipartFile){

        File myFile = new File ("C:\\Uploads", new Date().toString(), multipartFile.getOriginalFilename());
        myFile.setId(myFile.getId());
        return myFile;
    }
}