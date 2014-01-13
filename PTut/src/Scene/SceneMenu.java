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
    
    public SceneMenu() throws SlickException
    {
        super();
        setPriority(2);
        img = new Image("ressources/images/menu.jpg");
        x=250;
        y=100;
    }
    
    public void affiche(GameContainer gc, Graphics g) throws SlickException
    {           
            g.drawImage(img, x, y);        
    }
        

    @Override
   	protected void CustomRender(GameContainer gc, Graphics g) throws SlickException 
	{
		affiche(gc, g);
	}
	
    @Override
        protected void CustomUpdate(GameContainer gc, int t) throws SlickException 
	{
            if (gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                if (gc.getInput().getMouseX() > 300 && gc.getInput().getMouseX() < 500 && gc.getInput().getMouseY() > 150 && gc.getInput().getMouseY() < 250)   
                    Main.Game.manager.removeSence(this);
                if (gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)){
                    if (gc.getInput().getMouseX() > 300 && gc.getInput().getMouseX() < 500 && gc.getInput().getMouseY() > 300 && gc.getInput().getMouseY() < 400)
                        Main.Game.manager.addSence(new SceneMenuPrincipal());
                }
            }
           if(gc.getInput().isKeyPressed(Input.KEY_ESCAPE))
           {
               Main.Game.manager.removeSence(this);
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
    

