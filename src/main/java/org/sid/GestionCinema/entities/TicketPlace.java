package org.sid.GestionCinema.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class TicketPlace {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double prix;
    private String nomClient;
    @Column(unique = true,nullable = true)
    private Integer codePayement;
    private Boolean reserve;
    @ManyToOne
    private Place place;
    @ManyToOne
    private FilmProjection filmProjection;
    @ManyToMany(mappedBy = "ticketPlaces")
    private List<Utilisateur>utilisateurs=new ArrayList<Utilisateur>();

}
