package Carte;

public class CelluleException extends Exception {
    //Constructeur par défaut : appelle le constructeur de la classe Exception
    public CelluleException() {
        super("Erreur cellule.");
    }
    
    //Constructeur avec une chaîne de caractère contenant le message à afficher en cas d'erreur
    public CelluleException(String msg) {
        super(msg);
    }
}
