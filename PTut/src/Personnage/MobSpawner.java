

package Personnage;

import CartePlateforme.ListePlateforme;
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
    private int monstrePop = 0;
    private int monstreAlive = 0;
    private int waveNumber = 1;
    
    public MobSpawner() throws SlickException{
       /* try {
            MobList.add(new Monstre(1));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MobSpawner.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    public void affiche (GameContainer gc,Graphics g) throws SlickException {
       for (Monstre m : MobList)
       {
           m.affiche(gc,g);
       }
   }
    public void deplacements (GameContainer gc, int t, ListePlateforme listePlateforme, Heros heros ) {
        Plateforme Plate = listePlateforme.getListe().get(0);
        for (Monstre m : MobList)
        {
            m.deplacements(gc, t , Plate , heros);
        }
    }
    
    public void apparition() throws SlickException, SQLException, ClassNotFoundException
    {
      if (monstrePop < 5 && System.currentTimeMillis()- waveTime > 3000 && waveNumber == 1)
      {
           MobList.add(new Monstre(waveNumber));
           monstrePop++;
           monstreAlive++;
           waveTime = System.currentTimeMillis(); 
      }
      TestWave();
      if (monstrePop < 10 && System.currentTimeMillis()- waveTime > 3000 && waveNumber == 2)
      {
           MobList.add(new Monstre(waveNumber));
           monstrePop++;
           monstreAlive++;
           waveTime = System.currentTimeMillis();
      }
      TestWave();
      if (monstrePop < 13 && System.currentTimeMillis()- waveTime > 3000 && waveNumber == 3)
      {
          MobList.add(new Monstre(waveNumber));
          monstrePop++;
          monstreAlive++;
          waveTime = System.currentTimeMillis();
      }
      TestWave();
      if (monstrePop < 14 && System.currentTimeMillis()- waveTime > 3000 && waveNumber == 4)
      {
          MobList.add(new Monstre(waveNumber));
          monstrePop++;
          monstreAlive++;
          waveTime = System.currentTimeMillis();
      }
    }
    public void TestWave()
    {
        if (monstrePop == 5 && monstreAlive == 0)
        {
            waveNumber = 2;
        }
        if (monstrePop == 10 && monstreAlive == 0)
        {
            waveNumber = 3;
        }           
        if (monstrePop == 13 && monstreAlive == 0)
        {
            waveNumber = 4;
        }
    }
    public void MortMob (Heros heros) {
        for (Monstre m : MobList)
        {
            if (m.getVie() ==0)
            {
                MortList.add(m);
                heros.setXp(heros.getXp()+100);
            }
        }
        for (Monstre m : MortList)
        {
            MobList.remove(m);
            monstreAlive--;
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
