
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
    private Image img;
    private boolean b;
    
    public Menu() throws SlickException
    {
        img = new Image("ressources/images/menu.png");
        x=250;
        y=100;
        b = false;
    }
    
    public void affiche(GameContainer gc, Graphics g) throws SlickException
    {
        if(b==true)            
            g.drawImage(img, x, y);
        
    }
    
    public void testAffiche(Input input) {
        if (input.isKeyPressed(Input.KEY_ESCAPE))
            b = !b;
        if (b) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                if (input.getMouseX() > 300 && input.getMouseX() < 500 && input.getMouseY() > 150 && input.getMouseY() < 250)
                    b = false;
            }
        }
    }
}
    

