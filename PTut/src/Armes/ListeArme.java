/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Armes;

/**
 *
 * @author Tanbi
 */

import Personnage.Heros;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


public class ListeArme {
    
    private List<Arme> listeArmes = new ArrayList<>();
    private List<Arme> listeArmes2 = new ArrayList<>();
    private int index;
    
    public ListeArme(){
        listeArmes.add(new Arme("Pistolet", 1, 12));
        listeArmes.add(new Arme("Fusil", 3, 4));
        index=0;
        for ( Arme a : listeArmes){  
            listeArmes2.add(a);
        }
    }
    
    public void selectionArme(){
        for ( Arme a : listeArmes){  
            listeArmes2.add(a);
        } 
        if(index >=listeArmes2.size())
            index=0;
        else
            index++;
    }
    
    public void affiche(GameContainer gc, Graphics g) throws SlickException{
        listeArmes2.get(index).affiche(gc, g);
    }
    
    
    public int getIndex(){return index;}
    public Arme getArme(){return listeArmes.get(index);}
    
}