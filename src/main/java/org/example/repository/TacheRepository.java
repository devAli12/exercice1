package org.example.repository;

import lombok.AllArgsConstructor;
import org.example.entity.Tache;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
public class TacheRepository {

    EntityManagerFactory entityManagerFactory ;

    public List<Tache> findAllTachesOrderedByIdAsc() {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT t FROM Tache t ORDER BY t.id ASC", Tache.class)
                .getResultList();
    }


    public EntityManager getEntityManager(){
        return  entityManagerFactory.createEntityManager();
    }

    public void deleteAllTachesForProjet(int projetId) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Tache t WHERE t.projet.id = :projetId")
                .setParameter("projetId", projetId)
                .executeUpdate();
        em.getTransaction().commit();
    }

}
