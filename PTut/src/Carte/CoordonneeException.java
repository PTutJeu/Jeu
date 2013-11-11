package Carte;

public class CoordonneeException extends Exception {
    //Constructeur par défaut : appelle le constructeur de la classe Exception
    public CoordonneeException() {
        super("Il y a une erreur dans les coordonnées données !");
    }
    
    //Constructeur avec une chaîne de caractère contenant le message à afficher en cas d'erreur
    public CoordonneeException(String msg) {
        super(msg);
    }
}
