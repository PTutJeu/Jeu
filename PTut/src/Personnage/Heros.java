package Personnage;

import Armes.Arme;
import Armes.ListeArme;
import CartePlateforme.Plateforme;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import Armes.ListeProjectile;
import java.text.DateFormat;

import Armes.Projectile;
import CartePlateforme.ListePlateforme;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author Tanbi
 */
public class Heros extends Personnage {
    
    private SpriteSheet herosD, herosG, mvtD, mvtG, tirD, tirG, herosMort, sautD, sautG, gameOver;
    private Animation herosAnimation, droite, gauche, droiteArret, gaucheArret, droiteTir, gaucheTir, mort, droiteSaut, gaucheSaut, gameOverAnimation;
    private SpriteSheet rechargeSheet;
    private Animation rechargeAnimation;
    private SpriteSheet levelUp;
    private Animation levelUpAnimation;
      
    private int munitions, chargeur;
    private long tempsRechargement, tempsInvincible, tempsLevelUp, tempsTir;
    private float vitesseVertical = 0.0f;
    private boolean sauter = false;
    private boolean recharge =false, enLevelUp=false;
    private Image img;
    private Image imgVie;
    private Image imgXp, imgXpMax;
    private int   xpMax;
    public boolean vue = true, enMarche=false, enTir=false; // Vraie si le héro regarde à droite

    public Heros() throws SlickException{ // Constructeur du héros
        super();
        /*
        herosD = new SpriteSheet("ressources/images/sprite_heros_arret_droite.png",48,59);
        herosG = new SpriteSheet("ressources/images/sprite_heros_arret_gauche.png",48,59);
        mvtD = new SpriteSheet("ressources/images/sprite_heros_droite.png",48,59);
        mvtG = new SpriteSheet("ressources/images/sprite_heros_gauche.png",48,59);
        tirD = new SpriteSheet("ressources/images/sprite_heros_tir_droite.png",64,43);
        tirG = new SpriteSheet("ressources/images/sprite_heros_tir_gauche.png",64,43);
        herosMort = new SpriteSheet("ressources/images/heros_cadavre.png",48,44);
        sautD = new SpriteSheet("ressources/images/heros_saut_droite.png",48,51);
        sautG = new SpriteSheet("ressources/images/heros_saut_gauche.png",48,51);
        */
        herosD = new SpriteSheet("ressources/images/test/sprite_heros_arret_droite.png",30,30);
        herosG = new SpriteSheet("ressources/images/test/sprite_heros_arret_gauche.png",30,30);
        mvtD = new SpriteSheet("ressources/images/test/sprite_heros_droite.png",30,30);
        mvtG = new SpriteSheet("ressources/images/test/sprite_heros_gauche.png",30,30);
        tirD = new SpriteSheet("ressources/images/test/sprite_heros_tir_droite.png",30,30);
        tirG = new SpriteSheet("ressources/images/test/sprite_heros_tir_gauche.png",30,30);
        herosMort = new SpriteSheet("ressources/images/test/heros_cadavre.png",30,30);
        sautD = new SpriteSheet("ressources/images/test/heros_saut_droite.png",30,30);
        sautG = new SpriteSheet("ressources/images/test/heros_saut_gauche.png",30,30);
        
        gameOver = new SpriteSheet("ressources/images/gameOver.png",501,59);
        gameOverAnimation= new Animation(gameOver,200);
        droiteSaut = new Animation(sautD,200);
        gaucheSaut = new Animation(sautG,200);
        droite = new Animation(mvtD, 200);
        gauche = new Animation(mvtG, 200);
        droiteArret = new Animation(herosD, 200);
        gaucheArret = new Animation(herosG, 200);
        droiteTir = new Animation(tirD,500);
        gaucheTir = new Animation(tirG,500);
        mort = new Animation(herosMort,200);
        herosAnimation = new Animation(herosD, 200);
        img = new Image("ressources/images/heros.png");
        x = 100;
        y = 0;
        x1 = x + herosAnimation.getWidth();
        y1 = y + herosAnimation.getHeight();
        niveau = 1;
        setVie(3);
        munitions = 12;
        tempsInvincible = System.currentTimeMillis();
        imgXp = new Image("ressources/images/xp.png");
        imgXpMax = new Image("ressources/images/barreXp.png");
        
        xp=0;
        xpMax=100;
       }

    public Image getImg(){return img;}
    
