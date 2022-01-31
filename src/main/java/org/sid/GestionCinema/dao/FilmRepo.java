package org.sid.GestionCinema.dao;

import org.sid.GestionCinema.entities.Cinema;
import org.sid.GestionCinema.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FilmRepo extends JpaRepository<Film,Long> {
}
