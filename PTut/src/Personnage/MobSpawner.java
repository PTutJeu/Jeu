

package Personnage;

import BDD.Requete;
import CartePlateforme.ListePlateforme;
import CartePlateforme.Plateforme;
import Personnage.Monstre;
import java.sql.ResultSet;
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
    private int maxWave;
    private int nbMobWave;
    private int idPlanete;
    private int idMobAPop = 1;
    
    public MobSpawner(int idPlanete) throws SlickException{
        try {
            this.idPlanete = idPlanete;
            Requete rq = new Requete();
            ResultSet rs = rq.select("SELECT MAX(IDWAVE) FROM CORRESPPLANETEMOB WHERE IDPLANETE = " +idPlanete+ ";");
            
            maxWave = rs.getInt("MAX(IDWAVE)");
            
            rq.closeDB();
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
    public void deplacements (GameContainer gc, int t, ListePlateforme listePlateforme, Heros heros ) {
        Plateforme Plate = listePlateforme.getListe().get(0);
        for (Monstre m : MobList)
        {
            m.deplacements(gc, t , listePlateforme , heros);
        }
    }
    
    public boolean apparition() throws SlickException, SQLException, ClassNotFoundException
    {
        //System.out.println(waveNumber+"");
        if (waveNumber <= maxWave) {
            if (monstrePop == 0)
                initWave();

            if (monstrePop < nbMobWave) {
                if (System.currentTimeMillis()- waveTime > 3000)
                {
                     MobList.add(new Monstre(idMobAPop));
                     monstrePop++;
                     monstreAlive++;
                     waveTime = System.currentTimeMillis(); 
                }
            }

            if (monstreAlive == 0 && monstrePop == nbMobWave) {
                monstrePop = 0;
                waveNumber++;
            }
            return true;
        }
        else return false;
      /*if (monstrePop < 5 && System.currentTimeMillis()- waveTime > 3000 && waveNumber == 1)
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
      }*/
    }
    
    public void initWave() {
        try {
            Requete rq = new Requete();
            ResultSet rs = rq.select("SELECT ID FROM CORRESPPLANETEMOB WHERE IDPLANETE = "
                    +idPlanete+ " AND IDWAVE = " +waveNumber+ ";");
            
            int id = 1;
            while (rs.next()) id = rs.getInt("ID");
            rs = rq.select("SELECT * FROM CORRESPPLANETEMOB WHERE ID = " +id+ ";");
            
            nbMobWave = rs.getInt("TAILLEWAVE");
            idMobAPop = rs.getInt("IDMOB");
            
            rq.closeDB();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MobSpawner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*public void TestWave()
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
    }*/
    public void MortMob (Heros heros) {
        for (Monstre m : MobList)
        {
            if (m.getVie() ==0)
            {
                MortList.add(m);
                heros.setXp(heros.getXp()+50);
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
