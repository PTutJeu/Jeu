package Personnage;

import CartePlateforme.Plateforme;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Wazaa
 */
public class Monstre extends Personnage{
    private Image img;
    private float vitesseVertical = 0.0f;
    
    public Monstre() throws SlickException{ // Constructeur du héros
        super();
        img = new Image("ressources/images/monstre.png");
        x = 550;
        y = 550;
        x1 = x + img.getWidth();
        y1 = y + img.getHeight();
       }
    
     public void affiche(GameContainer gc, Graphics g) throws SlickException {
        g.drawImage(img, x, y);
     }
   public void déplacements(GameContainer gc, int temps, Plateforme plate,Heros heros){
       boolean testCollision = collisions(plate);
       
       if ( !testCollision ){
            vitesseVertical += 0.01f * temps; // Même procédé que pour le saut mais fait en sorte de faire tomber le héros tout le temps
            y += vitesseVertical;
            y1 = y + img.getHeight();
            
            if (getY() > 570){                  //Si en tombant le heros sort de la map,
                setY( getY() - (getY() - 570)); // On le replace au bord.
            }
            
        }
       // Ici je met en place le deplacement du monstre vers le joueur, le -25 devra etre remplacé par la taille de la HITBOX
       // Sinon pour l'instant il me suit normalement
       if (x > (heros.getX1()+25)) x-=2;
       if (x < (heros.getX()-25)) x+=2;
   }
   public boolean collisions( Plateforme plate){
        if ( y1 < plate.getY() ) return false;
        if ( x1 < plate.getX() ) return false;
        if ( y > plate.getY1() ) return false;
        if ( x > plate.getX1() ) return false;
        return true;
   }      
       
}

