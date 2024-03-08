package org.example;

import org.example.entity.Projet;
import org.example.entity.Tache;
import org.example.repository.ProjetRepository;
import org.example.repository.TacheRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet_unit");
        ProjetRepository projetRepository = new ProjetRepository(entityManagerFactory);
        TacheRepository tacheRepository = new TacheRepository(entityManagerFactory);
        // Test method to retrieve all projects ordered by ID
        //System.out.println("All Projects ordered by ID:");
        //List<Projet> projets= projetRepository.findAllProjectsOrderedByIdAsc();
        //for (Projet p : projets) System.out.println(p.getTitre());

        // Test method to persist a project using a named query
        //Projet newProjet = new Projet();
        //newProjet.setId(3);
        //newProjet.setTitre("New Project");
        //newProjet.setDescription("Description for New Project");
        //projetRepository.persistProjetWithNamedQuery(newProjet);

        //System.out.println("\nAll Projects after adding a new project:");
        //List<Projet> projets= projetRepository.findAllProjectsOrderedByIdAsc();
        //for (Projet p : projets) System.out.println(p.getTitre());

        // Test method to delete all tasks for a project
        //int projectIdToDeleteTasks = 1;
        //System.out.println("\nDeleting all tasks for Project with ID " + projectIdToDeleteTasks);
        //tacheRepository.deleteAllTachesForProjet(projectIdToDeleteTasks);
        //System.out.println("\nAll Projects after deleting tasks for Project with ID " + projectIdToDeleteTasks);
        //List<Tache> taches= tacheRepository.findAllTachesOrderedByIdAsc();
        //for (Tache t : taches) System.out.println(t.getTitre());

        int projetIdToAddTask = 1;
        Tache newTache = new Tache();
        newTache.setId(5);
        newTache.setTitre("New Task for Project A");

        System.out.println("\nAdding a new task to Project with ID " + projetIdToAddTask);
        projetRepository.addTacheToProjet(projetIdToAddTask, newTache);

        System.out.println("\nAll Projects after adding a new task to Project with ID " + projetIdToAddTask);
        List<Tache> taches= tacheRepository.findAllTachesOrderedByIdAsc();
        for (Tache t : taches) System.out.println(t.getTitre());

    }
}