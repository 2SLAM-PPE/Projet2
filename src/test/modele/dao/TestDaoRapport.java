package test.modele.dao;

import java.sql.*;
import java.util.List;
import modele.dao.DaoLabo;
import modele.dao.DaoRapport;
import modele.dao.Jdbc;
import modele.metier.Labo;
import modele.metier.Rapport;

/**
 *
 * @author llusson
 */
public class TestDaoRapport {

    public static void main(String[] args) {

        java.sql.Connection cnx = null;

        try {
            test0_Connexion();
            System.out.println("Test0 effectué : connexion\n");
            test1_SelectUnique(3);
            System.out.println("Test1 effectué : sélection unique (Rapport via numéro)\n");
            test3_SelectMultiple();
            System.out.println("Test2 effectué : sélection multiple \n");
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
        //Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:://", "localhost/", "AGENCEB", "agenceb_util", "secret");
        Jdbc.creer("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:", "@localhost:1521:XE", "", "ppe", "ppe");
        Jdbc.getInstance().connecter();
        Connection cnx = Jdbc.getInstance().getConnexion();
    }

    /**
     * Affiche un rapport d'après son numero
     *
     * @param numRapport numero d'un rapport
     * @throws SQLException
     */
    public static void test1_SelectUnique(int numRapport) throws SQLException {
        Rapport ceRapport = DaoRapport.selectRapportByNum(numRapport);
        System.out.println("Labo de matricule : " + numRapport + " : " + ceRapport.toString());
    }

    /**
     * Affiche les informations de tous les rapports
     *
     * @throws SQLException
     */
    public static void test3_SelectMultiple() throws SQLException {
        List<Rapport> cesRapports = DaoRapport.selectAll();
        System.out.println("Liste des laboratoires : " + cesRapports);
    }

}
