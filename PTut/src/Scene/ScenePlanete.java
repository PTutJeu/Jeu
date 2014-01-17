package Scene;

import Armes.ListeArme;
import Armes.ListeProjectile;
import CartePlateforme.ListePlateforme;
import CartePlateforme.Plateforme;
import Personnage.Heros;
import Personnage.MobSpawner;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private ListePlateforme listePlateforme;
    private MobSpawner MobList;
    private boolean b;
    private ListeProjectile listeProjectile;
    private ListeArme listeArmes;
    
        private Image img;
        public ScenePlanete (int idPlanete) throws SlickException
	{
            super();
            setPriority(1);
            img = new Image("ressources/images/background.png");
            try {
                listePlateforme = new ListePlateforme(idPlanete);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ScenePlanete.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            listePlateforme.affiche(gc,g);
            MobList.affiche(gc,g);
            listeProjectile.affiche(gc,g);
            listeArmes.affiche(gc, g);
           
	}
	
        @Override
	protected void CustomUpdate(GameContainer gc, int t) throws SlickException 
	{
        try {
            Input input = gc.getInput();
            heros.deplacements(gc, t, listePlateforme);
            heros.tirer(gc, listeProjectile, listeArmes, t);
            heros.vieHeros();
            heros.armeSelection(gc, listeArmes);
            MobList.apparition();
            MobList.deplacements(gc, t, listePlateforme, heros);
            MobList.MortMob();
            listeProjectile.deplacements(gc, heros);
            listeProjectile.collisions(MobList.getMobList());
            
            if(gc.getInput().isKeyDown(Input.KEY_ESCAPE))
            {
                setState(STATE.FREEZE_NEXT);
                Main.Game.manager.addSence(new SceneMenu());
            }
            
            if( gc.getInput().isKeyDown(Input.KEY_TAB) )
            {
                Main.Game.manager.removeSence(this);
                Main.Game.manager.getSence("Galaxie").setState(STATE.ON);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ScenePlanete.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
        @Override
	public void init(GameContainer gc) throws SlickException 
	{
                    heros = new Heros();
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

