
package Personnage;

import Carte.ContenuCellule;
import Carte.Coordonnee;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Vaisseau extends Personnage{
        private Coordonnee coord;//coordonnées du vaisseau
        private ContenuCellule cont;//Contenu de la cellule ou se trouve le vaisseau
        final int TAILLE_CELL = 20; //Constante : taille d'une cellule (en pixel)
        
        public Vaisseau(){
            super();
            coord= new Coordonnee();
        }
        public Vaisseau(int v,int x,int n, Coordonnee c){}
        
        public void affiche(GameContainer gc, Graphics g) throws SlickException {
        /*
         * JE SAIS PAS ENCORE COMMENT QU'ON FAIT, CA DOIT ETRE UN TRUC DE CE STYLE.
         * APRES QUELQUES TEST VISIBLEMENT CA MARCHE, A VERIFIER QUAND MEME, POSSIBLE SOURCE
         * D'ERREURS !
         */
        //On charge l'image correspondant à la cellule (grâce au chemin d'accès)
        Image img = new Image("ressources/images/vaisseau.png"); 
        //On défini les positions en X et en Y (en pixel), en multipliant la coordonnée de la case
        //par la taille d'une case
        int posX = coord.getX() * TAILLE_CELL;
        int posY = coord.getY() * TAILLE_CELL;
        //On affiche l'image à la position voulue
        g.drawImage(img, posX, posY);
    }
        
        public ContenuCellule getCont(){ return cont;}
        
        public Coordonnee getCoord() { return coord;}
}
