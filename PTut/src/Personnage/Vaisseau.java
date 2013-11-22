
package Personnage;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class Vaisseau extends Personnage{
        private Image img;
        
        public Vaisseau() throws SlickException{
            super();
            img = new Image("ressources/images/vaisseau.png");
            x = 40;
            y = 40;
            x1 = x + img.getWidth();
            y1 = y + img.getHeight();
        }
        
        public void affiche(GameContainer gc, Graphics g) throws SlickException {
        
        //On affiche l'image à la position voulue
        g.drawImage(img, x, y);
    }
        
    public void deplace(GameContainer gc){
        Input input = gc.getInput(); //Variable de type entrée
        
        if( input.isKeyDown(Input.KEY_RIGHT) ){ // Si la variable pressée est flèche droite alors on déplace le héros à droite
            if(collisionW(input)==false)
            {
                x = x+2;
                x1=x1+2;
            }
        }
        
        if( input.isKeyDown(Input.KEY_LEFT) ){ // Si la variable pressée est flèche gauche alors on déplace le héros à gauche
            if(collisionW(input)==false)
            {
                x = x-2;
                x1=x1-2;
            }   
        }
         if( input.isKeyDown(Input.KEY_UP) ){ // Si la variable pressée est flèche droite alors on déplace le héros à droite
            if(collisionW(input)==false)
            {
                y = y-2;
                y1=y1-2;
            }
        }
        
        if( input.isKeyDown(Input.KEY_DOWN) ){ // Si la variable pressée est flèche gauche alors on déplace le héros à gauche
            if(collisionW(input)==false)
            {
                y = y+2;
                y1=y1+2;
            }
        }
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
    
    public boolean collisionP(Input input , int id , float x , float y)
    {
        boolean b=false;        
        if( input.isKeyDown(Input.KEY_LEFT) )
        {
            if(this.x-2<x)
                b=true;
        }
        if( input.isKeyDown(Input.KEY_RIGHT))
        {
            if(this.x1+2>x)
                b=true;
        }
        if( input.isKeyDown(Input.KEY_DOWN) )
        {
            if(this.y1+2>y)
                b=true;
        }
        if( input.isKeyDown(Input.KEY_UP) )
        {
            if(this.y-2<0)
               b=true;
        }
        
        return b;
        
    }
      
}
