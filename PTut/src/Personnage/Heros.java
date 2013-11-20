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
    
    private boolean sauter;
    
    public boolean getSauter(){
        return sauter;
    }
    
    public Heros(){ // Constructeur du héros
        super();
        x = 100;
        y = 00;
        sauter = false;
    }
    
    //Méthode d'affichage de l'image du héros
    public void affiche(GameContainer gc, Graphics g) throws SlickException {
        Image img = new Image("ressources/images/heros.png");
        g.drawImage(img, x, y);
    }
   
    public void tomber(GameContainer gc, boolean sauter) {
        if ( !sauter ){
            if( getY()<570 )
                y += 4;
            
        }
    }
     public void sauter(GameContainer gc, boolean sauter){
         Input input = gc.getInput();
         if( input.isKeyDown(Input.KEY_UP) ){
             sauter = true;
             if (sauter == true){
                y -=100;
         }
         }
         
     }
 
    public void déplacements(GameContainer gc){
        Input input = gc.getInput(); //Variable de type entrée
        
        if( input.isKeyDown(Input.KEY_RIGHT) ){ // Si la variable pressée est flèche droite alors on déplace le héros à droite
            x += 4;
        }
        
        if( input.isKeyDown(Input.KEY_LEFT) ){ // Si la variable pressée est flèche gauche alors on déplace le héros à gauche
            x -= 4;
        }       

      }
        
    }
    /* A VENIR LES METHODES POUR ATTAQUER... */