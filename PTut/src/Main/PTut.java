package Main;

import BDD.Requete;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

//Classe main
public class PTut {
    public static void main(String[] args) throws SlickException {
        // /!\Pas très bonnes explication, voir tuto au pire/!\
        //On crée une application qui contiendra le jeu
        AppGameContainer app = new AppGameContainer(new Game());
        app.setDisplayMode(800, 600, false); //Affichage d'une fenetre de 800 pixel par 600 pixel
        app.setTargetFrameRate(60); //On fixe le max fps a 60
        app.setShowFPS(false); //On affiche pas les fps a l'ecran
        app.start(); //On démarre le jeu
        /*try {
            Requete rq = new Requete();
            rq.request("DROP TABLE DETAILS_PLANETE;");
            rq.request("CREATE TABLE DETAILS_PLANETE(ID NUMBER, OXYGENE NUMBER, TEMPERATURE NUMBER, "
                    + "PITEMNEED VARCHAR2(40), DITEMNEED VARCHAR2(40), NOM VARCHAR2(40), POSSEDEE NUMBER, "
                    + "CONSTRAINT PK_DETAILSPLANETE PRIMARY KEY (ID));");
            rq.request("INSERT INTO DETAILS_PLANETE VALUES(0, 23, 25, '', '', 'Cartez', 0);");
            rq.request("INSERT INTO DETAILS_PLANETE VALUES(1, 23, 56, 'Combinaison Refroidissante', '', 'Chalr', 0);");
            rq.request("INSERT INTO DETAILS_PLANETE VALUES(2, 23, -15, 'Combinaison Chauffante', '', 'Fraom', 0);");
            rq.request("INSERT INTO DETAILS_PLANETE VALUES(3, 23, 25, '', '', 'Gorphei', 0);");
            rq.request("INSERT INTO DETAILS_PLANETE VALUES(4, 2, 25, 'Masque à Oxygène', 'Bouteille d''Oxygène', 'Gazos', 0);");
        } catch (SQLException ex) {
            Logger.getLogger(PTut.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PTut.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }
}
