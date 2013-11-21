package CarteGalaxie;

import BDD.Requete;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Planete {
    private int id; //Identifiant de la planete
    private int idMap; //Identifiant de la map sur laquelle elle se trouve
    private int x; //Position en x de la planete sur la map
    private int y; //Position en y de la planete sur la map
    private Image img; //Chemin d'accès de l'image de la planete
    private int hauteur; //Hauteur de l'image
    private int largeur; //Largeur de l'image
    
    /*
     * Constructeur : On crée une planete en prenant les informations dans la base de donnée
     * Par défaut, on prendra l'id = 0;
     */
    public Planete() throws SQLException, ClassNotFoundException, SlickException {
        id = 0;
        
        Requete rq = new Requete();
        ResultSet rs = rq.select("SELECT * FROM PLANETE WHERE ID = " +id+ ";");
        
        idMap = rs.getInt("MAP");
        x = rs.getInt("X");
        y = rs.getInt("Y");
        img = new Image(rs.getString("IMG"));
        largeur = img.getWidth();
        hauteur = img.getHeight();
        
        rq.closeDB();
    }
    
    public Planete(int id) throws SQLException, ClassNotFoundException, SlickException {
        this.id = id;
        
        Requete rq = new Requete();
        ResultSet rs = rq.select("SELECT * FROM PLANETE WHERE ID = " +id+ ";");
        
        idMap = rs.getInt("MAP");
        x = rs.getInt("X");
        y = rs.getInt("Y");
        img = new Image(rs.getString("IMG"));
        largeur = img.getWidth();
        hauteur = img.getHeight();
        
        rq.closeDB();
    }
    
    public int getId() { return id; }
    public int getIdMap() { return idMap; }
    public int getX() { return x; }
    public int getY() { return y; }
    public Image getImg() { return img; }
    public int getLarg() { return largeur; }
    public int getHaut() { return hauteur; }
    
    public void affiche(GameContainer gc, Graphics g) throws SlickException {
        g.drawImage(img, x, y);
    }
}