    //Méthode d'affichage de l'image du héros
    public void affiche(GameContainer gc, Graphics g) throws SlickException {
        herosAnimation.draw(x, y);
       //g.drawImage(img, x, y);
       g.drawImage(imgVie, 10, 10);
       g.drawString(munitions+"/"+chargeur,10,80);
       g.drawString(niveau+"",235,5);
       /*
       String txtDate=new SimpleDateFormat("HH:mm").format(new Date() );
       g.drawString(txtDate,10,150);
       import java.util.Date;
       import java.text.SimpleDateFormat;
       */
       if (VieMort == false){
           //g.drawString("Tu es mort !", 200,200);
           gameOverAnimation.draw(150,200);
       }
       
       if ( recharge == true){
           rechargeAnimation.draw(x, y-40);
       }
       if ( enLevelUp == true){
           levelUpAnimation.draw(x-10,y-60);
       }
    }
    
    public void vieHeros() throws SlickException{
        if(getVie() >= 3){
            imgVie = new Image("ressources/images/vie3.png");
            setVie(3);
        }
        else if (getVie() ==2 ){
            imgVie = new Image("ressources/images/vie2.png");
        }
        else if (getVie() ==1){
            imgVie = new Image("ressources/images/vie1.png");
        }
        else if (getVie()<=0 ){
            imgVie = new Image("ressources/images/vie0.png");
            VieMort = false;
            herosAnimation = mort;
        }
    }


    
    
    public void deplacements(GameContainer gc, int temps, ListePlateforme listePlateforme){
        Input input = gc.getInput(); //Variable de type entrée
        
        if( input.isKeyDown(Input.KEY_RIGHT) && VieMort){ // Si la variable pressée est flèche droite alors on déplace le héros à droite
            if ( getX1() < 799){
                x += 4;
                x1 = x + img.getWidth();
                vue = true;
                herosAnimation = droite;
                herosAnimation.update(temps);
                enMarche = true;
            }
        }
        
        else if( input.isKeyDown(Input.KEY_LEFT) && VieMort){ // Si la variable pressée est flèche gauche alors on déplace le héros à gauche
            if ( getX() > 1){
                x -= 4;
                x1 = x + img.getWidth();
                vue = false;
                herosAnimation = gauche;
                herosAnimation.update(temps);
                enMarche = true;
            }
        }
        else
                enMarche = false;
        
        if (vue == true && enMarche == false){
            herosAnimation = droiteArret;
            herosAnimation.update(temps);
        }
        if (vue == false && enMarche == false){
            herosAnimation = gaucheArret;
            herosAnimation.update(temps);
        
        }
        if (vue ==true && enTir==true){
            herosAnimation = droiteTir;
            herosAnimation.update(temps);
        }
        if (vue ==false && enTir==true){
            herosAnimation = gaucheTir;
            herosAnimation.update(temps);
        }
            
        // PHASE DE SAUT
        sauter = true;
        for (Plateforme p : listePlateforme.getListe()) {
            if (collisionBas(p)) sauter = false;
        }
        if (sauter) {  
            if (vue == true){
                herosAnimation = droiteSaut;
                herosAnimation.update(temps);
            }
            else {
                herosAnimation = gaucheSaut;
                herosAnimation.update(temps);
            }
        }
        
        // Changer la valeur avant le temps réduit la hauteur du saut.
        if( input.isKeyDown(Input.KEY_UP) && !sauter && VieMort) {// Si on presse ArrowUp et que sauter est faux le personnage peut sauter
            vitesseVertical = -0.5f * temps;     // Donc on créer une "Vitesse de déplacement" en fonction du temps
            y += vitesseVertical;                // Et la position de notre héros prend la valeur de la vitesse de déplacement
            y1 = y + img.getHeight();
        }
    
        if (sauter){
            vitesseVertical += 0.01f * temps; // Même procédé que pour le saut mais fait en sorte de faire tomber le héros tout le temps
            y += vitesseVertical;
            y1 = y + img.getHeight();
        }
       
        for (Plateforme p : listePlateforme.getListe()) {
            if (y < 0) {
                y = 0;
                vitesseVertical = 0;
            }            
            if (collisionHaut(p)) {
                setY(p.getY1());
                y1 = y + img.getHeight();
                vitesseVertical = 0;
            }
            if (collisionBas(p)) {
                setY(p.getY() - img.getHeight());
                y1 = y + img.getHeight();
            }
        }         
      }
    
    
    public boolean collisions( Plateforme plate){
        if ( y1 < plate.getY() ) return false;
        if ( x1 < plate.getX() ) return false;
        if ( y > plate.getY1() ) return false;
        if ( x > plate.getX1() ) return false; 
        vitesseVertical=0;
        return true;
    }

