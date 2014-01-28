package Scene;

import CarteGalaxie.CarteGalaxie;
import CarteGalaxie.Teleporteur;
import Personnage.Vaisseau;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class SceneGalaxie extends Scene 
{
         private Vaisseau v;
         private CarteGalaxie c;
         private SceneMenu menu;
    
	public SceneGalaxie ()
	{
		super();
		setPriority(1);                
	}
	
        @Override
	protected void CustomRender(GameContainer gc, Graphics g) throws SlickException 
	{
		c.affiche(gc, g);
        try {
            v.affiche(gc, g);
         } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
        @Override
	protected void CustomUpdate(GameContainer gc, int t) throws SlickException 
	{
            if(Vaisseau.isOnPlanete)
            {
                if( gc.getInput().isKeyDown(Input.KEY_A) ) 
                {
                    //Test planete possedee
                    if (!v.planeteIsPossedee()) {
                        Main.Game.manager.addSence( new ScenePlanete(v.getIdPlanete(), v) );
                        setState(STATE.INVISIBLE);
                    }
                }
            }
            v.deplace(gc, c);
            for (Teleporteur te : c.getTelep()) {
                if (v.collisionTelep(te)) {
                    try {
                        c = new CarteGalaxie(te.getIdMapDest());
                        v.setX(te.getXDest());
                        v.setY(te.getYDest());
                    } catch (SQLException | ClassNotFoundException ex) {
                        Logger.getLogger(SceneGalaxie.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            if(gc.getInput().isKeyDown(Input.KEY_ESCAPE))
            {
                setState(STATE.FREEZE_NEXT);
                Main.Game.manager.addSence(new SceneMenu());                  
            }
              
	}
	
        @Override
	public void init(GameContainer gc) throws SlickException 
	{
            try {
                    c = new CarteGalaxie();
                    v = new Vaisseau();
            }   
            catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
	
        @Override
	public String toString()
	{
		return "Galaxie";
	}
}
