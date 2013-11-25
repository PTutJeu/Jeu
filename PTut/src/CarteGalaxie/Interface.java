package CarteGalaxie;

import BDD.Requete;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Interface {
    private int idPlanete;
    
    public Interface(int id) throws SQLException, ClassNotFoundException {
        idPlanete = id;
        
        Requete rq = new Requete();
        ResultSet rs = rq.select("");
        
        rq.closeDB();
    }
}
