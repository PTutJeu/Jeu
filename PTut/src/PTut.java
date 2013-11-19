
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
        /*AppGameContainer app = new AppGameContainer(new Game());
        app.setDisplayMode(800, 600, false); //Affichage d'une fenetre de 1000 pixel par 600 pixel
        app.setTargetFrameRate(60); //On fixe le max fps a 60
        app.setShowFPS(false); //On affiche pas les fps a l'ecran
        app.start(); //On démarre le jeu*/
        try {
            Requete rq = new Requete();
            rq.request("CREATE TABLE CARTEGALAXIE(ID NUMBER, IMG VARCHAR2(40), NBPLANETE NUMBER, "
                    + "CONSTRAINT PK_CARTEGALAXIE PRIMARY KEY (ID));");
            rq.closeDB();
        } catch (SQLException ex) {
            Logger.getLogger(PTut.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PTut.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
