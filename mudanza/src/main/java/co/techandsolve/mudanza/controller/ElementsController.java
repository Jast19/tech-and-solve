package co.techandsolve.mudanza.controller;

import co.techandsolve.mudanza.application.ProcessApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/elements")
public class ElementsController {

    private ProcessApplication application;

    @Autowired
    public ElementsController(ProcessApplication application) {
        this.application = application;
    }

    @PostMapping("/upload/{id}")
    public ResponseEntity<byte[]> download(@RequestParam("file") MultipartFile file, @PathVariable String id) {
        byte[] files = this.application.action(file, id);
        return new ResponseEntity<>(files, HttpStatus.OK);
    }
}
