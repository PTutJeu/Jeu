package Scene;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Jérôme
 */

public class SceneManager 
{
	// La liste de scènes
	private List<Scene> sences ;
	// Le Gamecontainer pour gérer la méthode init
	private GameContainer gc;
        private long time;
        private long totalTime;
	
	public SceneManager ( GameContainer gc ) throws SlickException
	{
		this.gc = gc;
		sences = new ArrayList<>();
                time = System.currentTimeMillis();
	}
        
        public long getTime()
        {
            return time;
        }
        public long getTotalTime()
        {
            return totalTime;
        }
        public void setTotalTime(long t)
        {
            totalTime = t - time;
        }
	
	// Ajouter une scene à la liste et lancer la méthode init
	public void addSence ( Scene sence )
	{
		sences.add( sence );
		try {
			sence.init(gc);
		} catch (SlickException e) {
		}
		Collections.sort(sences);
	}
	
	// supprimer une scène en fonction de l'objet
	public void removeSence ( Scene sence )
	{
		sences.remove(sence);
	}
        public void removeAll()
        {
            while(!sences.isEmpty())
                    {
                        sences.remove(0);
                    }
        }
	
	// Supprimer une scène en fonction de son nom
	public boolean removeSence ( String sence )
	{
		for( int i = 0 ; i < sences.size() ; i++ )
		{
			if( sences.get(i).toString().equals(sence) )
			{
				sences.remove(i);
				return true;
			}
		}
		return false;
	}
	
	// Afficher toute les scènes
	public void render(GameContainer gc, Graphics g) throws SlickException {
		for( int i = 0 ; i < sences.size() ; i++ )
		{
			sences.get(i).render(gc, g);
		}
	}
	
	// Le Update pour toutes les scènes
	public void update(GameContainer gc, int t) throws SlickException {
		for( int i = 0 ; i < sences.size() ; i++ )
		{
			sences.get(i).update(gc,t);
		}
	}
	
	// Le getteur
	public Scene getSence ( String sence )
	{
		for( int i = 0 ; i < sences.size() ; i++ )
		{
			if( sences.get(i).toString().equals(sence) )
			{
				return sences.get(i);
			}
		}
		return null;
	}
	
	// trier la liste
	public void sort ()
	{
		Collections.sort(sences);
	}
	
	// vider la liste
	public void clear ()
	{
		sences = new ArrayList<>();
	}
}
