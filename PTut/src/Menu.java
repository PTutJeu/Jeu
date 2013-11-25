
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
    
    public void affiche(GameContainer gc, Graphics g, boolean b) throws SlickException
    {
        if(b==true)            
            g.drawImage(img, x, y);
        
    }
    public boolean reprendrePartie(boolean b, Input input)
    {
        x = input.getMouseX();
        y = input.getMouseY();
        if(b==true)
        {
            if(x>300  && x<500  && y>150  && y<250)
            {
                b=false;
            }
        }
        return b;
    }
    
}
    

