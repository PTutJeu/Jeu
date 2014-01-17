/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CartePlateforme;

import BDD.Requete;
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
 * @author Tanbi
 */
public class ListePlateforme {
    
    private List<Plateforme> listePlateforme = new ArrayList<>();
    
    public ListePlateforme(int idPlanete) throws SQLException, ClassNotFoundException {
        Requete rq = new Requete();
        ResultSet rs = rq.select("SELECT ID FROM PLATEFORME WHERE IDPLANETE = " +idPlanete+ ";");
        
        while (rs.next()) {
            try {
                listePlateforme.add(new Plateforme(rs.getInt("ID")));
            } catch (SlickException ex) {
                Logger.getLogger(ListePlateforme.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        rq.closeDB();
    }
    
    public void affiche(GameContainer gc, Graphics g) throws SlickException {
        for ( Plateforme p : listePlateforme)
           {
                p.affiche(gc, g);
           }
    }
    
    public List<Plateforme> getListe() { return listePlateforme; }
}
