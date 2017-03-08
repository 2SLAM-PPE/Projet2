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
    public static String selectNomSecByCode(String codeSecteur) throws SQLException {
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
    public static Secteur selectSecByCode(String codeLab) throws SQLException {
        Secteur unSecteur = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM SECTEUR WHERE SEC_CODE= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, codeLab);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String code = rs.getString("SEC_CODE");
            String libelle = rs.getString("SEC_LIBELLE");
            unSecteur = new Secteur(code, libelle);
        }
        return unSecteur;
    }
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
