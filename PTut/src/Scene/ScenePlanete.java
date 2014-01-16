package Scene;

import Armes.ListeArme;
import Armes.ListeProjectile;
import CartePlateforme.Plateforme;
import Personnage.Heros;
import Personnage.MobSpawner;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;


public class ScenePlanete extends Scene 
{

    private Heros heros;
    private SceneMenu menu;
    private Plateforme plate;
    private MobSpawner MobList;
    private boolean b;
    private ListeProjectile listeProjectile;
    private ListeArme listeArmes;
    
        private Image img;
        public ScenePlanete () throws SlickException
	{
            super();
            setPriority(1);
            img = new Image("ressources/images/background.png");
	}
        
	public void affiche(GameContainer gc, Graphics g)
         {
            g.drawImage(img, 0, 0);
         }
        
        @Override
	protected void CustomRender(GameContainer gc, Graphics g) throws SlickException 
	{
            affiche(gc,g);
            heros.affiche(gc, g);
            plate.affiche(gc,g);
            MobList.affiche(gc,g);
            listeProjectile.affiche(gc,g);
            listeArmes.affiche(gc, g);
           
	}
	
        @Override
	protected void CustomUpdate(GameContainer gc, int t) throws SlickException 
	{
                Input input = gc.getInput();
                heros.déplacements(gc, t, plate);
                heros.tirer(gc, listeProjectile, listeArmes);
                heros.vieHeros();
                heros.armeSelection(gc, listeArmes);
                MobList.apparition();
                MobList.déplacements(gc, t, plate,heros);
                
                listeProjectile.deplacements(gc, heros);
                listeProjectile.collisions();
                
                if(gc.getInput().isKeyDown(Input.KEY_ESCAPE))
                {
                    setState(STATE.FREEZE_NEXT);
                    Main.Game.manager.addSence(new SceneMenu());
                }
            
                    if( gc.getInput().isKeyPressed(Input.KEY_TAB) ) 
                    {
                            Main.Game.manager.removeSence(this);
                            Main.Game.manager.getSence("Galaxie").setState(STATE.ON);
                    }
	}
	
        @Override
	public void init(GameContainer gc) throws SlickException 
	{
                    heros = new Heros();
                    plate = new Plateforme("plateforme", 200, 450);
                    MobList = new MobSpawner();
                    listeProjectile = new ListeProjectile();
                    listeArmes = new ListeArme();
                    b = false;
	}
	
        @Override
	public String toString()
	{
		return "Planète";
	}
}

