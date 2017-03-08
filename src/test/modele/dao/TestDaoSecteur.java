package test.modele.dao;

import java.sql.*;
import java.util.List;
import modele.dao.DaoLabo;
import modele.dao.DaoSecteur;
import modele.dao.Jdbc;
import modele.metier.Labo;
import modele.metier.Secteur;

/**
 *
 * @author btssio
 */
public class TestDaoSecteur {

    public static void main(String[] args) {

        java.sql.Connection cnx = null;

        try {
            test0_Connexion();
            System.out.println("Test0 effectué : connexion\n");
            test1_SelectUnique("N");
            System.out.println("Test1 effectué : sélection unique (Labo via code)\n");
//            test2_SelectNomUnique("BC");
//            System.out.println("Test1 effectué : sélection unique (nom Labo via code)\n");
            test3_SelectMultiple();
            System.out.println("Test1 effectué : sélection multiple \n");
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
     * Affiche un labo d'après son matricule
     *
     *@param visMatricule numero de matricule d'un labo
     * @throws SQLException
     */
    public static void test1_SelectUnique(String visMatricule) throws SQLException {
        Secteur ceSecteur = DaoSecteur.selectSecByCode(visMatricule);
        System.out.println("Labo de matricule : "+ visMatricule +" : "+ceSecteur.toString());
    }
    
//    /**
//     * Affiche le nom d'un labo d'après son matricule
//     *
//     *@param visMatricule numero de matricule d'un visiteur
//     * @throws SQLException
//     */
//    public static void test2_SelectNomUnique(String visMatricule) throws SQLException {
//        String ceLabo = DaoLabo.selectNomLabByCode(visMatricule);
//        System.out.println("Nom du labo de matricule : "+ visMatricule +" : "+ceLabo);
//    }

    /**
     * Affiche le nom d'un labo d'après son matricule
     *
     *@param visMatricule numero de matricule d'un visiteur
     * @throws SQLException
     */
    public static void test3_SelectMultiple() throws SQLException {
        List<Secteur> cesSecteurs = DaoSecteur.selectAll();
        System.out.println("Liste des laboratoires : "+cesSecteurs);
    }

}
