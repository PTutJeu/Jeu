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
    
    private float goldProd;
    private float boisProd;
    private float metalProd;
    private int goldMax;
    private int boisMax;
    private int metalMax;
    private int goldAct;
    private int boisAct;
    private int metalAct;
    
    private Image imgFond;
    private float xFond;
    private float yFond;
    
    public MenuInterface(int id) throws SQLException, ClassNotFoundException, SlickException {
        this.imgFond = new Image("ressources/images/menuPlanete.png");
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
            goldMax = rs.getInt("GOLDMAX");
            boisMax = rs.getInt("BOISMAX");
            metalMax = rs.getInt("METALMAX");
            goldProd = rs.getFloat("GOLDPROD");
            boisProd = rs.getFloat("BOISPROD");
            metalProd = rs.getFloat("METALPROD");
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
    
    public void affiche(Graphics g, Vaisseau v) throws SlickException {        
        setCoordFond(v);
        g.drawImage(imgFond, xFond, yFond);
        
        g.drawString(nom, xFond + 10, yFond + 10);
        
        if (!possedee) {
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
        else {
            Image or = new Image("ressources/images/icone_or.png");
            Image bois = new Image("ressources/images/icone_bois.png");
            Image metal = new Image("ressources/images/icone_metal.png");
            g.drawString("Production :", xFond + 10, yFond + 35);
            g.drawImage(or, xFond + 15, yFond + 52);
            g.drawImage(bois, xFond + 15, yFond + 69);
            g.drawImage(metal, xFond + 15, yFond + 86);
            g.drawString(goldProd+" or/minute", xFond + 40, yFond + 52);
            g.drawString(boisProd+" bois/minute", xFond + 40, yFond + 69);
            g.drawString(metalProd+" metal/minute", xFond + 40, yFond + 86);
            g.drawString("Production maximale :", xFond + 10, yFond + 106);
            g.drawImage(or, xFond + 15, yFond + 123);
            g.drawImage(bois, xFond + 15, yFond + 140);
            g.drawImage(metal, xFond + 15, yFond + 157);
            g.drawString(""+goldMax, xFond + 40, yFond + 123);
            g.drawString(""+boisMax, xFond + 40, yFond + 140);
            g.drawString(""+metalMax, xFond + 40, yFond + 157);
            g.drawString("Production actuelle :", xFond + 10, yFond + 177);
            g.drawImage(or, xFond + 15, yFond + 194);
            g.drawImage(bois, xFond + 15, yFond + 211);
            g.drawImage(metal, xFond + 15, yFond + 228);
            g.drawString(""+goldAct, xFond + 40, yFond + 194);
            g.drawString(""+boisAct, xFond + 40, yFond + 211);
            g.drawString(""+metalAct, xFond + 40, yFond + 228);
            g.drawString("Collecter (C)", xFond + 70, yFond + imgFond.getHeight() - 30);
        }
    }
} 
