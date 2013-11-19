package CarteGalaxie;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class CarteGalaxie {
    private int id; //Identifiant de la carte
    private String caImg; //Chemin d'acces de l'image du fond de la carte
    private int nbPlanete; //Nombre de planete se trouvant sur la carte
    
    public CarteGalaxie() {
        id = 0;
        caImg = "ressources/images/fondcartegal.png";
        nbPlanete = 0;
    }
    
    public CarteGalaxie(int id) {
        this.id = id;
    }
    
    //Méthode pour afficher
    public void affiche(GameContainer gc, Graphics g) throws SlickException {
        Image img = new Image(caImg);
        g.drawImage(img, 0, 0);
    }
}
