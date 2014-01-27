package Scene;

import Armes.ListeArme;
import Armes.ListeProjectile;
import BDD.Requete;
import CartePlateforme.ListePlateforme;
import CartePlateforme.Plateforme;
import Personnage.Heros;
import Personnage.MobSpawner;
import Personnage.Vaisseau;
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
    private Vaisseau vaisseau;
    private SceneMenu menu;
    private ListePlateforme listePlateforme;
    private MobSpawner MobList;
    private boolean planeteFinie;
    private ListeProjectile listeProjectile;
    private ListeArme listeArmes;
    private int idPlanete;
    private long tempsFinPlanete;
    
        private Image img;
        public ScenePlanete (int idPlanete, Vaisseau v) throws SlickException
	{
            super();
            setPriority(1);
            img = new Image("ressources/images/background.png");
            try {
                this.idPlanete = idPlanete;
                listePlateforme = new ListePlateforme(idPlanete);
                //MobList = new MobSpawner();
                MobList = new MobSpawner(idPlanete);
                planeteFinie = false;
                vaisseau = v;
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
            MobList.apparition();
            if (!planeteFinie) tempsFinPlanete = System.currentTimeMillis();
            if (MobList.isFinie() && !planeteFinie) {
                updatePlanetePossedee(idPlanete);
                planeteFinie = true;
                //IMAGE DE FIN - VICTOIRE
            }
            if (System.currentTimeMillis() - tempsFinPlanete > 3000) {
                Main.Game.manager.removeSence(this);
                Main.Game.manager.getSence("Galaxie").setState(STATE.ON);
                updateVaisseau();
            }
            MobList.deplacements(gc, t, listePlateforme, heros);
            MobList.MortMob(heros);
            listeProjectile.deplacements(gc, heros);
            listeProjectile.collisions(MobList.getMobList());
            if (!heros.getVieMort()) {
                //AFFICHER GAME OVER
                
                planeteFinie = true;
                if (System.currentTimeMillis() - tempsFinPlanete > 3000) {
                    Main.Game.manager.removeSence(this);
                    Main.Game.manager.getSence("Galaxie").setState(STATE.ON);
                }
            }
            
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
                    heros = new Heros(vaisseau);
                    listeProjectile = new ListeProjectile();
                    listeArmes = new ListeArme();
                    planeteFinie = false;
                    tempsFinPlanete = System.currentTimeMillis();
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
        
        public void updateVaisseau() {
            vaisseau.setNiveau(heros.getNiveau());
            vaisseau.setXp(heros.getXp());
            vaisseau.setXpMax(heros.getXpMax());
        }
}

