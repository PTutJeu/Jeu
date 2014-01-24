package Scene;

import Armes.ListeArme;
import Armes.ListeProjectile;
import BDD.Requete;
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
    private int idPlanete;
    
        private Image img;
        public ScenePlanete (int idPlanete) throws SlickException
	{
            super();
            setPriority(1);
            img = new Image("ressources/images/background.png");
            try {
                this.idPlanete = idPlanete;
                listePlateforme = new ListePlateforme(idPlanete);
                //MobList = new MobSpawner();
                MobList = new MobSpawner(idPlanete);
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
            listePlateforme.affiche(gc,g);
            MobList.affiche(gc,g);
            listeProjectile.affiche(gc,g);
            listeArmes.affiche(gc, g);
            heros.afficheXp(gc,g);
            heros.affiche(gc, g);
           
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
            heros.NiveauUp();
            if (!MobList.apparition()){
                
                updatePlanetePossedee(idPlanete);
                Main.Game.manager.removeSence(this);
                Main.Game.manager.getSence("Galaxie").setState(STATE.ON);
            }
            MobList.deplacements(gc, t, listePlateforme, heros);
            MobList.MortMob(heros);
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
                    listeProjectile = new ListeProjectile();
                    listeArmes = new ListeArme();
                    b = false;
	}
	
        @Override
	public String toString()
	{
		return "Planète";
	}
        
        public void updatePlanetePossedee(int idPlanete) {
            try {
                Requete rq = new Requete();
                rq.request("UPDATE DETAILS_PLANETE SET POSSEDEE = 1 WHERE ID = "+idPlanete+";");
                rq.closeDB();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ScenePlanete.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}

