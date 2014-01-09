package Armes;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import Personnage.Heros;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Tanbi
 */
public class Projectile {
    protected float x; //Coordonnée en x du héros
    protected float y; //Coordonnée en y du héros
    protected float x1; //coordonnée du coin inférieur de l'image
    protected float y1; //coordonnée du coin inférieur de l'image
    private Image img;
    
    private int idProjectile;
   
    
    public Projectile () throws SlickException{
        img = new Image("ressources/images/projectile.png");
        this.x=0;
        this.y=0;
        x1 = x + img.getWidth();
        y1 = y + img.getHeight();
    
    }
    
     public void affiche(GameContainer gc, Graphics g) throws SlickException{
        g.drawImage(img, x, y);     
    }
     
     public void deplacements(){
         x+=4;
     }
     
    public void setX(float x){ this.x=x;}
    public void setY(float y){ this.y=y;}
}
