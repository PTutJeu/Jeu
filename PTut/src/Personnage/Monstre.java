package Personnage;

import BDD.Requete;
import CartePlateforme.Plateforme;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Wazaa
 * C'est bon JE LE VOIS !
 * 
 */
public class Monstre {
    private int id;
    private float x;
    private float y;
    private Image img;
    private int vie;
    private int vieMax;
    private float vitesseVertical;
    public static final float POPMOB_X = 500;
    public static final float POPMOB_Y = 500;
    
    public Monstre() throws SlickException, SQLException, ClassNotFoundException { 
        id = 1;
        
        Requete rq = new Requete();
        ResultSet rs = rq.select("SELECT * FROM MOB WHERE ID = " +id+ ";");
        
        vitesseVertical = 0;
        x = POPMOB_X;
        y = POPMOB_Y;
        vieMax = rs.getInt("VIE");
        vie = vieMax;
        img = new Image(rs.getString("IMG"));
        
        rq.closeDB();
    }
    
    public Monstre(int id) throws SlickException, SQLException, ClassNotFoundException {
        Requete rq = new Requete();
        ResultSet rs = rq.select("SELECT * FROM MOB WHERE ID = " +id+ ";");
        
        this.id = id;
        vitesseVertical = 0;
        x = POPMOB_X;
        y = POPMOB_Y;
        vieMax = rs.getInt("VIE");
        vie = vieMax;
        img = new Image(rs.getString("IMG"));
        
        rq.closeDB();
    }
    
    public void affiche(GameContainer gc, Graphics g) throws SlickException {
        g.drawImage(img, x, y);
    }
    
    public void deplacements(GameContainer gc, int temps, Plateforme plate, Heros heros)
    {
        boolean testCollisionPlate = collisionsPlate(plate);
        if (id == 3)
        {
            if (x > heros.getX()+ heros.getImg().getWidth()/2) x -= 2;
            if (x+img.getWidth() < heros.getX()+ heros.getImg().getWidth()/2) x += 2;
            if (y > heros.getY()+ heros.getImg().getHeight()/2) y -= 2;
            if (y+img.getWidth() < heros.getY()+ heros.getImg().getHeight()/2) y += 2;
            if (collisionsHeros(heros))
            {
                heros.perdVie(1); 
            }
        }
        else
        {
           if (!testCollisionPlate) {
            vitesseVertical += 0.01f * temps; // Même procédé que pour le saut mais fait en sorte de faire tomber le héros tout le temps
            y += vitesseVertical;
            //y1 = y + img.getHeight();

                if (y > 600 - img.getHeight()) {                  //Si en tombant le heros sort de la map,
                //setY( getY() - (getY() - 570)); // On le replace au bord.
                y = 600- img.getHeight();
                    }
                   }
        
            if (x > heros.getX()+ heros.getImg().getWidth()/2) x -= 2;
            if (x+img.getWidth() < heros.getX()+ heros.getImg().getWidth()/2) x += 2;
        
            if (collisionsHeros(heros))
            {
                heros.perdVie(1); 
            }
         // Ici je met en place le deplacement du monstre vers le joueur, le -25 devra etre remplacé par la taille de la HITBOX
         // Sinon pour l'instant il me suit normalement
         /*if (x > (heros.getX1()+25)) {
             x-=2;
             x1-=2;
         }*/
         /*if (x1 < (heros.getX()-25)) {
             x+=2;
             x1+=2;
         }*/ 
        }
        
   }
   public boolean collisionsPlate(Plateforme plate) {
        if ( y + img.getHeight() < plate.getY() ) return false;
        if ( x + img.getWidth() < plate.getX() ) return false;
        if ( y > plate.getY1() ) return false;
        if ( x > plate.getX1() ) return false;
        return true;
   }
   public boolean collisionsHeros(Heros heros)
   {
       return (getX1() >= heros.getX() && getX() <= heros.getX1() && getY1() >= heros.getY() && getY() <= heros.getY1());
   }

    //Getters
    public Image getImg() { return img; }
    public float getVitesseVertical() { return vitesseVertical; }
    public float getX() { return x; }
    public float getY() { return y; }
    public float getX1() { return x+img.getWidth(); }
    public float getY1() { return y+img.getHeight(); }
    public int getVie() { return vie; }

    //Setters
    public void setImg(Image img) { this.img = img; }
    public void setVitesseVertical(float vitesseVertical) { this.vitesseVertical = vitesseVertical; }
    public void setX(float x) { this.x = x; }
    public void setY(float y) { this.y = y; }
    public void perdVie(int degats) {
        if (vie - degats < 0) vie = 0;
        else vie -= degats;
    }
    public void gagneVie(int heal) {
        if (vie + heal > vieMax) vie = vieMax;
        else vie += heal;
    }
}

