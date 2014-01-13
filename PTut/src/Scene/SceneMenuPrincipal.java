
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
public class SceneMenuPrincipal extends Scene {
    
    private Image img;
    
     public SceneMenuPrincipal() throws SlickException
    {
        super();
        img = new Image("ressources/images/menuPrinc.jpg");
        setPriority(1);
    }
     
     public void affiche(GameContainer gc, Graphics g)
     {
         g.drawImage(img, 0, 0);
     }
     
      @Override
	protected void CustomRender(GameContainer gc, Graphics g) throws SlickException 
	{
		affiche(gc, g);
	}
	
        @Override
	protected void CustomUpdate(GameContainer gc, int t) throws SlickException 
	{
           if(gc.getInput().isKeyDown(Input.KEY_ENTER))
           {
               Main.Game.manager.addSence( new SceneGalaxie() );
               Main.Game.manager.removeSence(this);
           }
	}
	
        @Override
	public void init(GameContainer gc) throws SlickException 
	{
        
        }
	
        @Override
	public String toString()
	{
		return "MenuPrincipal";
	}

}
