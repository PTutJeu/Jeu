package Armes;

import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Tanbi
 */
public class ListeProjectile {
    
     private List<Projectile> projectile = new ArrayList<>();
     
     public ListeProjectile(){
         
     }
     
     public void affiche(GameContainer gc, Graphics g) throws SlickException {
        for ( Projectile p : projectile)
           {
                p.affiche(gc, g);
           }
    }
     
     public void deplacements(GameContainer gc)
    {
        for ( Projectile p : projectile)
           {
                p.deplacements();
           }
    }
    
    public void add() throws SlickException{
        projectile.add(new Projectile());
    }
}
