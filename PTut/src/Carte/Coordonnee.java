package Carte;

public class Coordonnee {
    private int x; // Contient la position en abscisse
    private int y; // Contient la position en ordonnee
    final int MAX_ABSCISSE = 49; // Constante : Taille de la map en largeur (50 cases de largeur ici)
    final int MAX_ORDONNEE = 29; // Constante : Taille de la map en hauteur (30 cases de hauteur ici)
    
    //Constructeur par défaut
    public Coordonnee() {
        x = 0;
        y = 0;
    }
    
    //Constructeur en donnant deux int en arguments
    public Coordonnee(int x, int y) throws CoordonneeException {
        /*
         * Si les valeurs données ne sont pas bonnes (coordonnée négative ou supérieure au maximum),
         * on lève une exception
         */
        if (x < 0 || x > MAX_ABSCISSE || y < 0 || y > MAX_ORDONNEE)
            throw new CoordonneeException("Impossible de créer un objet avec de telles valeurs.");
        
        this.x = x;
        this.y = y;
    }
    
    /*
     * Constructeur par recopie
     * Si l'objet passé en paramètre n'est pas de type coordonnée, on lève une exception
     */
    public Coordonnee(Object o) throws CoordonneeException {
        //Si l'objet passé en paramètre est bien de type Coordonnee, on recupere ses valeurs
        if (!(o instanceof Coordonnee))
            throw new CoordonneeException("Le paramètre n'est pas de type Coordonnee !");
        
        Coordonnee c = (Coordonnee) o;
        x = c.getX();
        y = c.getY();
    }
    
    //Getters
    public int getX() { return x; }
    public int getY() { return y; }
    
    //Setters
    public void setX(int x) throws CoordonneeException {
        /* 
         * Si le x donné est supérieur au x maximal on lui donne la valeur maximale ou s'il 
         * est négatif, on lève une exception
         */
        if (x < 0 || x >= MAX_ABSCISSE) 
            throw new CoordonneeException("Cet attribut ne peut pas prendre cette valeur.");
        
        this.x = x;
    }
    
    public void setY(int y) throws CoordonneeException {
        /* 
         * Si le y donné est supérieur au x maximal on lui donne la valeur maximale ou s'il 
         * est négatif, on lève une exception
         */
        if (y < 0 || y >= MAX_ORDONNEE) 
            throw new CoordonneeException("Cet attribut ne peut pas prendre cette valeur.");
        
        this.y = y;
    }
    
    public void setCoordonnee(int x, int y) throws CoordonneeException {
        //On appelle les deux méthodes setX et setY
        setX(x);
        setY(y);
    }
    
    public void setCoordonnee(Object o) throws CoordonneeException {
        /*
         * Si l'objet passé en paramètre est bien de type Coordonnee, on appelle la 
         * fonction setCoordonnee à laquelle on donne l'abscisse et l'ordonnée de la 
         * Coordonnee passée en paramètre
         * Si l'objet n'est pas de type Coordonnee on lève une exception pour signaler l'erreur
         */
        if (!(o instanceof Coordonnee))
            throw new CoordonneeException("Le paramètre n'est pas de type Coordonnee !");
        
        Coordonnee c = (Coordonnee) o;
        this.setCoordonnee(c.getX(), c.getY());
    }
}
