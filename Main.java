import java.util.*;

// Classe abstraite Utilisateur
abstract class Utilisateur {
    protected String nom;
    protected String prenom;
    protected String role;

    public Utilisateur(String nom, String prenom, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getRole() {
        return role;
    }

    public abstract void afficherTaches();
}

// Classe ChefDeProjet
class ChefDeProjet extends Utilisateur {
    public ChefDeProjet(String nom, String prenom) {
        super(nom, prenom, "Chef de Projet");
    }

    @Override
    public void afficherTaches() {
        System.out.println("Responsable de la gestion de l'ensemble du projet.");
    }
}

// Classe Manager
class Manager extends Utilisateur {
    public Manager(String nom, String prenom) {
        super(nom, prenom, "Manager");
    }

    @Override
    public void afficherTaches() {
        System.out.println("Gère les équipes et les ressources.");
    }
}

// Classe Employe
class Employe extends Utilisateur {
    public Employe(String nom, String prenom) {
        super(nom, prenom, "Employé");
    }

    @Override
    public void afficherTaches() {
        System.out.println("Exécute les tâches spécifiques assignées.");
    }
}

// Classe Membre
class Membre extends Utilisateur {
    public Membre(String nom, String prenom) {
        super(nom, prenom, "Membre");
    }

    @Override
    public void afficherTaches() {
        System.out.println("Participe aux tâches dans son domaine.");
    }
}

// Classe ChefDEquipe
class ChefDEquipe extends Utilisateur {
    public ChefDEquipe(String nom, String prenom) {
        super(nom, prenom, "Chef d'Équipe");
    }

    @Override
    public void afficherTaches() {
        System.out.println("Gère une équipe spécifique et coordonne les efforts.");
    }
}

// Classe Projet
class Projet {
    private String nomProjet;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private List<Utilisateur> membres;

    public Projet(String nomProjet, String description, Date dateDebut, Date dateFin) {
        this.nomProjet = nomProjet;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.membres = new ArrayList<>();
    }

    public void ajouterMembre(Utilisateur utilisateur) {
        membres.add(utilisateur);
    }

    public void afficherDetailsProjet() {
        System.out.println("Nom du projet: " + nomProjet);
        System.out.println("Description: " + description);
        System.out.println("Date de début: " + dateDebut);
        System.out.println("Date de fin: " + dateFin);
    }

    public void afficherMembres() {
        System.out.println("Membres du projet:");
        for (Utilisateur membre : membres) {
            System.out.println(membre.getNom() + " " + membre.getPrenom() + " (" + membre.getRole() + ")");
        }
    }
}

// Classe Rapport
class Rapport {
    private Date dateRapport;
    private String contenu;

    public Rapport(Date dateRapport, String contenu) {
        this.dateRapport = dateRapport;
        this.contenu = contenu;
    }

    public void afficherRapport() {
        System.out.println("Rapport du " + dateRapport);
        System.out.println("Contenu: " + contenu);
    }
}

// Classe Main
public class Main {
    public static void main(String[] args) {
        // Création des utilisateurs
        ChefDeProjet chef = new ChefDeProjet("John", "Doe");
        Manager manager = new Manager("Jane", "Smith");
        Employe employe = new Employe("Lucas", "Benz");
        Membre membre = new Membre("Alicia", "Perez");
        ChefDEquipe chefEquipe = new ChefDEquipe("Karl", "Groot");

        // Création du projet
        Projet projet = new Projet("Développement logiciel", "Développement d'un logiciel de gestion de projet", new Date(), new Date());
        projet.ajouterMembre(chef);
        projet.ajouterMembre(manager);
        projet.ajouterMembre(employe);
        projet.ajouterMembre(membre);
        projet.ajouterMembre(chefEquipe);

        // Affichage des détails du projet et des membres
        projet.afficherDetailsProjet();
        projet.afficherMembres();

        // Affichage des tâches des utilisateurs
        chef.afficherTaches();
        manager.afficherTaches();
        employe.afficherTaches();
        membre.afficherTaches();
        chefEquipe.afficherTaches();

        // Création de rapports
        Rapport rapport1 = new Rapport(new Date(), "Le projet est dans les temps.");
        Rapport rapport2 = new Rapport(new Date(), "Des retards sont à prévoir.");
        
        // Affichage des rapports
        rapport1.afficherRapport();
        rapport2.afficherRapport();
    }
}
