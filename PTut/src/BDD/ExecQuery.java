package BDD;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExecQuery {
    public ExecQuery() {
        //Constructeur vide, bah oui ya pas d'attributs !
    }
    
    //Mettre ici toutes les requêtes à exécuter
    public void execQuery() {
        try {
            Requete rq = new Requete();
                
            //rq.request("DROP TABLE CARTE_GALAXIE;");
            rq.request("CREATE TABLE CARTE_GALAXIE(ID NUMBER, IMG VARCHAR2(40), NBPLANETE NUMBER, "
                    + "CONSTRAINT PK_PLANETE PRIMARY KEY (ID));");
            rq.request("INSERT INTO CARTE_GALAXIE VALUES(0, 'ressources/images/fondcartegal0.jpg', 5);");
            rq.request("INSERT INTO CARTE_GALAXIE VALUES(1, 'ressources/images/fondcartegal1.jpg', 3);");
            rq.request("INSERT INTO CARTE_GALAXIE VALUES(2, 'ressources/images/fondcartegal2.jpg', 2);");

            rq.request("DROP TABLE PLANETE;");
            rq.request("CREATE TABLE PLANETE(ID NUMBER, MAP NUMBER, X NUMBER, Y NUMBER, "
                    + "IMG VARCHAR2(40), "
                    + "CONSTRAINT PK_PLANETE PRIMARY KEY (ID), "
                    + "CONSTRAINT FK_PLANETE FOREIGN KEY (MAP) REFERENCES CARTE_GALAXIE(ID));");
            rq.request("INSERT INTO PLANETE VALUES(0, 0, 50, 50, 'ressources/images/p0.png');");
            rq.request("INSERT INTO PLANETE VALUES(1, 0, 200, 10, 'ressources/images/p1.png');");
            rq.request("INSERT INTO PLANETE VALUES(2, 0, 600, 100, 'ressources/images/p2.png');");
            rq.request("INSERT INTO PLANETE VALUES(3, 0, 300, 400, 'ressources/images/p3.png');");
            rq.request("INSERT INTO PLANETE VALUES(4, 0, 10, 500, 'ressources/images/p4.png');");
            rq.request("INSERT INTO PLANETE VALUES(5, 1, 400, 50, 'ressources/images/p5.png');");
            rq.request("INSERT INTO PLANETE VALUES(6, 1, 100, 500, 'ressources/images/p6.png');");
            rq.request("INSERT INTO PLANETE VALUES(7, 1, 650, 280, 'ressources/images/p7.png');");
            rq.request("INSERT INTO PLANETE VALUES(8, 2, 320, 400, 'ressources/images/p8.png');");
            rq.request("INSERT INTO PLANETE VALUES(9, 2, 15, 15, 'ressources/images/p9.png');");

            rq.request("DROP TABLE DETAILS_PLANETE;");
            rq.request("CREATE TABLE DETAILS_PLANETE(ID NUMBER, OXYGENE NUMBER, TEMPERATURE NUMBER, "
                    + "PITEMNEED VARCHAR2(40), DITEMNEED VARCHAR2(40), NOM VARCHAR2(40), POSSEDEE NUMBER, "
                    + "CONSTRAINT PK_DETAILSPLANETE PRIMARY KEY (ID));");
            rq.request("INSERT INTO DETAILS_PLANETE VALUES(0, 23, 25, '', '', 'Cartez', 0);");
            rq.request("INSERT INTO DETAILS_PLANETE VALUES(1, 23, 56, 'Combinaison Refroidissante', '', 'Chalr', 0);");
            rq.request("INSERT INTO DETAILS_PLANETE VALUES(2, 23, -15, 'Combinaison Chauffante', '', 'Fraom', 0);");
            rq.request("INSERT INTO DETAILS_PLANETE VALUES(3, 23, 25, '', '', 'Gorphei', 0);");
            rq.request("INSERT INTO DETAILS_PLANETE VALUES(4, 2, 25, 'Masque à Oxygène', 'Bouteille d''Oxygène', 'Gazos', 0);");
            rq.request("INSERT INTO DETAILS_PLANETE VALUES(5, 23, 25, '', '', 'Noidea', 0);");
            rq.request("INSERT INTO DETAILS_PLANETE VALUES(6, 23, 25, '', '', 'Dontno', 0);");
            rq.request("INSERT INTO DETAILS_PLANETE VALUES(7, 23, 25, '', '', 'Ouate', 0);");
            rq.request("INSERT INTO DETAILS_PLANETE VALUES(8, 23, 25, '', '', 'Unnamed', 0);");
            rq.request("INSERT INTO DETAILS_PLANETE VALUES(9, 23, 25, '', '', 'Unknown', 0);");

            rq.request("DROP TABLE TELEPORTEUR;");
            rq.request("CREATE TABLE TELEPORTEUR(ID NUMBER, IDMAP NUMBER, IDMAPDEST NUMBER, X NUMBER, Y NUMBER, "
                    + "XDEST NUMBER, YDEST NUMBER, "
                    + "CONSTRAINT PK_TELEP PRIMARY KEY (ID), "
                    + "CONSTRAINT FK_MAP FOREIGN KEY (IDMAP) REFERENCES CARTE_GALAXIE(ID), "
                    + "CONSTRAINT FK_MAPDEST FOREIGN KEY (IDMAPDEST) REFERENCES CARTE_GALAXIE(ID));");
            rq.request("INSERT INTO TELEPORTEUR VALUES(0, 0, 1, 550, 5, 535, 520);");
            rq.request("INSERT INTO TELEPORTEUR VALUES(1, 0, 2, 550, 575, 535, 30);");
            rq.request("INSERT INTO TELEPORTEUR VALUES(2, 1, 0, 550, 575, 535, 30);");
            rq.request("INSERT INTO TELEPORTEUR VALUES(3, 2, 0, 550, 5, 535, 520);");
            
            rq.request("DROP TABLE MOB;");
            rq.request("CREATE TABLE MOB(ID NUMBER, VIE NUMBER, IMG VARCHAR2(40), "
                    + "CONSTRAINT MOB PRIMARY KEY (ID));");
            rq.request("INSERT INTO MOB VALUES(1, 100, 'ressources/images/mob1.png');");
            rq.request("INSERT INTO MOB VALUES(2, 150, 'ressources/images/mob2.png');");
            rq.request("INSERT INTO MOB VALUES(3, 200, 'ressources/images/fantome.png');");
            rq.request("INSERT INTO MOB VALUES(4, 500, 'ressources/images/sprite_heros_arret_gauche.png');");
            
            rq.closeDB();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ExecQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
