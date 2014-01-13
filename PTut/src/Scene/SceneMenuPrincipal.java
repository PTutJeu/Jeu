
package Scene;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Jérôme
 */
public class SceneMenuPrincipal extends Scene implements Serializable{
    
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
           if(gc.getInput().isKeyDown(Input.KEY_ESCAPE))
           {
               try 
               {
                   gc.exit();
                   Main.Game.manager.setTotalTime(System.currentTimeMillis());               
                   ObjectOutputStream oos = null;
                   FileOutputStream fichier;
                   fichier = new FileOutputStream("time.txt");
                   oos = new ObjectOutputStream(fichier);
                   oos.writeObject(Main.Game.manager.getTotalTime());
                   oos.flush();
                   oos.close();
                   System.out.println(Main.Game.manager.getTotalTime());
                   
               } 
               catch (FileNotFoundException ex) 
               {
                   Logger.getLogger(SceneMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
               } 
               catch (IOException ex) 
               {
                   Logger.getLogger(SceneMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
               }
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
