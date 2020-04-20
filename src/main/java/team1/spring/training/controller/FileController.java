package team1.spring.training.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import team1.spring.training.file.File;
import team1.spring.training.service.FileServiceInterface;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("user")
public class FileController {

    @Autowired
    private FileServiceInterface fileService;

    @GetMapping("file/{id}")
    public ResponseEntity<File> getFileById(@PathVariable("id") long id) {
        File file = fileService.getFileById(id);
        return new ResponseEntity<File>(file, HttpStatus.OK);
    }
    @GetMapping("file")
    public ResponseEntity<List<File>> getAllFiles() {
        List<File> list = fileService.getAllFiles();
        return new ResponseEntity<List<File>>(list, HttpStatus.OK);
    }
    @PostMapping("file")
    public ResponseEntity<Void> addFile(@RequestBody MultipartFile file) {
        boolean flag = fileService.addFile(file);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
