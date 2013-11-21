
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


/**
 *
 * @author Jérôme
 */
public class Menu {
    private int x;
    private int y;
    Image img;
    
    public Menu() throws SlickException
    {
        img = new Image("ressources/images/menu.png");
        x=250;
        y=100;
              
    }
    
    public boolean affiche(GameContainer gc, Graphics g) throws SlickException
    {
        boolean b = false;
        g.drawImage(img, x, y);
        return b;
    }
    
}
    

