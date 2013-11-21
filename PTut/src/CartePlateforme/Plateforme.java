package CartePlateforme;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Tanbi
 */
public class Plateforme {
    private int x; // Coordonnée x de la plateforme
    private int y; // Coordonnée y de la plateforme
    private int x1;
    private int y1;
    
    public Plateforme(){
        
    
    }
    
    public void affiche(GameContainer gc, Graphics g) throws SlickException{
        
       Image img = new Image("ressources/images/vaisseau.png");
    }
    
    
    
    public int getX(){ return x; }
    public int getY(){ return y; }
    public int getX1(){ return x1; }
    public int getY1(){ return y1; }
    
    public void setX(int x){ this.x=x ; }
    public void setY(int y){ this.y=y ; }
    public void setX1(int x1){ this.x1=x1 ; }
    public void setY1(int y1){ this.y1=y1 ; }
    
    
}
