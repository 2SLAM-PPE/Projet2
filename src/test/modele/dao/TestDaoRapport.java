package test.modele.dao;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.Position;
import modele.dao.DaoRapport;
import modele.dao.Jdbc;
import modele.metier.Rapport;
import test.modele.metier.TestVisiteur;

/**
 *
 * @author llusson
 */
public class TestDaoRapport {

    public static void main(String[] args) {

        java.sql.Connection cnx = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date dateRap = null;
            String matricule = "a131";
            int numRap = 10;
            int numPrat = 23;
            try {
                java.util.Date utilStartDate = sdf.parse("15/12/1993");
                dateRap = new java.sql.Date(utilStartDate.getTime());
            } catch (ParseException ex) {
                Logger.getLogger(TestVisiteur.class.getName()).log(Level.SEVERE, null, ex);
            }
            String bilan = "bilan";
            String motif = "motif";
            test0_Connexion();
            System.out.println("Test0 effectué : connexion\n");
            test1_SelectUnique(3);
            System.out.println("Test1 effectué : sélection unique (Rapport via numéro)\n");
            test2_SelectMultiple();
            System.out.println("Test2 effectué : sélection multiple \n");
            test3_AjoutRapport(matricule, numRap, numPrat, dateRap, bilan, motif);
            System.out.println("Test3 effectué : ajout d'un rapport \n");
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
        System.out.println("Rapport de numéro : " + numRapport + " : " + ceRapport.toString());
    }

    /**
     * Affiche les informations de tous les rapports
     *
     * @throws SQLException
     */
    public static void test2_SelectMultiple() throws SQLException {
        List<Rapport> cesRapports = DaoRapport.selectAll();
        System.out.println("Liste des Rapports : " + cesRapports);
    }

    public static void test3_AjoutRapport(String matriculeVisiteur, int numeroRapport, int numeroPraticien, java.sql.Date dateRapport, String bilanRapport, String motifRapport) throws SQLException {
        DaoRapport.addRapport(matriculeVisiteur, numeroRapport, numeroPraticien, dateRapport, bilanRapport, motifRapport);

    }

}
