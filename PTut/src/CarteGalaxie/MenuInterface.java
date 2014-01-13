package CarteGalaxie;

import BDD.Requete;
import Personnage.Vaisseau;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

public class MenuInterface {
    private int idPlanete;
    
    private boolean possedee;
    private String nom;
    private float temp;
    private float ox;
    private String itemNeed1;
    private String itemNeed2;
    
    private Image imgFond;
    private Image imgBouton;
    private float xBouton;
    private float yBouton;
    private float xFond;
    private float yFond;
    
    public MenuInterface(int id) throws SQLException, ClassNotFoundException, SlickException {
        this.imgFond = new Image("ressources/images/fondMInterface.jpg");
        idPlanete = id;
        
        Requete rq = new Requete();
        ResultSet rs = rq.select("SELECT * FROM DETAILS_PLANETE WHERE ID = " +id+ ";");
        
        while (rs.next()) {
            if (rs.getInt("POSSEDEE") == 0)
                possedee = false;
            else
                possedee = true;
            nom = rs.getString("NOM");
            temp = rs.getFloat("TEMPERATURE");
            ox = rs.getFloat("OXYGENE");
            itemNeed1 = rs.getString("PITEMNEED");
            itemNeed2 = rs.getString("DITEMNEED");
        }
        
        rq.closeDB();
    }
    
    public void setCoordFond(Vaisseau v) {
        if (v.getX1() < (800-imgFond.getWidth()-20))
            xFond = v.getX1() + 20;
        else
            xFond = v.getX() - imgFond.getWidth() - 20;
        
        if (v.getY() < 600-imgFond.getHeight())
            yFond = v.getY();
        else
            yFond = 600 - imgFond.getHeight();
    }
    
    public void affiche(Graphics g, Vaisseau v) {        
        setCoordFond(v);
        g.drawImage(imgFond, xFond, yFond);
        
        g.drawString(nom, xFond + 10, yFond + 10);
        if (possedee)
            g.drawString("Possédée : Oui", xFond + 10, yFond + 40);
        else
            g.drawString("Possédée : Non", xFond + 10, yFond + 40);
        g.drawString("Température : " +temp+ "°C", xFond + 10, yFond + 60);
        g.drawString("Oxygène : " +ox+ "%", xFond + 10, yFond + 80);
        if (!itemNeed1.isEmpty()) {
            g.drawString("Item nécessaire : ", xFond + 10, yFond + 100);
            g.drawString(itemNeed1, xFond + 20, yFond + 120);
            if (!itemNeed2.isEmpty())
                g.drawString(itemNeed2, xFond + 20, yFond + 140);
        }
        else {
            g.drawString("Item nécessaire :", xFond + 10, yFond + 100);
            g.drawString("Aucun", xFond + 10, yFond + 120);
        }
        g.drawString("Attaquer (A)", xFond + 70, yFond + imgFond.getHeight() - 30);
    }
} 
