package CartePlateforme;

import BDD.Requete;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Tanbi
 */
public class Plateforme {
    private float x; // Coordonnée x de la plateforme
    private float y; // Coordonnée y de la plateforme
    private float x1;
    private float y1;
    private Image img;
    private boolean mobile;
    
    public Plateforme(int id) throws SlickException, SQLException, ClassNotFoundException {
        Requete rq = new Requete();
        ResultSet rs = rq.select("SELECT * FROM PLATEFORME WHERE ID = " +id+ ";");
        
        x = rs.getFloat("X");
        y = rs.getFloat("Y");
        img = new Image(rs.getString("IMG"));
        x1 = x + img.getWidth();
        y1 = y + img.getHeight();
        if (rs.getInt("MOBILE") == 1)
            mobile = true;
        else
            mobile = false;
        
        rq.closeDB();
    }
    
    public void affiche(GameContainer gc, Graphics g) throws SlickException{
        g.drawImage(img, x, y);     
    }

    
    public float getX(){ return x; }
    public float getY(){ return y; }
    public float getX1(){ return x1; }
    public float getY1(){ return y1; }
    public Image getImg(){return img;}
    public boolean isMobile() { return mobile; }
    
    
    public void setX(int x){ this.x=x ; }
    public void setY(int y){ this.y=y ; }
    public void setX1(int x1){ this.x1=x1 ; }
    public void setY1(int y1){ this.y1=y1 ; }
    
    
}
