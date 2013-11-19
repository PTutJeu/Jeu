package Personnage;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Tanbi
 */
public class Heros extends Personnage {
    
    public Heros(){ // Constructeur du héros
        super();
        x = 100;
        y = 500;
    }
    
    //Méthode d'affichage de l'image du héros
    public void affiche(GameContainer gc, Graphics g) throws SlickException {
        Image img = new Image("ressources/images/heros.png");
        g.drawImage(img, x, y);
    }
   
    public void déplacements(GameContainer gc){
        Input input = gc.getInput(); //Variable de type entrée
        
        if( input.isKeyDown(Input.KEY_RIGHT) ){ // Si la variable pressée est flèche droite alors on déplace le héros à droite
            x = x+4;
        }
        
        if( input.isKeyDown(Input.KEY_LEFT) ){ // Si la variable pressée est flèche gauche alors on déplace le héros à gauche
            x = x-4;
        }

      }
        
    }
    /* A VENIR LES METHODES POUR ATTAQUER... */