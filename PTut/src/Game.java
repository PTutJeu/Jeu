
import Carte.Cellule;
import Carte.ContenuCellule;
import Carte.CoordonneeException;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Game extends BasicGame {
    private Cellule c;
    
    public Game() {
        super("Game");
    }
    
    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        c.affiche(gc, g);
    }
    
    @Override
    public void update(GameContainer gc, int t) {
        
    }
    
    @Override
    public void init(GameContainer gc) {
        try {
            c = new Cellule(0, 0, ContenuCellule.PLANETE);
        } catch (CoordonneeException ex) {
            ex.printStackTrace();
        }
    }
}
