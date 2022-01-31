package org.sid.GestionCinema.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Categorie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nonCategorie;
    @OneToMany(mappedBy = "categorie")
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private List<Film> filmList=new ArrayList<Film>();

}
