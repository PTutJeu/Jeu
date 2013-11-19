
package Personnage;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class Vaisseau extends Personnage{
        
        public Vaisseau(){
            super();
            x = 250;
            y = 250;
        }
        
        public void affiche(GameContainer gc, Graphics g) throws SlickException {
        
        //On charge l'image correspondant à la cellule (grâce au chemin d'accès)
        Image img = new Image("ressources/images/vaisseau.png");
        //On affiche l'image à la position voulue
        g.drawImage(img, x, y);
    }
        
    public void deplace(GameContainer gc){
        Input input = gc.getInput(); //Variable de type entrée
        
        if( input.isKeyDown(Input.KEY_RIGHT) ){ // Si la variable pressée est flèche droite alors on déplace le héros à droite
            x = x+4;
        }
        
        if( input.isKeyDown(Input.KEY_LEFT) ){ // Si la variable pressée est flèche gauche alors on déplace le héros à gauche
            x = x-4;
        }
         if( input.isKeyDown(Input.KEY_UP) ){ // Si la variable pressée est flèche droite alors on déplace le héros à droite
            y = y-4;
        }
        
        if( input.isKeyDown(Input.KEY_DOWN) ){ // Si la variable pressée est flèche gauche alors on déplace le héros à gauche
            y = y+4;
        }

      }
}
