

package Personnage;

import CartePlateforme.Plateforme;
import Personnage.Monstre;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author wazaa
 */
public class MobSpawner {
    private List<Monstre> MobList = new ArrayList<>();
    private List<Monstre> MortList = new ArrayList<>();
    private long waveTime = System.currentTimeMillis();
    public MobSpawner() throws SlickException{
        try {
            MobList.add(new Monstre(1));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MobSpawner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void affiche (GameContainer gc,Graphics g) throws SlickException {
       for (Monstre m : MobList)
       {
           m.affiche(gc,g);
       }
   }
    public void deplacements (GameContainer gc, int t, Plateforme Plate, Heros heros ){
        for (Monstre m : MobList)
       {
           m.deplacements(gc, t , Plate , heros);
       }
   }
    
    /*public void apparition()
    {
        
    }*/
    
    public void MortMob () {
        for (Monstre m : MobList)
        {
            if (m.getVie() <=0)
            {
                MortList.add(m);
            }
        }
        for (Monstre m : MortList)
        {
            MobList.remove(m);
        }
        MortList.clear();
    }

    public List<Monstre> getMobList() {
        return MobList;
    }

    public List<Monstre> getMortList() {
        return MortList;
    }

    public long getWaveTime() {
        return waveTime;
    }
    
}
