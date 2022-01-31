package org.sid.GestionCinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class FilmProjection {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateProjection;
    private double prix;
    @OneToMany(mappedBy = "filmProjection")
    private List<TicketPlace> ticketPlaces=new ArrayList<TicketPlace>();
    @ManyToOne
    private Seance seance;
    @ManyToOne
    private Film film;
    @ManyToOne
    private Salle salle;

}
