package Carte;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Cellule {
    private Coordonnee coord; //Coordonnées de la cellule
    private ContenuCellule contenu; //Contenu de la cellule (voir enum)
    private String cheminAccesImage; //Chemin d'accès de l'image à charger lors de l'affichage
    final int TAILLE_CELL = 20; //Constante : taille d'une cellule (en pixel)
    
    //Constructeur par défaut
    public Cellule() throws CoordonneeException {
        coord = new Coordonnee(); //Coordonnee avec valeurs par défaut
        contenu = ContenuCellule.VIDE; //Par défaut, on décide que c'est une case vide
        cheminAccesImage = recupCheminAcces(); //On recup l'image à afficher en fonction du contenu
    }
    
    //Plusieurs constructeurs, on peut en avoir besoin, on verra
    public Cellule(int x, int y) throws CoordonneeException {
        coord = new Coordonnee(x, y);
        contenu = ContenuCellule.VIDE;
        cheminAccesImage = recupCheminAcces();
    }
    
    public Cellule(int x, int y, ContenuCellule cont) throws CoordonneeException {
        coord = new Coordonnee(x, y);
        contenu = cont;
        cheminAccesImage = recupCheminAcces();
    }
    
    public Cellule(Coordonnee c) throws CoordonneeException {
        coord = new Coordonnee(c);
        contenu = ContenuCellule.VIDE;
        cheminAccesImage = recupCheminAcces();
    }
    
    public Cellule(Coordonnee c, ContenuCellule cont) throws CoordonneeException {
        coord = new Coordonnee(c);
        contenu = cont;
        cheminAccesImage = recupCheminAcces();
    }
    
    //Constructeur par recopie
    public Cellule(Object o) throws CelluleException, CoordonneeException {
        /*
         * Si l'objet passé en paramètre n'est pas de type cellule, on génère une exception
         * sinon on converti l'objet en cellule et on recopie les valeurs
         */
        if (!(o instanceof Cellule))
            throw new CelluleException("L'objet n'est pas une cellule.");
        
        Cellule c = (Cellule) o;
        coord = new Coordonnee(c.getCoordonnee());
        contenu = c.getContenu();
        cheminAccesImage = c.getCheminAccesImage();
    }
    
    //Getters
    public Coordonnee getCoordonnee() { return coord; }
    public ContenuCellule getContenu() { return contenu; }
    public String getCheminAccesImage() { return cheminAccesImage; }
    
    //Récupère le chemin d'accès de l'image correspondant au contenu de la cellule
    public String recupCheminAcces() {
        switch (contenu) {
            case VIDE:
                return "ressources/images/case_vide.bmp"; //A remplacer par le chemin d'accès lorsqu'on en aura un
            case PLANETE:
                return "ressources/images/case_planete.bmp"; //A remplacer par le chemin d'accès lorsqu'on en aura un
            case INACTIVE:
                return "ressources/images/case_inactive.bmp"; //A remplacer par le chemin d'accès lorsqu'on en aura un
            default:
                return "ressources/images/case_vide.bmp"; //A remplacer par le chemin d'accès d'une case vide ou inactive a voir
        }
    }
    
    //Setters
    public void setContenu(ContenuCellule cont) {
        //On change le contenu et on met à jour le chemin d'accès vers l'image à afficher
        contenu = cont;
        cheminAccesImage = recupCheminAcces(); 
    }
    
    public void setCoordonnee(Object o) throws CoordonneeException {
        coord.setCoordonnee(o);
    }
    
    public void setCoordonnee(int x, int y) throws CoordonneeException {
        coord.setCoordonnee(x, y);
    }
    
    public void setX(int x) throws CoordonneeException {
        coord.setX(x);
    }
    
    public void setY(int y) throws CoordonneeException {
        coord.setY(y);
    }
    
    //Permet d'afficher la cellule à l'écran
    public void affiche(GameContainer gc, Graphics g) throws SlickException {
        /*
         * JE SAIS PAS ENCORE COMMENT QU'ON FAIT, CA DOIT ETRE UN TRUC DE CE STYLE.
         * APRES QUELQUES TEST VISIBLEMENT CA MARCHE, A VERIFIER QUAND MEME, POSSIBLE SOURCE
         * D'ERREURS !
         */
        //On charge l'image correspondant à la cellule (grâce au chemin d'accès)
        Image img = new Image(cheminAccesImage); 
        //On défini les positions en X et en Y (en pixel), en multipliant la coordonnée de la case
        //par la taille d'une case
        int posX = coord.getX() * TAILLE_CELL; 
        int posY = coord.getY() * TAILLE_CELL;
        //On affiche l'image à la position voulue
        g.drawImage(img, posX, posY);
    }
}
