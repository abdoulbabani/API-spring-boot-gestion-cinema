package org.sid.GestionCinema.dao;

import org.sid.GestionCinema.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CinemaRepo extends JpaRepository<Cinema,Long> {
}
