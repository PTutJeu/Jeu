package CarteGalaxie;

import BDD.Requete;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Teleporteur {
    private int id;
    private int idMap;
    private int idMapDest;
    private int x;
    private int y;
    private int xDest;
    private int yDest;
    private Image img;
    
    public Teleporteur(int id) throws SQLException, ClassNotFoundException, SlickException {
        this.id = id;
        img = new Image("ressources/images/teleporteur.png");
        
        Requete rq = new Requete();
        ResultSet rs = rq.select("SELECT * FROM TELEPORTEUR WHERE ID = " +this.id+ ";");
        
        idMap = rs.getInt("IDMAP");
        idMapDest = rs.getInt("IDMAPDEST");
        x = rs.getInt("X");
        y = rs.getInt("Y");
        xDest = rs.getInt("XDEST");
        yDest = rs.getInt("YDEST");
        
        rq.closeDB();
    }
    
    public int getId() { return id; }
    public int getIdMap() { return idMap; }
    public int getIdMapDest() { return idMapDest; }
    public int getX() { return x; }
    public int getX1() { return x + img.getWidth(); }
    public int getY() { return y; }
    public int getY1() { return y + img.getHeight(); }
    public int getXDest() { return xDest; }
    public int getYDest() { return yDest; }
    public Image getImg() { return img; }
    
    public void affiche(Graphics g) {
        g.drawImage(img, x, y);
    }
}
