package Personnage;

//Classe abstraite Personnage, les classes filles seront Vaisseau, Perso et monstre

import java.util.ArrayList;
import java.util.List;

public abstract class Personnage {
    protected float x; //Coordonnée en x du héros
    protected float y; //Coordonnée en y du héros
    protected float x1; //coordonnée du coin inférieur de l'image
    protected float y1; //coordonnée du coin inférieur de l'image
    protected int vie; //Vie actuelle du personnage
    protected int xp; //expérience du personnage
    protected int niveau; //Niveau du Personnage
    protected String nom; // Nom du personnage
    protected boolean VieMort=true;
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
    public float getX(){ return x; }
    public float getY(){ return y;}
    public float getX1(){ return x1; }
    public float getY1(){ return y1;}
    
    //Setters
    public void setVie(int v){ vie=v; }
    public void setXp(int x){ xp=x; }
    public void setNiveau(int n){ niveau=n;}
    public void setX(float x){ this.x=x;}
    public void setY(float y){ this.y=y;}
    public void setNom(String nom){ this.nom = nom;}
    

    
    
   
    public void AjouterObjet(){
        
    }
}
