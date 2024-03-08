-- Insert sample Utilisateurs
INSERT INTO Utilisateur (id,nom, email) VALUES (1,'John Doe', 'john.doe@example.com');
INSERT INTO Utilisateur (id,nom, email) VALUES (2,'Jane Smith', 'jane.smith@example.com');

-- Insert sample Projets
INSERT INTO Projet (id, titre, description,utilisateur_id) VALUES (1, 'Project A', 'Description for Project A',1);
INSERT INTO Projet (id, titre, description,utilisateur_id) VALUES (2, 'Project B', 'Description for Project B',2);

-- Insert sample Taches
INSERT INTO Tache (id, titre, projet_id) VALUES (1, 'Task 1 for Project A', 1);
INSERT INTO Tache (id, titre, projet_id) VALUES (2, 'Task 2 for Project A', 1);
INSERT INTO Tache (id, titre, projet_id) VALUES (3, 'Task 1 for Project B', 2);
INSERT INTO Tache (id, titre, projet_id) VALUES (4, 'Task 2 for Project B', 2);
