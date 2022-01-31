package org.sid.GestionCinema.dao;

import org.sid.GestionCinema.entities.Cinema;
import org.sid.GestionCinema.entities.TicketPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TicketPlaceRepo extends JpaRepository<TicketPlace,Long> {
}
