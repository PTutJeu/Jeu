package Scene;

import CartePlateforme.Plateforme;
import Main.Game;
import Main.Menu;
import Personnage.Heros;
import Personnage.MobSpawner;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class ScenePlanete extends Scene 
{
    
    private Heros heros;
    private Menu menu;
    private Plateforme plate;
    private MobSpawner MobList;
    private boolean b;
    
        public ScenePlanete ()
	{
		super();
		setPriority(2);
	}
	
        @Override
	protected void CustomRender(GameContainer gc, Graphics g) throws SlickException 
	{
            heros.affiche(gc, g);
            plate.affiche(gc,g);
            MobList.affiche(gc,g);
            menu.affiche(gc,g);
	}
	
        @Override
	protected void CustomUpdate(GameContainer gc, int t) throws SlickException 
	{
                Input input = gc.getInput();
                heros.déplacements(gc, t, plate);
                MobList.apparition();
                MobList.déplacements(gc, t, plate,heros);
                menu.testAffiche(input, gc);
            
		// If Space is pressed
		if( gc.getInput().isKeyPressed(Input.KEY_TAB) ) 
		{
			// Add a new Sence2 instance to the SenceManager
			Game.manager.addSence( new SceneGalaxie() );
                        Main.Game.manager.removeSence(this);
		}
	}
	
        @Override
	public void init(GameContainer gc) throws SlickException 
	{
                    heros = new Heros();
                    menu = new Menu();
                    plate = new Plateforme("plateforme", 200, 450);
                    MobList = new MobSpawner();
                    b = false;
	}
	
        @Override
	public String toString()
	{
		return "Sence1";
	}
}

