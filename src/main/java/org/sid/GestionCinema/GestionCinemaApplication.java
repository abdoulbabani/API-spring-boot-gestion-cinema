package org.sid.GestionCinema;

import org.sid.GestionCinema.service.Icinema;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionCinemaApplication implements CommandLineRunner {
    Icinema icinema;

    public GestionCinemaApplication(Icinema icinema) {
        this.icinema = icinema;
    }

    public static void main(String[] args) {
        SpringApplication.run(GestionCinemaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       icinema.initVillee();
       icinema.initCinemas();
       icinema.initSalles();
       icinema.initPlace();
       icinema.initSeance();
       icinema.initCategori();
       icinema.initFilms();
       icinema.initPojection();
       icinema.initTicketPlace();
    }
}
