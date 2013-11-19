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
    private String caImg; //Chemin d'acces de l'image du fond de la carte
    private int nbPlanete; //Nombre de planete se trouvant sur la carte
    private List<Planete> planetes = new ArrayList<>();
    
    public CarteGalaxie() throws SQLException, ClassNotFoundException {
        id = 0;
        
        Requete rq = new Requete();
        ResultSet rs = rq.select("SELECT * FROM CARTEGALAXIE WHERE ID = " +id+ ";");
        
        caImg = rs.getString("IMG");
        nbPlanete = rs.getInt("NBPLANETE");
        
        rs = rq.select("SELECT * FROM PLANETE WHERE MAP = " +id+ ";");
        rq.closeDB();
        
        int idPlanete;
        while (rs.next()) {
            idPlanete = rs.getInt("ID");
            planetes.add(new Planete(idPlanete));
        }
    }
    
    public CarteGalaxie(int id) throws SQLException, ClassNotFoundException {
        this.id = id;
        
        Requete rq = new Requete();
        ResultSet rs = rq.select("SELECT * FROM CARTEGALAXIE WHERE ID = " +id+ ";");
        
        caImg = rs.getString("IMG");
        nbPlanete = rs.getInt("NBPLANETE");
        
        rs = rq.select("SELECT * FROM PLANETE WHERE MAP = " +id+ ";");
        rq.closeDB();
        
        int idPlanete;
        while (rs.next()) {
            idPlanete = rs.getInt("ID");
            planetes.add(new Planete(idPlanete));
        }
    }
    
    public int getId() { return id; };
    public String getCAImg() { return caImg; };
    public int getNbPlanete() { return nbPlanete; };
    
    //Méthode pour afficher
    public void affiche(GameContainer gc, Graphics g) throws SlickException {
        Image img = new Image(caImg);
        g.drawImage(img, 0, 0);
        
        for (Planete p : planetes) {
            p.affiche(gc, g);
        }
    }
}
