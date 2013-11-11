package Carte;

/*
 * Enumération : Liste de valeurs constantes que pourra prendre l'attribut contenu
 * Vide signifie une case accessible, où il n'y a rien
 * Planete signifie une case contenant une planete
 * Inactive signifie une case qui n'est pas accessible par le joueur
 * 
 * LISTE A COMPLETER (on pourra par exemple rajouter TELEPORTEUR pour une case permettant de se
 * déplacer sur la map suivante)
 */
enum ContenuCell { VIDE, PLANETE, INACTIVE };

public class Cellule {
    private Coordonnee coord; //Coordonnées de la cellule
    private ContenuCell contenu; //Contenu de la cellule (voir enum)
    private String img; //Chemin d'accès de l'image à charger lors de l'affichage
    
    //Constructeur par défaut
    public Cellule() throws CoordonneeException {
        coord = new Coordonnee();
        contenu = ContenuCell.VIDE;
        img = "./../ressources/case_vide.bmp"; //C'est un exemple, pas sur que ça fonctionne
    }
    
    public Cellule(int x, int y, ContenuCell cont) throws CoordonneeException {
        coord = new Coordonnee(x, y);
        contenu = cont;
        img = getCheminAcces();
    }
    
    public String getCheminAcces() {
        return "";
    }
}
