
import Carte.Cellule;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

enum ContenuCell { VIDE, PLANETE, INACTIVE };

public class Game extends BasicGame {
    private Cellule c;
    
    public Game() {
        super("Game");
    }
    
    @Override
    public void render(GameContainer gc, Graphics g) {
        
    }
    
    @Override
    public void update(GameContainer gc, int t) {
        
    }
    
    @Override
    public void init(GameContainer gc) {
        c = new Cellule(0, 0, Carte.ContenuCell.PLANETE);
    }
}
