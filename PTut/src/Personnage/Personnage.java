package Personnage;

//Classe abstraite Personnage, les classes filles seront Vaisseau, Perso et monstre

import java.util.ArrayList;
import java.util.List;

public abstract class Personnage {
    private int vie; //Vie actuelle du personnage
    private int xp; //expérience du personnage
    private int niveau; //Niveau du Personnage
    private List<String> Objets = new ArrayList<>(); //On établit une liste d'objets que possède le Personnage
    
    
    
    //Constructeurs
    public Personnage(){
        vie=100;
        xp=0;
        niveau=1;
    }
    
    public Personnage(int v, int x, int n){
        vie=v;
        xp=x;
        niveau=n;
        
    }
    
    //Getters
    public int getVie(){ return vie; }
    
    public int getXp(){ return xp;}
    
    public int getNiveau(){ return niveau;}
    
    //Setters
    public void setVie(int v){ vie=v; }
    
    public void setXp(int x){ xp=x; }
    
    public void setNiveau(int n){ niveau=n;}
   
    public void AjouterObjet(){
        
    }
}
