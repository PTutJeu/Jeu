package Scene;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Jérôme
 */

public abstract class Scene implements Comparable<Scene>
{
	// Les états possibles d'une scène
        //ON = Affichée
        //FREEZE = figée
        //FREEZE_NEXT = J'ai pas trop compris cet état pour le moment
        //INVISIBLE = non-visible
	public enum STATE { ON , FREEZE , FREEZE_NEXT , INVISIBLE };
	// L'état courant de la scène est stocké dans cette variable
	private STATE state;
	// La priorité d'affichage
	private int prio = 0;
	
	// Un buffer d'Image pour sauvegarder la dernière image affichée pour le FREEZE
	private Image sence;
	
	
	public Scene ()
	{
		// L'état par défaut est ON
		state = STATE.ON;
		try {
			// On adapte la résolution et on initialise le buffer
			sence = new Image(800,600);
		} catch (SlickException e) {
		}
	}

	
	// Méthodes qui seront utilisées par les classes dérivé de Scene (La Map galaxie, la map planète, le menu...)
	protected void CustomRender(GameContainer gc, Graphics g) throws SlickException 
	{
		
	}
	
	protected void CustomUpdate(GameContainer gc, int t) throws SlickException 
	{
		
	}
	
	public void init(GameContainer gc) throws SlickException 
	{
		
	}
	

	// Méthode appelée par le scenemanager
	// ca gère l'état de la scène (visible, on, freeze)
	// elle appelle le "CustomRender"
	public void render(GameContainer gc, Graphics g) throws SlickException {
		if( state != STATE.INVISIBLE )
		{
			if( state == STATE.ON ) 
			{
				CustomRender( gc , g );
			}
			if( state == STATE.FREEZE_NEXT )
			{
				sence.getGraphics().clear();
				CustomRender( gc , sence.getGraphics() );
				state = STATE.FREEZE;
			}
			if( state == STATE.FREEZE )
			{
				g.drawImage(sence, 0, 0);
			}
		}
	}
	
	// Méthode appelée par le scenemanager
	// elle appelle notre "CustomUpdate"
	public void update(GameContainer gc, int t) throws SlickException {
		if( state == STATE.ON )
		{
			CustomUpdate( gc , t );
		}
	}
	
	// setteur pour la priorité
	public void setPriority ( int p )
	{
		prio = p;
	}
	
	// le toString
        @Override
	public String toString()
	{
		return "default";
	}
	
	// Le getteur pour la priorité
	public int getPriority ()
	{
		return prio;
	}
	
	// Le compareTo pour la liste
        @Override
	public int compareTo(Scene compareObject)
    {
        if (getPriority() < compareObject.getPriority())
            return -1;
        else if (getPriority() == compareObject.getPriority())
            return 0;
        else
            return 1;
    }
	
	// Le setteur pour l'état
	public void setState( STATE s )
	{
		state = s;
	}
	
}
