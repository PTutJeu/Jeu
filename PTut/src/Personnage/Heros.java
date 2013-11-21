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
    
    private float vitesseVertical = 0.0f;
    private boolean sauter = false;

    public Heros(){ // Constructeur du héros
        super();
        x = 100;
        y = 00;
       }
    
    //Méthode d'affichage de l'image du héros
    public void affiche(GameContainer gc, Graphics g) throws SlickException {
        Image img = new Image("ressources/images/heros.png");
        g.drawImage(img, x, y);
        
        Input input = gc.getInput();

        if( input.isKeyDown(Input.KEY_SPACE) ){
            Image projec = new Image("ressources/images/projectile.png");
            g.drawImage(projec, x+=4, y);
        }
    }
   
    
    public void déplacements(GameContainer gc, int temps){
        Input input = gc.getInput(); //Variable de type entrée
        
        if( input.isKeyDown(Input.KEY_RIGHT) ){ // Si la variable pressée est flèche droite alors on déplace le héros à droite
            x += 4;
        }
        
        if( input.isKeyDown(Input.KEY_LEFT) ){ // Si la variable pressée est flèche gauche alors on déplace le héros à gauche
            x -= 4;
        }
        
        
        // PHASE DE SAUT
        if ( getY() == 570) // Si la position du joueur est en 570 sauter est faux
            sauter = false;
        else                // Si la position du joueut n'est pas en 570 sauter est vrai
            sauter = true;
        
        // Chanager la valeur avant le temps réduit la hauteur du saut.
        if( input.isKeyDown(Input.KEY_UP) && !sauter ){// Si on presse ArrowUp et que sauter est faux le personnage peut sauter
            vitesseVertical = -0.5f * temps;     // Donc on créer une "Vitesse de déplacement" en fonction du temps
            y += vitesseVertical;                // Et la position de notre héros prend la valeur de la vitesse de déplacement
        }
        if ( getY() < 570){
            vitesseVertical += 0.01f * temps; // Même procédé que pour le saut mais fait en sorte de faire tomber le héros tout le temps
            y += vitesseVertical;
            
            if (getY() > 570){                  //Si en tombant le heros sort de la map,
                setY( getY() - (getY() - 570)); // On le replace au bord.
            }
        }
        // A SAVOIR QUE CETTE FONCTION SAUT MARCHE POUR LE MOMENT UNIQUEMENT POUR LE BAS DE LA FENETRE
        // IL ME RESTE A IMPLEMENTER CA POUR QUE CA MARCHE AVEC UNE PLATEFORME UNIVERSELLE
      }

}




    /* A VENIR LES METHODES POUR ATTAQUER... */