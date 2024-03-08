package org.example.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @NoArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    private String email;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "utilisateur")
    private List<Projet> projets;
}
