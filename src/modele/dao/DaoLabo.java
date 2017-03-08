/*
 * DaoAdresse
 * @author btssio
 * @version 15/04/2014
 */
package modele.dao;

import modele.metier.Labo;
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
public class DaoLabo {

    /**
     * Extraction d'une adresse, sur son identifiant
     *
     * @param visMatricule identifiant
     * @return objet Adresse
     * @throws SQLException
     */
    public static String selectNomLabByCode(String codeLab) throws SQLException {
        String nomLab = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        String requete = "SELECT LAB_NOM FROM SECTEUR WHERE LAB_CODE = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, codeLab);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            nomLab = rs.getString("LAB_NOM");
        }
        return nomLab;
    }

    public static Labo selectLabByCode(String codeLab) throws SQLException {
        Labo unLabo = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM LABO WHERE LAB_CODE= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, codeLab);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String nom = rs.getString("LAB_NOM");
            String code = rs.getString("LAB_CODE");
            String chefvente = rs.getString("LAB_CHEFVENTE");
            unLabo = new Labo(code, nom, chefvente);
        }
        return unLabo;
    }

    public static List<Labo> selectAll() throws SQLException {
        List<Labo> lesLabos = new ArrayList<Labo>();
        Labo unLabo;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        //préparer la requête
        String requete = "SELECT * FROM LABO";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            String code = rs.getString("LAB_CODE");
            String nom = rs.getString("LAB_NOM");
            String chefVente = rs.getString("LAB_CHEFVENTE");
            unLabo = new Labo(code, nom, chefVente);
            lesLabos.add(unLabo);
        }
        return lesLabos;
    }
//    
}
