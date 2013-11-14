package Carte;

public enum ContenuCellule {
    VIDE(0),
    PLANETE(1),
    INACTIVE(2);
    
    private int valeur;
    
    private ContenuCellule(int val) {
        valeur = val;
    }
    
    public String toString() {
        return Integer.toString(valeur);
    }
}
