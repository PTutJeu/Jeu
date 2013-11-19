

import CarteGalaxie.CarteGalaxie;
import Personnage.Vaisseau;
import Personnage.Heros;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
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
        c.affiche(gc, g);
        v.affiche(gc, g);
    //    heros.affiche(gc, g);
    }
    
    @Override
    /*
     * Méthode qui sert à récupérer les évènements générés par l'utilisateur, et à modifié les
     * éléments à afficher
     * Idem, c'est pour tester
     */
    public void update(GameContainer gc, int t) {
        //heros.déplacements(gc);
        v.deplace(gc);
    }
    
    @Override
    /*
     * Méthode qui sert à initialiser tous les attributs, ça remplace le constructeur en
     * quelque sorte (enfin pas vraiment mais je veux dire qu'on met à peu près la même
     * chose ici que dans un constructeur)
     * De même que les autres fonction, c'est juste un test pour le moment
     */
    public void init(GameContainer gc) {
        c = new CarteGalaxie();
        v= new Vaisseau();
        //heros = new Heros();
    }
}
