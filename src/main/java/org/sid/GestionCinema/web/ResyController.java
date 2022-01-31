package org.sid.GestionCinema.web;

import org.sid.GestionCinema.dao.FilmRepo;
import org.sid.GestionCinema.entities.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class ResyController {
    @Autowired
    private FilmRepo filmRepo;

    @GetMapping(path = "/Photo/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> image(@PathVariable(name="id") Long id) throws IOException {
        Film film=filmRepo.findById(id).get();
        String photo=film.getPhoto();
        File file=new File(System.getProperty("user.home")+"/images/"+photo+".jpeg");
        Path path= Paths.get(file.toURI());
        return new ResponseEntity<byte[]>(Files.readAllBytes(path),HttpStatus.OK) ;
    }

}
