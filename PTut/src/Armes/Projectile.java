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
    protected float x; //Coordonnée en x du projectile
    protected float y; //Coordonnée en y du projectile
    protected float x1; //coordonnée du coin inférieur de l'image
    protected float y1; //coordonnée du coin inférieur de l'image
    private Image img;
    public boolean mvt;
    
    private int idProjectile;
   
    
    public Projectile (float x, float y, boolean mvt) throws SlickException{
        img = new Image("ressources/images/projectile.png");
        this.x=x;
        this.y=y;
        x1 = x + img.getWidth();
        y1 = y + img.getHeight();
        this.mvt=mvt;
    
    }
    
     public void affiche(GameContainer gc, Graphics g) throws SlickException{
        g.drawImage(img, x, y);     
    }

     public void deplacements(){
         if(mvt == false ){           
             x-=10;
         }
         else if (mvt == true){
             x+=10;
         }
     }
     
    public void setX(float x){ this.x=x;}
    public void setY(float y){ this.y=y;}
    
    
    public float getX(){ return x; }
    public float getY(){ return y;}
    public float getX1(){ return x1; }
    public float getY1(){ return y1;}
    
    
}
