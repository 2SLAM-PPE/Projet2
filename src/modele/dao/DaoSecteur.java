/*
 * DaoAdresse
 * @author btssio
 * @version 15/04/2014
 */
package modele.dao;

import modele.metier.Secteur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author nicolas
 */
public class DaoSecteur {

    /**
     * Extraction d'une adresse, sur son identifiant
     *
     * @param visMatricule identifiant
     * @return objet Adresse
     * @throws SQLException
     */
    public static String selectNomByCode(String codeSecteur) throws SQLException {
        String nomSecteur = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        String requete = "SELECT SEC_LIBELLE FROM SECTEUR WHERE SEC_CODE = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, codeSecteur);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            nomSecteur = rs.getString("SEC_LIBELLE");
        }
        return nomSecteur;
    }
//    public static Secteur selectOne(String visMatricule) throws SQLException {
//        Visiteur unVisiteur = null;
//        ResultSet rs;
//        PreparedStatement pstmt;
//        Jdbc jdbc = Jdbc.getInstance();
//        // préparer la requête
//        String requete = "SELECT * FROM VISITEUR WHERE VIS_MATRICULE= ?";
//        pstmt = jdbc.getConnexion().prepareStatement(requete);
//        pstmt.setString(1, visMatricule);
//        rs = pstmt.executeQuery();
//        if (rs.next()) {
//            String matricule = rs.getString("VIS_MATRICULE");
//            String nom = rs.getString("VIS_NOM");
//            String prenom = rs.getString("VIS_PRENOM");
//            String adresse = rs.getString("VIS_ADRESSE");
//            String cp = rs.getString("VIS_CP");
//            String ville = rs.getString("VIS_VILLE");
//            Date dateEmbauche = rs.getDate("VIS_DATEEMBAUCHE");
//            String codeSec = rs.getString("SEC_CODE");
//            String codeLab = rs.getString("LAB_CODE");
//            unVisiteur = new Visiteur(matricule, nom, prenom, adresse, cp, ville, dateEmbauche, codeSec, codeLab);
//        }
//        return unVisiteur;
//    }

    public static List<Secteur> selectAll() throws SQLException {
        List<Secteur> lesSecteurs = new ArrayList<Secteur>();
        Secteur unSecteur;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        //préparer la requête
        String requete = "SELECT * FROM SECTEUR";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            String code = rs.getString("SEC_CODE");
            String libelle = rs.getString("SEC_LIBELLE");
            unSecteur = new Secteur(code, libelle);
            lesSecteurs.add(unSecteur);
        }
        return lesSecteurs;
    }

}
