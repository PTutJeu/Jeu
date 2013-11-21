

import CarteGalaxie.CarteGalaxie;
import CarteGalaxie.Planete;
import CartePlateforme.Plateforme;
import Personnage.Vaisseau;
import Personnage.Heros;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/*
 * J'ai un peu du mal à expliquer l'utilité de cette classe mais c'est la plus importante et elle 
 * concerne tout le monde ! C'est la qu'on va gérer la distinction entre carte et plateforme (enfin
 * je crois, si j'ai bien compris le tuto)
 */
public class Game extends BasicGame {
    private CarteGalaxie c; //Variable qui sert juste à tester, non définitive
    private Vaisseau v;
    private Heros heros;
    private Menu menu;
    private Plateforme plate;
    //Constructeur : on initialise en donnant le nom de la fenêtre (à changer)
    public Game() {
        super("Game");
    }
    
    @Override
    /*
     * Méthode qui sert à afficher tout ce qu'il y a besoin d'afficher
     * De même ici le contenu de la fonction est un test, rien à voir avec le code définitif
     */
    public void render(GameContainer gc, Graphics g) throws SlickException {
        boolean b = false;
        Input input = gc.getInput();
        c.affiche(gc, g);
        v.affiche(gc, g);
        heros.affiche(gc, g);
        plate.affiche(gc,g);
        if(input.isKeyDown(Input.KEY_ESCAPE))
        {
            b = true;
        }
        if(b == true)
        {
            boolean c = menu.affiche(gc,g);
        }
            
            
    }
    
    @Override
    /*
     * Méthode qui sert à récupérer les évènements générés par l'utilisateur, et à modifié les
     * éléments à afficher
     * Idem, c'est pour tester
     */
    public void update(GameContainer gc, int t) {
        v.deplace(gc);
        heros.déplacements(gc, t, plate);
    }
    
    @Override
    /*
     * Méthode qui sert à initialiser tous les attributs, ça remplace le constructeur en
     * quelque sorte (enfin pas vraiment mais je veux dire qu'on met à peu près la même
     * chose ici que dans un constructeur)
     * De même que les autres fonction, c'est juste un test pour le moment
     */
    public void init(GameContainer gc) throws SlickException {
        try {
            c = new CarteGalaxie();
            heros = new Heros();
            v = new Vaisseau();
            menu = new Menu();
            plate = new Plateforme();
        } catch (SQLException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
