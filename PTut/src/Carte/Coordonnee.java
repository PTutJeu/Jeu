package Carte;

public class Coordonnee {
    private int x; // Contient la position en abscisse
    private int y; // Contient la position en ordonnee
    
    //Constructeur par défaut
    public Coordonnee() {
        x = 0;
        y = 0;
    }
    
    //Constructeur en donnant deux int en arguments
    public Coordonnee(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    //Constructeur par recopie
    public Coordonnee(Object o) {
        //Si l'objet passé en paramètre est bien de type Coordonnee, on recupere ses valeurs
        if (o instanceof Coordonnee) {
            Coordonnee c = (Coordonnee) o;
            x = c.getX();
            y = c.getY();
        } 
        //Sinon on crée un objet avec des paramètres par défaut
        else {
            x = 0;
            y = 0;
        }
    }
    
    //Getters
    public int getX() { return x; }
    public int getY() { return y; }
    
    //Setters
    public void setX(int x) {
        /* 
         * Si le x donné est supérieur au x maximal on lui donne la valeur maximale
         * (on suppose ici que la carte fait 50 cases de largeur, donc x ne peut pas dépasser 49
         * étant donné que la première case aura pour abscisse 0)
         * De même si le x est négatif, on lui donne la valeur 0
         */
        if (x >= 50) 
            this.x = 49;
        else if (x < 0) 
            this.x = 0;
        else 
            this.x = x;
    }
    
    public void setY(int y) {
        //De même que pour setX sauf qu'on suppose que la carte fait 30 cases de hauteur
        if (y >= 30)
            this.y = 29;
        else if (y < 0)
            this.y = 0;
        else
            this.y = y;
    }
    
    public void setCoordonnee(int x, int y) {
        //On appelle les deux méthodes setX et setY
        setX(x);
        setY(y);
    }
    
    public void setCoordonnee(Object o) throws Exception {
        /*
         * Si l'objet passé en paramètre est bien de type Coordonnee, on appelle la 
         * fonction setCoordonnee à laquelle on donne l'abscisse et l'ordonnée de la 
         * Coordonnee passée en paramètre
         * Si l'objet n'est pas de type Coordonnee on lève une exception pour signaler l'erreur
         */
        if (o instanceof Coordonnee) {
            Coordonnee c = (Coordonnee) o;
            this.setCoordonnee(c.getX(), c.getY());
        }
        else {
            throw new Exception("Le paramètre n'est pas de type Coordonnee !");
        }
    }
}
