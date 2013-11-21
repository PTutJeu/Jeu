package Personnage;

//Classe abstraite Personnage, les classes filles seront Vaisseau, Perso et monstre

import java.util.ArrayList;
import java.util.List;

public abstract class Personnage {
    protected int x; //Coordonnée en x du héros
    protected int y; //Coordonnée en y du héros
    protected int x1; //coordonnée du coin inférieur de l'image
    protected int y1; //coordonnée du coin inférieur de l'image
    protected int vie; //Vie actuelle du personnage
    protected int xp; //expérience du personnage
    protected int niveau; //Niveau du Personnage
    protected String nom; // Nom du personnage
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
    public int getX(){ return x; }
    public int getY(){ return y;}
    public int getX1(){ return x1; }
    public int getY1(){ return y1;}
    
    //Setters
    public void setVie(int v){ vie=v; }
    public void setXp(int x){ xp=x; }
    public void setNiveau(int n){ niveau=n;}
    public void setX(int x){ this.x=x;}
    public void setY(int y){ this.y=y;}
    public void setNom(String nom){ this.nom = nom;}
    

    
    
   
    public void AjouterObjet(){
        
    }
}
