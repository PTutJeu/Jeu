
package Personnage;

import BDD.Requete;
import CarteGalaxie.CarteGalaxie;
import CarteGalaxie.MenuInterface;
import CarteGalaxie.Planete;
import CarteGalaxie.Teleporteur;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class Vaisseau extends Personnage {
        private Image img;
        public static boolean isOnPlanete;
        private int idPlanete;
        private MenuInterface menu;
        private int gold, bois, metal;
        
        public Vaisseau() throws SlickException{
            super();
            img = new Image("ressources/images/VaisseauBas.png");
            x = 40;
            y = 40;
            x1 = x + img.getWidth();
            y1 = y + img.getHeight();
            isOnPlanete = false;
            idPlanete = -1;
            try {
                Requete rq = new Requete();
                
                rq.closeDB();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Vaisseau.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void affiche(GameContainer gc, Graphics g) throws SlickException, SQLException, ClassNotFoundException {
        
        //On affiche l'image à la position voulue
        g.drawImage(img, x, y);
        menu = new MenuInterface(idPlanete);
        if (isOnPlanete) {
            menu.affiche(g, this);
        }
    }
        
    public void deplace(GameContainer gc, CarteGalaxie c) throws SlickException{
        Input input = gc.getInput(); //Variable de type entrée
        
        if( input.isKeyDown(Input.KEY_RIGHT) ){ // Si la variable pressée est flèche droite alors on déplace le héros à droite
            if(collisionW(input)==false)
            {
                x = x+2;
                x1=x1+2;
                img = new Image("ressources/images/VaisseauDroite.png");

            }
        }
        
        if( input.isKeyDown(Input.KEY_LEFT) ){ // Si la variable pressée est flèche gauche alors on déplace le héros à gauche
            if(collisionW(input)==false)
            {
                x = x-2;
                x1=x1-2;
                img = new Image("ressources/images/VaisseauGauche.png");
            }   
        }
         if( input.isKeyDown(Input.KEY_UP) ){ // Si la variable pressée est flèche droite alors on déplace le héros à droite
            if(collisionW(input)==false)
            {
                y = y-2;
                y1=y1-2;
                img = new Image("ressources/images/VaisseauHaut.png");

            }
        }
        
        if( input.isKeyDown(Input.KEY_DOWN) ){ // Si la variable pressée est flèche gauche alors on déplace le héros à gauche
            if(collisionW(input)==false)
            {
                y = y+2;
                y1=y1+2;
                img = new Image("ressources/images/VaisseauBas.png");

            }            
        }
        if( input.isKeyDown(Input.KEY_UP) && input.isKeyDown(Input.KEY_RIGHT) )
        {
            img = new Image("ressources/images/VaisseauHautDroite.png");
        }
        if( input.isKeyDown(Input.KEY_UP) && input.isKeyDown(Input.KEY_LEFT) )
        {
            img = new Image("ressources/images/VaisseauHautGauche.png");
        }
        if( input.isKeyDown(Input.KEY_DOWN) && input.isKeyDown(Input.KEY_RIGHT))
        {
            img = new Image("ressources/images/VaisseauBasDroite.png");
        }
        if( input.isKeyDown(Input.KEY_DOWN) && input.isKeyDown(Input.KEY_LEFT) )
        {
            img = new Image("ressources/images/VaisseauBasGauche.png");
        }
        
        isOnPlanete = false; //On suppose que le vaisseau n'est pas sur une planete
        //On test ensuite toute les planetes, si il est sur une, on met la variable a true 
        //et on récupère l'id de la planete sur laquelle il se trouve
        for (Planete p : c.getPlanetes()) {
            if (collisionP(p)) {
                isOnPlanete = true;
                idPlanete = p.getId();
            }
        }
        if (!isOnPlanete) idPlanete = -1;
    }
    public boolean collisionW(Input input)
    {
        boolean b=false;
        if( input.isKeyDown(Input.KEY_LEFT) )
        {
            if(this.x-2<0)
                b=true;
        }
        if( input.isKeyDown(Input.KEY_RIGHT))
        {
            if(this.x1+2>800)
                b=true;
        }
        if( input.isKeyDown(Input.KEY_DOWN) )
        {
            if(this.y1+2>600)
                b=true;
        }
        if( input.isKeyDown(Input.KEY_UP) )
        {
            if(this.y-2<0)
               b=true;
        }
        return b;
    }
    
    public boolean collisionP(Planete p)
    {
        boolean b=false;      
        if (this.x > p.getX() && this.x1 < p.getX() + p.getLarg()&& this.y > p.getY() && this.y1 < p.getY() + p.getHaut())
            b = true;
        
        return b;
    }
    
    public void setX(int x) { 
        this.x = x;
        this.x1 = this.x + img.getWidth();
    } 
    
    public void setY(int y) {
        this.y = y;
        this.y1 = this.y + img.getHeight();
    }
    
    public int getIdPlanete() { return idPlanete; }
    public boolean isOnPlanete() { return isOnPlanete; }
    public boolean planeteIsPossedee() { return menu.isPossedee(); }
    public MenuInterface getMenu() { return menu; }
    public int getGold() { return gold; }
    public int getMetal() { return metal; }
    public int getBois() { return bois; }
    
    public boolean collisionTelep(Teleporteur t) {
        return (x1 >= t.getX() && x <= t.getX1() && y1 >= t.getY() && y <= t.getY1());
    }
    
    public void collect() {
        if (isOnPlanete && menu.isPossedee()) {
            gold += menu.getGoldAct();
            bois += menu.getBoisAct();
            metal += menu.getMetalAct();
            try {
                Requete rq = new Requete();
                rq.request("UPDATE DETAILS_PLANETE SET LASTCOLLECT = " 
                        +System.currentTimeMillis()+ " WHERE ID = "+idPlanete+";");
                rq.closeDB();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Vaisseau.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
    }
}