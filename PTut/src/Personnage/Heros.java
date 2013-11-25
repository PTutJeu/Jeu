package Personnage;

import CartePlateforme.Plateforme;
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
    
    private float vitesseVertical = 0.0f;
    private boolean sauter = false;
    private Image img;

    public Heros() throws SlickException{ // Constructeur du héros
        super();
        img = new Image("ressources/images/heros.png");
        x = 100;
        y = 00;
        x1 = x + img.getWidth();
        y1 = y + img.getHeight();
        
       }

    public Image getImg(){return img;}
    
    //Méthode d'affichage de l'image du héros
    public void affiche(GameContainer gc, Graphics g) throws SlickException {
        g.drawImage(img, x, y);
    }
   
    
    public void déplacements(GameContainer gc, int temps, Plateforme plate){
        Input input = gc.getInput(); //Variable de type entrée
        
        if( input.isKeyDown(Input.KEY_RIGHT) ){ // Si la variable pressée est flèche droite alors on déplace le héros à droite
            x += 4;
            x1 += 4;
            System.out.println(y);
        }
        
        if( input.isKeyDown(Input.KEY_LEFT) ){ // Si la variable pressée est flèche gauche alors on déplace le héros à gauche
            x -= 4;
            x1 -= 4;
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
        if ( !testCollision || testCollision && plate.getY1() >= getY() && getY() >= plate.getY()  ){
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
        // A SAVOIR QUE CETTE FONCTION SAUT MARCHE POUR LE MOMENT UNIQUEMENT POUR LE BAS DE LA FENETRE
        // IL ME RESTE A IMPLEMENTER CA POUR QUE CA MARCHE AVEC UNE PLATEFORME UNIVERSELLE
      }
    
    
    public boolean collisions( Plateforme plate){
        if ( y1 < plate.getY() ) return false;
        if ( x1 < plate.getX() ) return false;
        if ( y > plate.getY1() ) return false;
        if ( x > plate.getX1() ) return false;
        return true;
    }

}




    /* A VENIR LES METHODES POUR ATTAQUER... */