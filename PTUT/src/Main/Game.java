package Main;



import Scene.SceneManager;
import Scene.SceneMenuPrincipal;
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

    
    public static SceneManager manager;
    //Constructeur : on initialise en donnant le nom de la fenêtre (à changer)
    public Game() {
        super("Galaxy Conquest");
    }
    
    @Override
    /*
     * Méthode qui sert à afficher tout ce qu'il y a besoin d'afficher
     * De même ici le contenu de la fonction est un test, rien à voir avec le code définitif
     */
    public void render(GameContainer gc, Graphics g) throws SlickException {
        manager.render(gc, g);
    }
    
        /*
     * Méthode qui sert à récupérer les évènements générés par l'utilisateur, et à modifié les
     * éléments à afficher
     * Idem, c'est pour tester
     */
    @Override
    public void update(GameContainer gc, int t) throws SlickException {
        manager.update(gc, t);
    }
    
    @Override
    /*
     * Méthode qui sert à initialiser tous les attributs, ça remplace le constructeur en
     * quelque sorte (enfin pas vraiment mais je veux dire qu'on met à peu près la même
     * chose ici que dans un constructeur)
     * De même que les autres fonction, c'est juste un test pour le moment
     */
    public void init(GameContainer gc) throws SlickException {
     		manager = new SceneManager(gc);
		manager.addSence( new SceneMenuPrincipal() );
    }

    /**
     *
     * @param gc
     * @param i
     * @throws SlickException
     */

}
