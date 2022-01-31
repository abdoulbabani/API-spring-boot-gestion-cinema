package org.sid.GestionCinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Cinema {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double longitude,latitude,altitude;
    private int nombreSalle;
    @ManyToOne
    private  Ville ville;
    @OneToMany(mappedBy = "cinema")
    private List<Salle> salles=new ArrayList<Salle>();


}
