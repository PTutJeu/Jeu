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
    private boolean posseder;
    private String nom;
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
        /*ResultSet rs = rq.select("SELECT * FROM DETAILS_PLANETE WHERE ID = " +id+ ";");
        
        if (rs.getInt("POSSEDER") == 0)
            posseder = true;
        else
            posseder = false;
        nom = rs.getString("NOM");*/
        
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
        
        Font f = new Font("Verdana", Font.BOLD, 32);
        TrueTypeFont ttf = new TrueTypeFont(f, true);
        g.drawString("Test", xFond + 10, yFond + 10);
        //if (posseder)
            g.drawString("Possédée : Oui", xFond + 10, yFond + 40);
        //else
            //g.drawString("Possédée : Non", xFond + 10, yFond + 40);
        g.drawString("Température : ", xFond + 10, yFond + 60);
        g.drawString("Oxygène : ", xFond + 10, yFond + 80);
        g.drawString("Attaquer (A)", xFond + 70, yFond + imgFond.getHeight() - 30);
    }
} 
