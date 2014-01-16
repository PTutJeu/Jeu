package Personnage;

import CartePlateforme.Plateforme;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import Armes.ListeProjectile;

import Armes.Projectile;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author Tanbi
 */
public class Heros extends Personnage {
    
    private SpriteSheet herosSheet;
    private Animation herosAnimation;
    
    private float vitesseVertical = 0.0f;
    private boolean sauter = false;
    private Image img;
    public boolean vue = true; // Vraie si le héro regarde à droite

    public Heros() throws SlickException{ // Constructeur du héros
        super();
        //herosSheet = new SpriteSheet("ressources/images/test.png",30,30);
        //herosAnimation = new Animation(herosSheet, 200);
        img = new Image("ressources/images/heros.png");
        x = 100;
        y = 0;
        x1 = x + img.getWidth();
        y1 = y + img.getHeight();       
       }

    public Image getImg(){return img;}
    
    //Méthode d'affichage de l'image du héros
    public void affiche(GameContainer gc, Graphics g) throws SlickException {
       // herosAnimation.draw(x, y);
       g.drawImage(img, x, y);
    }
   
    
    public void déplacements(GameContainer gc, int temps, Plateforme plate){
        Input input = gc.getInput(); //Variable de type entrée
        
        if( input.isKeyDown(Input.KEY_RIGHT) ){ // Si la variable pressée est flèche droite alors on déplace le héros à droite
            if ( getX1() < 799){
                x += 4;
                x1 = x + img.getWidth();;
                vue = true;
            }
        }
        
        if( input.isKeyDown(Input.KEY_LEFT) ){ // Si la variable pressée est flèche gauche alors on déplace le héros à gauche
            if ( getX() > 1){
                x -= 4;
                x1 = x + img.getWidth();
                vue = false;
            }
        }
        
        // PHASE DE SAUT
        boolean testCollision = collisions(plate);
        
        if ( getY() == 570 || getY()== plate.getY()-30 && testCollision) // Si la position du joueur est en 570 sauter est faux
            sauter = false;
        else                // Si la position du joueut n'est pas en 570 sauter est vrai
            sauter = true;
        
        // Changer la valeur avant le temps réduit la hauteur du saut.
        if( input.isKeyDown(Input.KEY_UP) && !sauter ){// Si on presse ArrowUp et que sauter est faux le personnage peut sauter
            vitesseVertical = -0.5f * temps;     // Donc on créer une "Vitesse de déplacement" en fonction du temps
            y += vitesseVertical;                // Et la position de notre héros prend la valeur de la vitesse de déplacement
            y1 = y + img.getHeight();
        }
    
        if ( !testCollision ){
            vitesseVertical += 0.01f * temps; // Même procédé que pour le saut mais fait en sorte de faire tomber le héros tout le temps
            y += vitesseVertical;
            y1 = y + img.getHeight();
            
            if (getY() > 570){                  //Si en tombant le heros sort de la map,
                setY( getY() - (getY() - 570)); // On le replace au bord.
            }
          
        }
       
        if ( testCollision && plate.getY1() >= getY1() && getY1() >= plate.getY() ){ //Recalibration
            setY( getY() - ( getY() - plate.getY() ) - 30 );
        }
        
        // Empêche de passer au milieu de la plateforme
        if ( testCollision && plate.getX() <= getX1() && getX() <= plate.getX1() && getY() < plate.getY() && getY1() > plate.getY1()){ //Recalibration
            setY( plate.getY1() +1);
        }
        
        if ( testCollision && getY() >= plate.getY() && getY() <= plate.getY1() || testCollision && getY() >= plate.getY1() ){
            setY( plate.getY1() + 01 );
        }   
        // A SAVOIR QUE CETTE FONCTION SAUT MARCHE POUR LE MOMENT UNIQUEMENT POUR LE BAS DE LA FENETRE
        // IL ME RESTE A IMPLEMENTER CA POUR QUE CA MARCHE AVEC UNE PLATEFORME UNIVERSELLE
      }
    
    
    public boolean collisions( Plateforme plate){
        if ( y1 < plate.getY() ) return false;
        if ( x1 < plate.getX() ) return false;
        if ( y > plate.getY1() ) return false;
        if ( x > plate.getX1() ) return false; 
        vitesseVertical=0;
        return true;

    }






    /* A VENIR LES METHODES POUR ATTAQUER... */

    public void tirer (GameContainer gc, ListeProjectile lp) throws SlickException{
         Input input = gc.getInput(); //Variable de type entrée
           if (input.isKeyPressed(Input.KEY_SPACE)){  //input.isMousePressed(Input.MOUSE_LEFT_BUTTON)
               lp.add(this);
           }
         }
    
    
}