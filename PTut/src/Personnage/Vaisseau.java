
package Personnage;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Vaisseau extends Personnage{
        private int x;//coordonnée en x du vaisseau
        private int y;//coordonnée en y du vaisseau
        
        public Vaisseau(){
            super();
            x = 0;
            y = 0;
        }
        
        public void affiche(GameContainer gc, Graphics g) throws SlickException {
        
        //On charge l'image correspondant à la cellule (grâce au chemin d'accès)
        Image img = new Image("ressources/images/vaisseau.png");
        //On affiche l'image à la position voulue
        g.drawImage(img, 25, 25);
    }
}
