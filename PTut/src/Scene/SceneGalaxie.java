package Scene;

import CarteGalaxie.CarteGalaxie;
import Main.Menu;
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
         private Menu menu;
         private boolean b;
    
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
        menu.affiche(gc,g);
	}
	
        @Override
	protected void CustomUpdate(GameContainer gc, int t) throws SlickException 
	{
            if(Vaisseau.isOnPlanete)
                {
                        if( gc.getInput().isKeyDown(Input.KEY_A) ) 
                        {
                                Main.Game.manager.addSence( new ScenePlanete() );
                                setState(STATE.INVISIBLE);
                        }
                }
                Input input = gc.getInput();
                v.deplace(gc, c);
                menu.testAffiche(input, gc);
	}
	
        @Override
	public void init(GameContainer gc) throws SlickException 
	{
            try {
                    c = new CarteGalaxie();
                    v = new Vaisseau();
                    menu = new Menu();
            }   
            catch (    SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            b = false;
	}
	
        @Override
	public String toString()
	{
		return "Galaxie";
	}
}