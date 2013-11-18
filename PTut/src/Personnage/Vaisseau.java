
package Personnage;

import Carte.ContenuCellule;
import Carte.Coordonnee;


public class Vaisseau extends Personnage{
        private Coordonnee coord;//coordonnées du vaisseau
        private ContenuCellule cont;//Contenu de la cellule ou se 
        
        
        
        public ContenuCellule getCont(){ return cont;}
        
        public Coordonnee getCoord() { return coord;}
}
