package org.sid.GestionCinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Utilisateur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @ElementCollection
    private List<String> Roles=new ArrayList<String>();
    @ManyToMany
    private List<TicketPlace> ticketPlaces=new ArrayList<TicketPlace>();
}
