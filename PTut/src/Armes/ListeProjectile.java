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
     private List<Projectile> suppression = new ArrayList<>();
     
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
    
    public void collisions () {
        // Pour gérer les collisions en dehors de l'écran et donc supprimer un projectile lorsqu'il
        // dépasse les limites de l'écran, il faut rechercher dans l'ArrayList des projectiles,
        // le ou les projectiles qui sont en dehors des limites, et ensuite ajouter ces projectiles
        // à une ArrayList de suppression, puisqu'il ne faut pas modifier une ArrayList et la
        // Manipuler en même temps ( sinon le programme plante ).
        for ( Projectile p : listeProjectile)
           {
               if(p.getX() >= 800 || p.getX() <=0 ){
                   suppression.add(p); //Ajout des projectiles à supprimer a l'Array de suppression
               }
               
        //System.out.println(listeProjectile.size());
           }
        // Suppression des projectiles contenu dans l'Array de suppression
        for ( Projectile p : suppression){
            listeProjectile.remove(p);
        }
        suppression.clear();
    }
}
