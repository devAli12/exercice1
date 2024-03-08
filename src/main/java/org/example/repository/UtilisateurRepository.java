package org.example.repository;

import lombok.AllArgsConstructor;
import org.example.entity.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@AllArgsConstructor
public class UtilisateurRepository {

    private EntityManagerFactory entityManagerFactory;

    public List<Utilisateur> findAllUsersOrderedByIdAsc() {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT u FROM Utilisateur u ORDER BY u.id ASC", Utilisateur.class)
                .getResultList();
    }

    public EntityManager getEntityManager(){
        return  entityManagerFactory.createEntityManager();
    }

}
