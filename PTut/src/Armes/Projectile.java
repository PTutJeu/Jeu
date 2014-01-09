package Armes;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import Personnage.Heros;

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
    
    public Projectile (float x,float y) throws SlickException{
        img = new Image("ressources/images/projectile.png");
        this.x=x;
        this.y=y;
        x1 = x + img.getWidth();
        y1 = y + img.getHeight();
    
    }
    
     public void affiche(GameContainer gc, Graphics g) throws SlickException{
        g.drawImage(img, x, y);     
    }
     
     public void deplacements (){
         x +=4;
     }
}
