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
    
    //Constructeur, par défaut on suppose qu'on est sur la map 0
    public CarteGalaxie() throws SQLException, ClassNotFoundException, SlickException {
        id = 0;
        
        //On crée une variable permettant de faire une requete sql et on récupère les 
        //données concernant la carte
        Requete rq = new Requete();
        ResultSet rs = rq.select("SELECT * FROM CARTEGALAXIE WHERE ID = " +id+ ";");
        
        //On attribue les valeurs récupérées dans la BDD aux attributs
        img = new Image(rs.getString("IMG"));
        nbPlanete = rs.getInt("NBPLANETE");
        
        //On récupère ensuite tous les identifiants des planètes se trouvant sur cette carte
        rs = rq.select("SELECT ID FROM PLANETE WHERE MAP = " +id+ ";");
        
        int idPlanete;
        //Pour chaque enregistrement (ie pour chaque planète se trouvant sur cette carte)
        //On crée une nouvelle planète grace à son identifiant (permettant de récupérer ses infos dans la BDD)
        //et on l'ajoute dans le tableau de planète de la carte
        while (rs.next()) {
            idPlanete = rs.getInt("ID");
            planetes.add(new Planete(idPlanete));
        }
        
        //On ferme la BDD
        rq.closeDB();
    }
    
    //Cf constructeur par défaut
    public CarteGalaxie(int id) throws SQLException, ClassNotFoundException, SlickException {
        this.id = id;
        
        Requete rq = new Requete();
        ResultSet rs = rq.select("SELECT * FROM CARTEGALAXIE WHERE ID = " +this.id+ ";");
        
        img = new Image(rs.getString("IMG"));
        nbPlanete = rs.getInt("NBPLANETE");
        
        rs = rq.select("SELECT ID FROM PLANETE WHERE MAP = " +id+ ";");
        
        int idPlanete;
        while (rs.next()) {
            idPlanete = rs.getInt("ID");
            planetes.add(new Planete(idPlanete));
        }
        rq.closeDB();
    }
    
    //Getters
    public int getId() { return id; };
    public Image getImg() { return img; };
    public int getNbPlanete() { return nbPlanete; };
    
    //Méthode pour afficher
    public void affiche(GameContainer gc, Graphics g) throws SlickException {
        //On affiche l'image de fond
        g.drawImage(img, 0, 0);
        
        //On affiche toutes les planètes par dessus
        for (Planete p : planetes) {
            p.affiche(gc, g);
        }
    }
}
