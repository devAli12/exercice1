package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @ToString
@NoArgsConstructor
public class Projet {
    @Id
    private  int id;

    private String titre;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    private Utilisateur utilisateur;

    @OneToMany(cascade= CascadeType.ALL,mappedBy = "projet")
    private List<Tache> taches;
}
