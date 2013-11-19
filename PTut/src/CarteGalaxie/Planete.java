package CarteGalaxie;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Planete {
    private int id; //Identifiant de la planete
    private int idMap; //Identifiant de la map sur laquelle elle se trouve
    private int x; //Position en x de la planete sur la map
    private int y; //Position en y de la planete sur la map
    private String caImg; //Chemin d'accès de l'image de la planete
    private int larg; //
    
    public Planete() {
        id = 0;
        idMap = 0;
        x = 0;
        y = 0;
        caImg = "ressources/images/p1.png";
    }
    
    public Planete(int id) {
        this.id = id;
        idMap = 0;
        x = 0;
        y = 0;
        caImg = "ressources/images/p1.png";
    }
    
    public void affiche(GameContainer gc, Graphics g) throws SlickException {
        Image img = new Image(caImg);
        g.drawImage(img, x, y);
    }
}
