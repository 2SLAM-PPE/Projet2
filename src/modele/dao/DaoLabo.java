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
    public static String selectNomByCode(String codeLab) throws SQLException {
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
//    public static Visiteur selectOne(String visMatricule) throws SQLException {
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
