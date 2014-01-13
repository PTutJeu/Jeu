package Main;

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
        app.setIcons(new String[] {"ressources/images/icone16.png", "ressources/images/icone32.png"});
        app.start(); //On démarre le jeu
        /*try {
            Requete rq = new Requete();
            rq.request("DROP TABLE PLANETE;");
            rq.request("CREATE TABLE PLANETE(ID NUMBER, MAP NUMBER, X NUMBER, Y NUMBER, "
                    + "IMG VARCHAR2(40), "
                    + "CONSTRAINT PK_PLANETE PRIMARY KEY (ID), "
                    + "CONSTRAINT FK_PLANETE FOREIGN KEY (MAP) REFERENCES CARTE_GALAXIE(ID));");
            rq.request("INSERT INTO PLANETE VALUES(0, 0, 50, 50, 'ressources/images/p0.png');");
            rq.request("INSERT INTO PLANETE VALUES(1, 0, 200, 10, 'ressources/images/p1.png');");
            rq.request("INSERT INTO PLANETE VALUES(2, 0, 600, 100, 'ressources/images/p2.png');");
            rq.request("INSERT INTO PLANETE VALUES(3, 0, 300, 400, 'ressources/images/p3.png');");
            rq.request("INSERT INTO PLANETE VALUES(4, 0, 10, 500, 'ressources/images/p4.png');");
        } catch (SQLException ex) {
            Logger.getLogger(PTut.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PTut.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }
}