    //Return true si le bas du personnage est en collision avec une plateforme
    public boolean collisionBas(Plateforme p) {
        return (y1 >= p.getY() && y < p.getY()) && (!(x1 < p.getX() || x > p.getX1()));
    }
    //Return true si le haut du personnage est en collision avec une plateforme
    public boolean collisionHaut(Plateforme p) {
        return (y <= p.getY1() && y1 > p.getY1()) && (!(x1 < p.getX() || x > p.getX1()));
    }

    //METHODES pour ATTAQUER
    public void tirer (GameContainer gc, ListeProjectile lp, ListeArme la, int temps) throws SlickException{
         Input input = gc.getInput(); //Variable de type entrée
         munitions = la.getArme().getMunition();
             if ( (System.currentTimeMillis() - tempsTir) < la.getArme().getTempsTir() )
                 enTir = true;
             // Le joueur ne peut tirer si il recharge
             if (input.isKeyDown(Input.KEY_SPACE) && recharge != true && VieMort ==true && enTir != true ){  //input.isMousePressed(Input.MOUSE_LEFT_BUTTON)
                tempsTir = System.currentTimeMillis();  
                lp.add(this,la.getArme()); //Ajout d'un projectile
                la.getArme().setMunition( la.getArme().getMunition()-1);
                enTir =true;   
             }
             else
                 enTir = false;
             
             // Si le joueur appuie sur R et qu'il n'est pas déjà en train de recharger => rechargement du chargeur
             // Si le joueur tombe à cours de munitions et qu'il n'est pas en train de recharger => rechargement du chargeur
             // On ajoute une petite animation lors du rechargement du chargeur
            if (input.isKeyPressed(Input.KEY_R) && recharge != true || la.getArme().getMunition() <=0 && recharge !=true){
                if (la.getArme().getMunition() == chargeur){       // Cette condition empêche de recharger lorsque les munitions sont au max                           
                }
                else{
                    tempsRechargement = System.currentTimeMillis();
                    rechargeSheet = new SpriteSheet("ressources/images/barillet.png",30,30);
                    rechargeAnimation = new Animation(rechargeSheet, 200);
                }
            }
            if (input.isKeyPressed(Input.KEY_E)){
                  this.setVie(getVie()-1);      
            }
            
            // Si il s'est écoulé 3 sec depuis le début du rechargement alors le joueur peut de nouveau tirer
            if ( (System.currentTimeMillis() - tempsRechargement) < la.getArme().getTempsRechargement() ){
                recharge = true;
                // Attend 2.5sec avant d'afficher le chargeur rechargé => plus de réalisme
                if ( (System.currentTimeMillis() - tempsRechargement) > la.getArme().getTempsRechargement() -500 )
                    la.getArme().setMunition(la.getArme().getChargeur());   
            }
            else
                recharge = false; 
    }
     
    public void perdVie(int degats)
    {
        if (System.currentTimeMillis() - tempsInvincible > 3000)
        {
            setVie(getVie() -1);
            tempsInvincible = System.currentTimeMillis();
        }
    }
    public void armeSelection(GameContainer gc, ListeArme listeArmes){
        Input input = gc.getInput(); //Variable de type entrée
        
        if (input.isKeyPressed(Input.KEY_RSHIFT) && recharge != true){
            listeArmes.selectionArme();
            munitions = listeArmes.getArme().getChargeur();
        }
        chargeur = listeArmes.getArme().getChargeur();
        
    }

    
    public void afficheXp(GameContainer gc, Graphics g) throws SlickException {
        g.drawImage(imgXpMax,148, 7);// Image de fond de la barrexP
        float coefXp = xpMax / 187f; // Entre la taille en px de la barre d'xp et l'xpMax
        float iMax = xp / coefXp;    // iMax = la valeur en pixel de l'xp du personnage
        
        // On affiche jusqu'à la valeur en pixel du personnage
        for (float i=0; i < iMax ; i++){
            g.drawImage(imgXp, 150+i, 10); // Image de 1xp qui représente l'xp que le héros possède
        }  
    }
    
    public void NiveauUp() throws SlickException{
        if( getXp() >= getXpMax() ){
            tempsLevelUp = System.currentTimeMillis();
            levelUp = new SpriteSheet("ressources/images/sprite_levelUp.png",60,60);
            levelUpAnimation = new Animation(levelUp,150);
            setXp( getXp() - getXpMax());
            setXpMax( getXpMax()+100);
            setNiveau( getNiveau() +1 );
            setVie(getVie()+1);
        }
        
        if ( (System.currentTimeMillis() - tempsLevelUp) < 2000)
            enLevelUp=true;
        else
            enLevelUp=false;
        
    }
    
    public int getXpMax(){return xpMax;}
    public void setXpMax(int xpMax){this.xpMax=xpMax;}
}
