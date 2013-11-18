package BDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//Classe permettant de gérer une partie des requetes pour interragir avec la base de données
public class Requete {
    private Connection c; //Connection à la base de donnée
    private Statement stmt; //Variable permettant les requetes
    
    //On aura qu'une BDD donc un constructeur par défaut suffit, il y aura toujours la même connection
    public Requete() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:test.db");
        stmt = c.createStatement();
    }
            
    /*
     * Méthode permettant de faire un select
     * Attention ! Cette méthode return un ResultSet, c'est une variable qui contient toutes les
     * lignes concernées par le select. Il faut ensuite faire une boucle pour récupérer toutes les
     * lignes. Voir tuto pour savoir comment faire
     */
    public ResultSet select(String query) throws SQLException {
        return stmt.executeQuery(query);
    }
    
    //Méthode pour faire des create table, alter table et drop table, le commit est automatique
    public void request(String query) throws SQLException {
        stmt.executeUpdate(query);
    }
    
    //Méthode pour faire des insert, des update et des delete
    public void requestAndCommit(String query) throws SQLException {
        stmt.executeUpdate(query);
        c.commit();
    }
    
    //Méthode à appeler après avoir fini d'utiliser la BDD, permet de la fermer proprement
    public void closeDB() throws SQLException {
        stmt.close();
        c.close();
    }
}
