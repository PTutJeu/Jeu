package Carte;

/*
 * Enumération : fonctionne de façon similaire à une classe
 * Enumération contient tous les différents contenus de cellules ( => liste à compléter)
 * 
 */
public enum ContenuCellule {
    //Liste des contenus (auxquels on attribut une valeur)
    VIDE(0),
    PLANETE(1),
    INACTIVE(2);
    
    private int valeur; //Valeur identifiant un contenu
    
    //Constructeur : impérativement en private, l'utilisateur ne doit pas changer la valeur d'un contenu
    private ContenuCellule(int val) {
        valeur = val;
    }
    
    //Méthode permettant l'affichage, on affiche simplement la valeur
    public String toString() {
        return Integer.toString(valeur);
    }
}
