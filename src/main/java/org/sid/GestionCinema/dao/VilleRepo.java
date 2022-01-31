package org.sid.GestionCinema.dao;

import org.sid.GestionCinema.entities.Cinema;
import org.sid.GestionCinema.entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VilleRepo extends JpaRepository<Ville,Long> {
}
