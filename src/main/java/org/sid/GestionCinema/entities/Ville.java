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
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nom;
    private double longitude,latitude,altitude;
    private int nombreHabitant;
    @OneToMany(mappedBy = "ville")
    private List<Cinema> cinemaList=new ArrayList<Cinema>();
}
