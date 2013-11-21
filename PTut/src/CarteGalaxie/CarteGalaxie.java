package CarteGalaxie;

import BDD.Requete;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class CarteGalaxie {
    private int id; //Identifiant de la carte
    private Image img; //Chemin d'acces de l'image du fond de la carte
    private int nbPlanete; //Nombre de planete se trouvant sur la carte
    private List<Planete> planetes = new ArrayList<>();
    
    public CarteGalaxie() throws SQLException, ClassNotFoundException, SlickException {
        id = 0;
        
        Requete rq = new Requete();
        ResultSet rs = rq.select("SELECT * FROM CARTEGALAXIE WHERE ID = " +id+ ";");
        
        img = new Image(rs.getString("IMG"));
        nbPlanete = rs.getInt("NBPLANETE");
        
        rs = rq.select("SELECT * FROM PLANETE WHERE MAP = " +id+ ";");
        
        int idPlanete;
        while (rs.next()) {
            idPlanete = rs.getInt("ID");
            planetes.add(new Planete(idPlanete));
        }
        rq.closeDB();
    }
    
    public CarteGalaxie(int id) throws SQLException, ClassNotFoundException, SlickException {
        this.id = id;
        
        Requete rq = new Requete();
        ResultSet rs = rq.select("SELECT * FROM CARTEGALAXIE WHERE ID = " +this.id+ ";");
        
        img = new Image(rs.getString("IMG"));
        nbPlanete = rs.getInt("NBPLANETE");
        
        rs = rq.select("SELECT * FROM PLANETE WHERE MAP = " +id+ ";");
        
        int idPlanete;
        while (rs.next()) {
            idPlanete = rs.getInt("ID");
            planetes.add(new Planete(idPlanete));
        }
        rq.closeDB();
    }
    
    public int getId() { return id; };
    public Image getImg() { return img; };
    public int getNbPlanete() { return nbPlanete; };
    
    //Méthode pour afficher
    public void affiche(GameContainer gc, Graphics g) throws SlickException {
        g.drawImage(img, 0, 0);
        
        for (Planete p : planetes) {
            p.affiche(gc, g);
        }
    }
}
