package Scene;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


/**
 *
 * @author Jérôme
 */
public class SceneMenu extends Scene 
{
    private static int xFond = 250;
    private static int yFond = 100;
    private static int xReprendre = 299;
    private static int yReprendre = 250;
    private static int xQuit = 299;
    private static int yQuit = 320;
    private Image fond;
    private Image btnReprendre;
    private Image btnQuit;
    
    public SceneMenu() throws SlickException
    {
        super();
        setPriority(2);
        fond = new Image("ressources/images/menu.png");
        btnReprendre = new Image("ressources/images/btnReprendre.png");
        btnQuit = new Image("ressources/images/btnQuit.png");
    }
        
    @Override
    protected void CustomRender(GameContainer gc, Graphics g) throws SlickException {
        g.drawImage(fond, xFond, yFond);
        g.drawImage(btnReprendre, xReprendre, yReprendre);
        g.drawImage(btnQuit, xQuit, yQuit);
    }
	
    @Override
    protected void CustomUpdate(GameContainer gc, int t) throws SlickException 
    {
        if (gc.getInput().getMouseX() > xReprendre && gc.getInput().getMouseX() < xReprendre+btnReprendre.getWidth() && gc.getInput().getMouseY() > yReprendre && gc.getInput().getMouseY() < yReprendre+btnReprendre.getHeight())
        {
            btnReprendre = new Image("ressources/images/btnReprendre_hover.png");
            btnQuit = new Image("ressources/images/btnQuit.png");
            if (gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                Main.Game.manager.removeSence(this);
                if(Main.Game.manager.getSence("Planète") != null)
                {
                     Main.Game.manager.getSence("Planète").setState(STATE.ON);
                }
                else
                    Main.Game.manager.getSence("Galaxie").setState(STATE.ON);
            }
        }
        else if (gc.getInput().getMouseX() > xQuit && gc.getInput().getMouseX() < xQuit+btnQuit.getWidth() && gc.getInput().getMouseY() > yQuit && gc.getInput().getMouseY() < yQuit+btnQuit.getHeight())
        {
            btnReprendre = new Image("ressources/images/btnReprendre.png");
            btnQuit = new Image("ressources/images/btnQuit_hover.png");
            if (gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                Main.Game.manager.removeAll();
                Main.Game.manager.addSence(new SceneMenuPrincipal());

            }
        }
        else {
            btnReprendre = new Image("ressources/images/btnReprendre.png");
            btnQuit = new Image("ressources/images/btnQuit.png");
        }
        if(gc.getInput().isKeyPressed(Input.KEY_R))
        {
            Main.Game.manager.removeSence(this);
            if(Main.Game.manager.getSence("Planète") != null)
            {
                 Main.Game.manager.getSence("Planète").setState(STATE.ON);
            }
            else
                 Main.Game.manager.getSence("Galaxie").setState(STATE.ON);

        }
        if(gc.getInput().isKeyPressed(Input.KEY_M))
        {
            Main.Game.manager.removeAll();
            Main.Game.manager.addSence(new SceneMenuPrincipal());
        }
    }
	
    @Override
    public void init(GameContainer gc) throws SlickException 
    {

    }
	
    @Override
    public String toString()
    {
        return "Menu";
    }
}
    

