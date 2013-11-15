package Carte;

import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class CarteGalaxie {
    private Coordonnee c; //Coordonnees de la carte
    final int MAX_ABSCISSE = 50; //Nombre de cellule en largeur sur la carte
    final int MAX_ORDONNEE = 30; //Nombre de cellule en hauteur sur la carte
    final int NB_CELLULE = MAX_ABSCISSE * MAX_ORDONNEE; //Nombre de cellule sur la carte
    //Tableau de cellules contenant toutes les cellules de la carte
    private List<Cellule> listeCell = new ArrayList<Cellule>(); 
    
    public CarteGalaxie() throws CoordonneeException {
        //On initialise les coordonnees de la carte
        c = new Coordonnee();
        
        //Initialisation des cellules
        for (int yCell = 0 ; yCell < MAX_ORDONNEE ; yCell++) {
            for (int xCell = 0 ; xCell < MAX_ABSCISSE ; xCell++) {
                listeCell.add(new Cellule(xCell, yCell));
            }
        }
        
        this.remplirListe();
    }
    
    public CarteGalaxie(int xMap, int yMap) throws CoordonneeException {
        //On initialise les coordonnees de la carte
        c = new Coordonnee(xMap, yMap);
        
        //Initialisation des cellules
        for (int yCell = 0 ; yCell < MAX_ORDONNEE ; yCell++) {
            for (int xCell = 0 ; xCell < MAX_ABSCISSE ; xCell++) {
                listeCell.add(new Cellule(xCell, yCell));
            }
        }
        this.remplirListe();
    }
    
    public CarteGalaxie(Coordonnee c) throws CoordonneeException {
        //On initialise les coordonnees de la carte
        this.c = new Coordonnee(c);
        
        //Initialisation des cellules
        for (int yCell = 0 ; yCell < MAX_ORDONNEE ; yCell++) {
            for (int xCell = 0 ; xCell < MAX_ABSCISSE ; xCell++) {
                listeCell.add(new Cellule(xCell, yCell));
            }
        }
        
        this.remplirListe();
    }
    
    //Getters
    public Coordonnee getCoordonnee() { return c; }
    
    public Cellule getCellule(int x, int y) {
        for (Cellule cell : listeCell) {
            if (cell.getCoordonnee().equals(x, y))
                return cell;
        }
        
        return null;
    }
    
    public Cellule getCellule(Coordonnee c) {
        for (Cellule cells : listeCell) {
            if (cells.getCoordonnee().equals(c))
                return cells;
        }
        
        return null;
    }
    
    //Méthode permettant de remplir les cellules avec leur contenu réel puisque celles ci sont initialisées vide
    private void remplirListe() {
        //Méthode à implémenter avec la base de donnée donc pas encore possible !
        
        //Implémentation pour tester avec un remplissage bidon
        ContenuCellule cont = ContenuCellule.VIDE;
        for (Cellule cell : listeCell) {
            if (cont == ContenuCellule.VIDE)
                cont = ContenuCellule.PLANETE;
            else if (cont == ContenuCellule.PLANETE)
                cont = ContenuCellule.INACTIVE;
            else
                cont = ContenuCellule.VIDE;
            cell.setContenu(cont);
        }
    }
    
    //Setter
    public void setCoordonnee(int x, int y) throws CoordonneeException {
        this.c.setCoordonnee(x, y);
        this.remplirListe();
    }
    
    public void setCoordonnee(Coordonnee c) throws CoordonneeException {
        this.c.setCoordonnee(c);
        this.remplirListe();
    }
    
    //Méthode pour afficher
    public void affiche(GameContainer gc, Graphics g) throws SlickException {
        for (Cellule cell : listeCell) {
            cell.affiche(gc, g);
        }
    }
}
