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
                
            rq.request("DROP TABLE CARTE_GALAXIE;");
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
                    + "GOLDMAX NUMBER, BOISMAX NUMBER, METALMAX NUMBER, GOLDPROD NUMBER, BOISPROD NUMBER, "
                    + "METALPROD NUMBER, "
                    + "CONSTRAINT PK_DETAILSPLANETE PRIMARY KEY (ID));");
            rq.request("INSERT INTO DETAILS_PLANETE VALUES(0, 23, 25, '', '', 'Cartez', 0, 20, 25, 25, 1, 1, 1);");
            rq.request("INSERT INTO DETAILS_PLANETE VALUES(1, 23, 56, 'Combinaison Refroidissante', '', 'Chalr', 0, 25, 30, 30, 1, 1, 2);");
            rq.request("INSERT INTO DETAILS_PLANETE VALUES(2, 23, -15, 'Combinaison Chauffante', '', 'Fraom', 0, 60, 0, 0, 3, 0, 0);");
            rq.request("INSERT INTO DETAILS_PLANETE VALUES(3, 23, 25, '', '', 'Gorphei', 0, 0, 40, 40, 0, 2, 2);");
            rq.request("INSERT INTO DETAILS_PLANETE VALUES(4, 2, 25, 'Masque à Oxygène', 'Bouteille d''Oxygène', 'Gazos', 0, 0, 0, 80, 0, 0, 4);");
            rq.request("INSERT INTO DETAILS_PLANETE VALUES(5, 23, 25, '', '', 'Noidea', 0, 50, 50, 50, 2, 2, 2);");
            rq.request("INSERT INTO DETAILS_PLANETE VALUES(6, 23, 25, '', '', 'Dontno', 0, 75, 75, 0, 3, 3, 0);");
            rq.request("INSERT INTO DETAILS_PLANETE VALUES(7, 23, 25, '', '', 'Ouate', 0, 60, 60, 60, 3, 3, 3);");
            rq.request("INSERT INTO DETAILS_PLANETE VALUES(8, 23, 25, '', '', 'Unnamed', 0, 80, 0, 80, 4, 0, 4);");
            rq.request("INSERT INTO DETAILS_PLANETE VALUES(9, 23, 25, '', '', 'Unknown', 0, 100, 100, 100, 4, 4, 4);");

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
                    + "CONSTRAINT PK_MOB PRIMARY KEY (ID));");
            rq.request("INSERT INTO MOB VALUES(1, 100, 'ressources/images/mob1.png');");
            rq.request("INSERT INTO MOB VALUES(2, 150, 'ressources/images/mob2.png');");
            rq.request("INSERT INTO MOB VALUES(3, 200, 'ressources/images/fantome.png');");
            rq.request("INSERT INTO MOB VALUES(4, 500, 'ressources/images/sprite_heros_arret_gauche.png');");
            
            rq.request("DROP TABLE PLATEFORME;");
            rq.request("CREATE TABLE PLATEFORME(ID NUMBER, IDPLANETE NUMBER, X NUMBER, "
                    + "Y NUMBER, IMG VARCHAR2(60), MOBILE NUMBER, "
                    + "CONSTRAINT PK_PLATEFORME PRIMARY KEY (ID), "
                    + "CONSTRAINT FK_PLATEFORME FOREIGN KEY (IDPLANETE) REFERENCES PLANETE(ID));");
            rq.request("INSERT INTO PLATEFORME VALUES (0, 0, 200, 450, 'ressources/images/plateforme.png', 0);");
            rq.request("INSERT INTO PLATEFORME VALUES (1, 0, 0, 580, 'ressources/images/sol.png', 0);");
            rq.request("INSERT INTO PLATEFORME VALUES (2, 0, 500, 230, 'ressources/images/plateforme.png', 0);");
            rq.request("INSERT INTO PLATEFORME VALUES (3, 1, 400, 450, 'ressources/images/plateforme.png', 0);");
            rq.request("INSERT INTO PLATEFORME VALUES (4, 1, 0, 580, 'ressources/images/sol.png', 0);");
            rq.request("INSERT INTO PLATEFORME VALUES (5, 2, 300, 450, 'ressources/images/plateforme.png', 0);");
            rq.request("INSERT INTO PLATEFORME VALUES (6, 2, 0, 580, 'ressources/images/sol.png', 0);");
            rq.request("INSERT INTO PLATEFORME VALUES (7, 3, 250, 440, 'ressources/images/plateforme.png', 0);");
            rq.request("INSERT INTO PLATEFORME VALUES (8, 3, 0, 580, 'ressources/images/sol.png', 0);");
            rq.request("INSERT INTO PLATEFORME VALUES (9, 4, 0, 450, 'ressources/images/plateforme.png', 0);");
            rq.request("INSERT INTO PLATEFORME VALUES (10, 4, 0, 580, 'ressources/images/sol.png', 0);");
            rq.request("INSERT INTO PLATEFORME VALUES (11, 5, 50, 450, 'ressources/images/plateforme.png', 0);");
            rq.request("INSERT INTO PLATEFORME VALUES (12, 5, 0, 580, 'ressources/images/sol.png', 0);");
            rq.request("INSERT INTO PLATEFORME VALUES (13, 6, 650, 450, 'ressources/images/plateforme.png', 0);");
            rq.request("INSERT INTO PLATEFORME VALUES (14, 6, 0, 580, 'ressources/images/sol.png', 0);");
            rq.request("INSERT INTO PLATEFORME VALUES (15, 7, 700, 450, 'ressources/images/plateforme.png', 0);");
            rq.request("INSERT INTO PLATEFORME VALUES (16, 7, 0, 580, 'ressources/images/sol.png', 0);");
            rq.request("INSERT INTO PLATEFORME VALUES (17, 8, 590, 450, 'ressources/images/plateforme.png', 0);");
            rq.request("INSERT INTO PLATEFORME VALUES (18, 8, 0, 580, 'ressources/images/sol.png', 0);");
            rq.request("INSERT INTO PLATEFORME VALUES (19, 9, 5, 450, 'ressources/images/plateforme.png', 0);");
            rq.request("INSERT INTO PLATEFORME VALUES (20, 9, 0, 580, 'ressources/images/sol.png', 0);");
            
            rq.request("DROP TABLE CORRESPPLANETEMOB;");
            rq.request("CREATE TABLE CORRESPPLANETEMOB (ID NUMBER, IDPLANETE NUMBER, IDWAVE NUMBER, TAILLEWAVE NUMBER, IDMOB NUMBER, "
                    + "CONSTRAINT PK_CORRESP PRIMARY KEY (ID), "
                    + "CONSTRAINT FK_CORRESP_PLANETE FOREIGN KEY (IDPLANETE) REFERENCES PLANETE(ID), "
                    + "CONSTRAINT FK_CORRESP_MOB FOREIGN KEY (IDMOB) REFERENCES MOB(ID));");
            rq.request("INSERT INTO CORRESPPLANETEMOB VALUES (1, 0, 1, 5, 1);");
            rq.request("INSERT INTO CORRESPPLANETEMOB VALUES (2, 0, 2, 5, 2);");
            rq.request("INSERT INTO CORRESPPLANETEMOB VALUES (3, 0, 3, 3, 3);");
            rq.request("INSERT INTO CORRESPPLANETEMOB VALUES (4, 0, 4, 1, 4);");
            rq.request("INSERT INTO CORRESPPLANETEMOB VALUES (5, 1, 1, 4, 2);");
            rq.request("INSERT INTO CORRESPPLANETEMOB VALUES (6, 1, 2, 1, 4);");
            rq.request("INSERT INTO CORRESPPLANETEMOB VALUES (7, 2, 1, 4, 2);");
            rq.request("INSERT INTO CORRESPPLANETEMOB VALUES (8, 2, 2, 1, 4);");
            rq.request("INSERT INTO CORRESPPLANETEMOB VALUES (9, 3, 1, 4, 2);");
            rq.request("INSERT INTO CORRESPPLANETEMOB VALUES (10, 3, 2, 1, 4);");
            rq.request("INSERT INTO CORRESPPLANETEMOB VALUES (11, 4, 1, 4, 2);");
            rq.request("INSERT INTO CORRESPPLANETEMOB VALUES (12, 4, 2, 1, 4);");
            rq.request("INSERT INTO CORRESPPLANETEMOB VALUES (13, 5, 1, 4, 2);");
            rq.request("INSERT INTO CORRESPPLANETEMOB VALUES (14, 5, 2, 1, 4);");
            rq.request("INSERT INTO CORRESPPLANETEMOB VALUES (15, 6, 1, 4, 2);");
            rq.request("INSERT INTO CORRESPPLANETEMOB VALUES (16, 6, 2, 1, 4);");
            rq.request("INSERT INTO CORRESPPLANETEMOB VALUES (17, 7, 1, 4, 2);");
            rq.request("INSERT INTO CORRESPPLANETEMOB VALUES (18, 7, 2, 1, 4);");
            rq.request("INSERT INTO CORRESPPLANETEMOB VALUES (19, 8, 1, 4, 2);");
            rq.request("INSERT INTO CORRESPPLANETEMOB VALUES (20, 8, 2, 1, 4);");
            
            rq.request("DROP TABLE SAVE");
            rq.request("CREATE TABLE SAVE(ID_PERSO NUMBER, TEMPS NUMBER, GOLD NUMBER, BOIS NUMBER, FER NUMBER, "
            + "CONSTRAINT PK_SAVE PRIMARY KEY (ID_PERSO));");
            rq.request("INSERT INTO SAVE VALUES(1,0,0,0,0);");
            
            rq.closeDB();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ExecQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
