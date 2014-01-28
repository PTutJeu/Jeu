
package Scene;

import BDD.ExecQuery;
import BDD.Requete;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class SceneMenuPrincipal extends Scene implements Serializable {
    
    private Image img;
    private Image newPartie;
    private Image continuer;
    private Image quitter;
    
     public SceneMenuPrincipal() throws SlickException
    {
        super();
        img = new Image("ressources/Menu/fondMenu.png");
        newPartie = new Image("ressources/Menu/nouvelleNeutre.png");
        continuer = new Image("ressources/Menu/continuerneutre.png");
        quitter = new Image("ressources/Menu/quitterNeutre.png");
        
        setPriority(1);
    }
     
     public void affiche(GameContainer gc, Graphics g)
     {
         g.drawImage(img, 0, 0);
         g.drawImage(newPartie, 50, 300);
         g.drawImage(continuer, 50, 350);
         g.drawImage(quitter, 50, 500);
     }
     
      @Override
	protected void CustomRender(GameContainer gc, Graphics g) throws SlickException 
	{
		affiche(gc, g);
	}
	
        @Override
	protected void CustomUpdate(GameContainer gc, int t) throws SlickException 
	{
           //if(gc.getInput().isKeyDown(Input.KEY_ENTER))
           if(gc.getInput().getMouseX() > 50 && gc.getInput().getMouseX() < 50 + newPartie.getWidth() && gc.getInput().getMouseY() > 300 && gc.getInput().getMouseY() < 300 + newPartie.getHeight())
           {
               Main.Game.manager.addSence( new SceneGalaxie() );
               Main.Game.manager.removeSence(this);
           }
           if(gc.getInput().isKeyDown(Input.KEY_ESCAPE))
           {
               try {
                    Requete rq = new Requete();
                    ResultSet rs = rq.select("SELECT * FROM SAVE WHERE ID_PERSO = 1;");
                    long timeBDD = rs.getLong("TEMPS");
                    Main.Game.manager.setTotalTime(System.currentTimeMillis());
                    long ttime = Main.Game.manager.getTotalTime()+ timeBDD;
                    System.out.println(ttime);
                    rq.request("UPDATE SAVE SET TEMPS = "+ttime+";");
                    rq.closeDB();
                 } 
                catch (SQLException | ClassNotFoundException ex) 
                {
                Logger.getLogger(SceneMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                 }
                gc.exit();
           }
           //On enlevera ça plus tard c'est juste pour mettre a jour la base de donnée,
           //c'est pas censé etre présent dans le jeu mais ça me casse les couilles de faire
           //tout a la main a chaque fois
           if (gc.getInput().isKeyDown(Input.KEY_N)) {
               ExecQuery ex = new ExecQuery();
               ex.execQuery();
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
