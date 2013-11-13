package Carte;

public enum ContenuCellule {
    VIDE(0),
    PLANETE(1),
    INACTIVE(2);
    
    private int valeur;
    
    public ContenuCellule(int val) {
        valeur = val;
    }
}
