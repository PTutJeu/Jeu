
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
               try {
                    Requete rq = new Requete();
                    ResultSet rs = rq.select("SELECT * FROM SAVE WHERE ID_PERSO = 1;");
                    long timeBDD = rs.getLong("TEMPS");
                    Main.Game.manager.setTotalTime(System.currentTimeMillis());
                    long ttime = Main.Game.manager.getTotalTime()+ timeBDD;
                    System.out.println(ttime);
                    rq.request("DROP TABLE SAVE");
                    rq.request("CREATE TABLE SAVE(ID_PERSO NUMBER, TEMPS NUMBER, BOIS NUMBER, FER NUMBER, "
                            + "CONSTRAINT PK_SAVE PRIMARY KEY (ID_PERSO));");
                    rq.request("INSERT INTO SAVE VALUES(1, "+ttime+", 0, 0);");
                 } 
                catch (       SQLException | ClassNotFoundException ex) 
                {
                Logger.getLogger(SceneMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                 }
                gc.exit();
           }
           //On enlevera ça plus tard c'est juste pour mettre a jour la base de donnée,
           //c'est pas censé etre présent dans le jeu mais ça me casse les couilles de faire
           //tout a la main a chaque fois
           if (gc.getInput().isKeyDown(Input.KEY_M)) {
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
