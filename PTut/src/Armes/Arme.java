/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Armes;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Tanbi
 */
public class Arme {
    
    private String nom;
    private int degats;
    private Image img;
    private int chargeur;
    private int tempsTir; // temps en millisecondes
    private int tempsRechargement; //temps en millisecondes
    private int munition;
    
    public Arme(String nom, int degats, int chargeur, int tempsTir, int tempsRechargement){
        this.nom=nom;
        this.degats=degats;
        this.chargeur=chargeur;
        this.tempsTir=tempsTir;
        this.tempsRechargement=tempsRechargement;
        this.munition=chargeur;
    }
    
     public void affiche(GameContainer gc, Graphics g) throws SlickException{
        g.drawString(nom, 10, 100);     
    }
     
    public void setNom(String nom){this.nom = nom;}
    public void setTempsTir(int tempsTir){this.tempsTir = tempsTir;}
    public void setChargeur(int chargeur){this.chargeur=chargeur;}
    public void setDegats(int degats){this.degats=degats;}
    public void setTempsRechargement(int tempsRechargement){this.tempsRechargement=tempsRechargement;}
    public void setMunition(int munition){this.munition=munition;}
    
    public String getNom(){return nom;}  
    public int getChargeur(){return chargeur;}
    public int getDegats(){return degats;}
    public int getTempsTir(){return tempsTir;}
    public int getTempsRechargement(){return tempsRechargement;}
    public int getMunition(){return munition;}
    
}
