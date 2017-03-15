package test.modele.dao;

import java.sql.*;
import java.util.List;
import modele.dao.DaoVisiteur;
import modele.dao.Jdbc;
import modele.metier.Visiteur;

/**
 *
 * @author btssio
 */
public class TestDaoVisiteur {

    public static void main(String[] args) {

        java.sql.Connection cnx = null;

        try {
            test0_Connexion();
            System.out.println("Test0 effectué : connexion\n");
            test1_SelectUnique("a17");
            System.out.println("Test1 effectué : sélection unique\n");
            test2_SelectMultiple();
            System.out.println("Test2 effectué : sélection multiple\n");
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur de pilote JDBC : " + e);
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e);
        } finally {
            try {
                if (cnx != null) {
                    cnx.close();
                }
            } catch (SQLException e) {
                System.err.println("Erreur de fermeture de la connexion JDBC : " + e);
            }
        }

    }

    /**
     * Vérifie qu'une connexion peut être ouverte sur le SGBD
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void test0_Connexion() throws ClassNotFoundException, SQLException {
 //         Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:://", "localhost/", "AGENCEB", "agenceb_util", "secret");
        Jdbc.creer("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:", "@localhost:1521:XE", "", "ppe", "ppe");
        Jdbc.getInstance().connecter();
        Connection cnx = Jdbc.getInstance().getConnexion();
    }

    /**
     * Affiche un visiteur d'après son matricule
     *
     *@param visMatricule numero de matricule d'un visiteur
     * @throws SQLException
     */
    public static void test1_SelectUnique(String visMatricule) throws SQLException {
        Visiteur ceVisiteur = DaoVisiteur.selectOne(visMatricule);
        System.out.println("Visiteur de matricule : "+ visMatricule +" : "+ceVisiteur.toString());
    }
    /**
     * Affiche tous les visiteurs
     *
     * @throws SQLException
     */
    public static void test2_SelectMultiple() throws SQLException {
        List<Visiteur> cesVisiteurs = DaoVisiteur.selectAll();
        System.out.println("Visiteurs : "+cesVisiteurs.toString());
    }

}
