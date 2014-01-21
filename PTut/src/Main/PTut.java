package Main;

import BDD.Requete;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

//Classe main
public class PTut {
    public static void main(String[] args) throws SlickException, SQLException {
        // /!\Pas très bonnes explication, voir tuto au pire/!\
        //On crée une application qui contiendra le jeu
        AppGameContainer app = new AppGameContainer(new Game());
        //app.setMouseGrabbed(true);
        app.setDisplayMode(800, 600, false); //Affichage d'une fenetre de 800 pixel par 600 pixel
        app.setTargetFrameRate(60); //On fixe le max fps a 60
        app.setShowFPS(false); //On affiche pas les fps a l'ecran
        app.setIcons(new String[] {"ressources/images/icone16.png", "ressources/images/icone32.png"});
        app.start(); //On démarre le jeu        
    }
}
