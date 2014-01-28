package Personnage;

import BDD.Requete;
import CartePlateforme.ListePlateforme;
import CartePlateforme.Plateforme;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import java.lang.Math; 

/**
 *
 * @author Wazaa
 * 
 */
public class Monstre {
    private int id;
    private float x;
    private float xChampDeVision;
    private float y;
    private float yChampDeVision;
    private Image img;
    private Image champDeVision;
    private Image imgVision;
    private int vie;
    private int vieMax;
    private boolean move = true;
    private boolean vue = false;
    private float posActuelle = 500;
    private int direction = (int)( Math.random()*( 30 - 0 + 1 ) ) + 0;
    private int distance = (int)( Math.random()*( 600 - 300 + 1 ) ) + 300;
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
        champDeVision= new Image("ressources/images/champVision.png");
        champDeVision.setAlpha(0);
        imgVision = new Image("ressources/images/vision.png");
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
        champDeVision= new Image("ressources/images/champVision.png");
        champDeVision.setAlpha(0);
        imgVision = new Image("ressources/images/vision.png");
        rq.closeDB();
    }
    
    public void affiche(GameContainer gc, Graphics g) throws SlickException {
        g.drawImage(img, x, y);
        if (vue == true)
            g.drawImage(imgVision, x, y-20);
        if (direction <= 15)
        {
            xChampDeVision = x - champDeVision.getWidth()+img.getWidth()+20;
            yChampDeVision = getY1()-champDeVision.getHeight();
            g.drawImage(champDeVision,xChampDeVision,yChampDeVision);    
        }
        else 
            xChampDeVision = x-20;
            yChampDeVision = getY1()-champDeVision.getHeight();
            g.drawImage(champDeVision,xChampDeVision,yChampDeVision);
        
    }
    
    public void deplacements(GameContainer gc, int temps, ListePlateforme lp, Heros heros)
    {
        boolean testCollisionPlate = collisionsPlate(lp);
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
           if (!testCollisionPlate) 
           {
                vitesseVertical += 0.01f * temps; // Même procédé que pour le saut mais fait en sorte de faire tomber le héros tout le temps
                y += vitesseVertical;
                for (Plateforme p : lp.getListe()) {
                    if (getY1() > p.getY() && getY() < p.getY() && (!(getX() > p.getX1() || getX1() < p.getX())))
                        setY(p.getY() - img.getHeight());
                }
           }
           
           if (collisionsChampDeVision(heros))
           {
               vue = true;
               //EN CAS DE COLLISION AVEC LE CHAMP DE VISION, ALORS DEPLACEMENTS VERS LE HEROS
               if (x > heros.getX()+ heros.getImg().getWidth()/2) 
               {
                   direction = 13;
                   x -= 2;
               }
               if (x+img.getWidth() < heros.getX()+ heros.getImg().getWidth()/2)
               {
                   direction = 17;
                   x += 2;
               }
           }
           else
           {
               vue = false;
               //SI IL N'Y A PAS DE COLLISION, ALORS DEPLACEMENTS ALEATOIRES
                if (direction <= 15 && move == true)
                {
                    if ((x <= (posActuelle - distance)) || (x < 0))
                    {    
                        if (x < 0)
                        {
                            x = 0; 
                        }
                            move = false;
                    }
                        else 
                            x -=2;
                    
                }
                if((direction > 15 )&& (move == true))
                {
                    if ((x >= (posActuelle + distance)) || ((x + img.getWidth()) > 800))
                    {
                        if ((x + img.getWidth()) > 800)
                        {
                            x = 800 - img.getWidth();
                        }
                        move = false;
                    }
                    else
                        x += 2;
                }
                else
                {
                    ChoixDirection();
                }
           }
           
            if (collisionsHeros(heros))
            {
                heros.perdVie(1); 
            }
        }
        
   }
   public void ChoixDirection()
   {    
        if (move == false)
        {
            move = true;
            posActuelle = x;
            if (direction <= 15)
            {
                direction = 17;
            }
            else if (direction > 15)
            {
                direction = 13;
            }
            distance = (int)( Math.random()*( 600 - 300 + 1 ) ) + 300;
        }
   }
   public boolean collisionsChampDeVision(Heros heros)
   {
       return ( heros.getX1() >= xChampDeVision  && heros.getX() <= xChampDeVision+champDeVision.getWidth() && heros.getY1() >= yChampDeVision && heros.getY()<= yChampDeVision+champDeVision.getHeight());
   }
   public boolean collisionsPlate(ListePlateforme lp) {
       boolean collision = false; 
       
       for (Plateforme p : lp.getListe()) {
           boolean col;
           
            if ( y + img.getHeight() < p.getY() ) col = false;
            else if ( x + img.getWidth() < p.getX() ) col = false;
            else if ( y > p.getY1() ) col = false;
            else if ( x > p.getX1() ) col = false;
            else col = true;
            
            collision = collision || col;
       }
       
       return collision;
   }
   public boolean collisionsHeros(Heros heros)
   {
       return (getX1() >= heros.getX() && getX() <= heros.getX1() && getY1() >= heros.getY() && getY() <= heros.getY1());
   }
   /*public boolean collisionsChampVision(ChampVision cv)
   {
       
   }*/
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

