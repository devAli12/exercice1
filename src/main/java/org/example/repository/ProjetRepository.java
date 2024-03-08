package org.example.repository;

import lombok.AllArgsConstructor;
import org.example.entity.Projet;
import org.example.entity.Tache;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
public class ProjetRepository {
    private EntityManagerFactory entityManagerFactory;

    public List<Projet> findAllProjectsOrderedByIdAsc() {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT p FROM Projet p ORDER BY p.id ASC", Projet.class)
                .getResultList();
    }

    public void addTacheToProjet(int projetId, Tache tache) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Projet projet = em.find(Projet.class, projetId);
        if (projet != null) {
            tache.setProjet(projet);
            em.persist(tache);
        }
        em.getTransaction().commit();
    }


    public void persistProjetWithNamedQuery(Projet projet) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("INSERT INTO Projet (id, titre, description) VALUES (?, ?, ?)")
                .setParameter(1, projet.getId())
                .setParameter(2, projet.getTitre())
                .setParameter(3, projet.getDescription())
                .executeUpdate();
        em.getTransaction().commit();
    }


    public EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

}
