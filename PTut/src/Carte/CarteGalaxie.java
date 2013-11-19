package Carte;

import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class CarteGalaxie {
    private int id; //Identifiant de la carte
    final int MAX_ABSCISSE = 50; //Nombre de cellule en largeur sur la carte
    final int MAX_ORDONNEE = 30; //Nombre de cellule en hauteur sur la carte
    final int NB_CELLULE = MAX_ABSCISSE * MAX_ORDONNEE; //Nombre de cellule sur la carte
    
    public CarteGalaxie() {
        //On initialise les coordonnees de la carte
        id = 0;
    }
    
    //Méthode pour afficher
    public void affiche(GameContainer gc, Graphics g) {
        
    }
}
