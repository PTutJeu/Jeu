package Armes;

import Personnage.Heros;
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
    
     private List<Projectile> listeProjectile = new ArrayList<>();
     
     public ListeProjectile(){
         
     }
     
     public void affiche(GameContainer gc, Graphics g) throws SlickException {
        for ( Projectile p : listeProjectile)
           {
                p.affiche(gc, g);
           }
    }
     
     public void deplacements(GameContainer gc, Heros heros){
           for ( Projectile p : listeProjectile)
           {
                p.deplacements();
           }
   
    }
    
    public void add(Heros heros) throws SlickException{
        if ( heros.vue==true){
            listeProjectile.add(new Projectile(heros.getX(), heros.getY(), true));
        }
        else if (heros.vue==false){
            listeProjectile.add(new Projectile(heros.getX(), heros.getY(), false));
        }
        
    }
}
