

package Personnage;

import CartePlateforme.Plateforme;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author wazaa
 */
public class MobSpawner {
    
    private List<Monstre> MobList = new ArrayList<>();
    private int nbMonstrePop;
    private int nbMonstreEnVie; 
    private long time;
    public MobSpawner() {
        nbMonstrePop = 0;
        nbMonstreEnVie = 0;
        time = System.currentTimeMillis();
    }
    
    public void apparition() throws SlickException {
         if (nbMonstrePop <= 2 && System.currentTimeMillis() - this.time > 5000 ) // 1Ere vague!
        {  
            MobList.add(new Monstre(100));
            nbMonstrePop++ ;
            nbMonstreEnVie++;
            time = System.currentTimeMillis();
        }
         else if (nbMonstrePop <= 15 && System.currentTimeMillis() - this.time > 5000 && nbMonstreEnVie == 0)//2Eme vague Conditions à revoir!!!
        { 
            MobList.add(new Monstre(100));
            nbMonstrePop++ ;
            nbMonstreEnVie++;
            time = System.currentTimeMillis();
        }
         else if (nbMonstrePop <= 20 && System.currentTimeMillis() - this.time > 5000)
        {
            MobList.add(new Monstre(200));
            nbMonstrePop++ ;
            nbMonstreEnVie++;
            time = System.currentTimeMillis();
        }
         else if (nbMonstrePop <= 25 && System.currentTimeMillis() - this.time > 5000 && nbMonstreEnVie == 0)// 3Eme vague Conditions à revoir!!!
        {
            MobList.add(new Monstre(200));
            nbMonstrePop++ ;
            nbMonstreEnVie++;
            time = System.currentTimeMillis();
        }
         else if (nbMonstrePop <= 30 && System.currentTimeMillis() - this.time > 5000 && nbMonstreEnVie == 0)// 3Eme vague Conditions à revoir!!!
        {
            MobList.add(new Monstre(300));
            nbMonstrePop++ ;
            nbMonstreEnVie++;
            time = System.currentTimeMillis();
        }

        }
    
   public void MortMob ()
    {
     Monstre mob = null;
     for (Monstre m : MobList)
     {
            if (m.getVie() <= 0)
                MobList.remove(MobList.indexOf(m));
        /* if (m.getVie() <= 0)
             mob = m;
         else 
             mob = null;
         
         if (mob != null)
             MobList.remove(MobList.indexOf(mob));*/
     }
            
    }
    public void affiche (GameContainer gc, Graphics g) throws SlickException
    {
           for ( Monstre m : MobList)
           {
                m.affiche(gc, g);
           }
       
       
    }
            
    public void déplacements(GameContainer gc, int temps, Plateforme plate,Heros heros)
    {
        for ( Monstre m : MobList)
           {
                m.déplacements(gc, (int) time,plate,heros);
           }
    }

    // Getters
    public List<Monstre> getMobList() {return MobList; }
    public int getNbMonstrePop() {return nbMonstrePop; }
    public int getNbMonstreEnVie() {return nbMonstreEnVie;}
    public long getTime() {return time;}
    
    
}
