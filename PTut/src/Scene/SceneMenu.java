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
    private int x;
    private int y;
    private Image img;
    private boolean b;
    
    public SceneMenu() throws SlickException
    {
        super();
        setPriority(2);
        img = new Image("ressources/images/menu.jpg");
        x=250;
        y=100;
        b = false;
    }
    
    public void affiche(GameContainer gc, Graphics g) throws SlickException
    {           
            g.drawImage(img, x, y);        
    }
    
    public void testAffiche(Input input, GameContainer gc) {
        if (input.isKeyPressed(Input.KEY_ESCAPE)){
            b = !b;
        }
        if (b) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                if (input.getMouseX() > 300 && input.getMouseX() < 500 && input.getMouseY() > 150 && input.getMouseY() < 250)
                    b = false;
                if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
                    if (input.getMouseX() > 0 && input.getMouseX() < 20 && input.getMouseY() > 0 && input.getMouseY() < 20)
                        gc.isFullscreen();
                }
            }
        }
        
 }
    @Override
   	protected void CustomRender(GameContainer gc, Graphics g) throws SlickException 
	{
		affiche(gc, g);
	}
	
        protected void CustomUpdate(GameContainer gc, int t,Input input) throws SlickException 
	{
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                if (input.getMouseX() > 300 && input.getMouseX() < 500 && input.getMouseY() > 150 && input.getMouseY() < 250)   
                    Main.Game.manager.removeSence(this);
                if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
                    if (input.getMouseX() > 300 && input.getMouseX() < 500 && input.getMouseY() > 300 && input.getMouseY() < 400)
                        Main.Game.manager.addSence(new SceneMenuPrincipal());
                }
            }
           if(gc.getInput().isKeyPressed(Input.KEY_ESCAPE))
           {
               //Main.Game.manager.removeSence(this);
               setState(STATE.FREEZE);
               Main.Game.manager.getSence("Galaxie").setState(STATE.ON);
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
    

