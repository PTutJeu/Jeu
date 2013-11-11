package Carte;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

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
    private String cheminAccesImage; //Chemin d'accès de l'image à charger lors de l'affichage
    final int TAILLE_CELL = 20; //Constante : taille d'une cellule (en pixel)
    
    //Constructeur par défaut
    public Cellule() throws CoordonneeException {
        coord = new Coordonnee();
        contenu = ContenuCell.VIDE;
        cheminAccesImage = recupCheminAcces();
    }
    
    //Plusieurs constructeurs, on peut en avoir besoin, on verra
    public Cellule(int x, int y) throws CoordonneeException {
        coord = new Coordonnee(x, y);
        contenu = ContenuCell.VIDE;
        cheminAccesImage = recupCheminAcces();
    }
    
    public Cellule(int x, int y, ContenuCell cont) throws CoordonneeException {
        coord = new Coordonnee(x, y);
        contenu = cont;
        cheminAccesImage = recupCheminAcces();
    }
    
    public Cellule(Coordonnee c) throws CoordonneeException {
        coord = new Coordonnee(c);
        contenu = ContenuCell.VIDE;
        cheminAccesImage = recupCheminAcces();
    }
    
    public Cellule(Coordonnee c, ContenuCell cont) throws CoordonneeException {
        coord = new Coordonnee(c);
        contenu = cont;
        cheminAccesImage = recupCheminAcces();
    }
    
    //Constructeur par recopie
    public Cellule(Object o) throws CelluleException, CoordonneeException {
        if (!(o instanceof Cellule))
            throw new CelluleException("L'objet n'est pas une cellule.");
        
        Cellule c = (Cellule) o;
        coord = new Coordonnee(c.getCoordonnee());
        contenu = c.getContenu();
        cheminAccesImage = c.getCheminAccesImage();
    }
    
    //Getters
    public Coordonnee getCoordonnee() { return coord; }
    public ContenuCell getContenu() { return contenu; }
    public String getCheminAccesImage() { return cheminAccesImage; }
    
    //Récupère le chemin d'accès de l'image correspondant au contenu de la cellule
    public String recupCheminAcces() {
        switch (contenu) {
            case VIDE:
                return "ressources/images/case_vide.bmp"; //A remplacer par le chemin d'accès lorsqu'on en aura un
            case PLANETE:
                return "ressources/images/case_planete.bmp"; //A remplacer par le chemin d'accès lorsqu'on en aura un
            case INACTIVE:
                return "ressources/images/case_inactive.bmp"; //A remplacer par le chemin d'accès lorsqu'on en aura un
            default:
                return "ressources/images/case_vide.bmp"; //A remplacer par le chemin d'accès d'une case vide ou inactive a voir
        }
    }
    
    //Setters
    public void setContenu(ContenuCell cont) {
        //On change le contenu et on met à jour le chemin d'accès vers l'image à afficher
        contenu = cont;
        cheminAccesImage = recupCheminAcces(); 
    }
    
    public void setCoordonnee(Object o) throws CoordonneeException {
        coord.setCoordonnee(o);
    }
    
    public void setCoordonnee(int x, int y) throws CoordonneeException {
        coord.setCoordonnee(x, y);
    }
    
    public void setX(int x) throws CoordonneeException {
        coord.setX(x);
    }
    
    public void setY(int y) throws CoordonneeException {
        coord.setY(y);
    }
    
    //Permet d'afficher la cellule à l'écran
    public void affiche(GameContainer gc, Graphics g) {
        //JE SAIS PAS ENCORE COMMENT QU'ON FAIT
    }
}
