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
    private static int xFond = 267;
    private static int yFond = 137;
    private static int xReprendre = 300;
    private static int yReprendre = 290;
    private static int xQuit = 319;
    private static int yQuit = 340;
    private Image fond;
    private Image btnReprendre;
    private Image btnQuit;
    
    public SceneMenu() throws SlickException
    {
        super();
        setPriority(2);
        fond = new Image("ressources/menuEchap/menuEchap.png");
        btnReprendre = new Image("ressources/menuEchap/reprendreNeutre.png");
        btnQuit = new Image("ressources/menuEchap/menuPrincipalNeutre.png");
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
            btnReprendre = new Image("ressources/menuEchap/reprendreSelect.png");
            btnQuit = new Image("ressources/menuEchap/menuPrincipalNeutre.png");
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
            btnReprendre = new Image("ressources/menuEchap/reprendreNeutre.png");
            btnQuit = new Image("ressources/menuEchap/menuPrincipalSelect.png");
            if (gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                Main.Game.manager.removeAll();
                Main.Game.manager.addSence(new SceneMenuPrincipal());

            }
        }
        else {
            btnReprendre = new Image("ressources/menuEchap/reprendreNeutre.png");
            btnQuit = new Image("ressources/menuEchap/menuPrincipalNeutre.png");
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
    

