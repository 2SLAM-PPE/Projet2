/*
 * DaoAdresse
 * @author btssio
 * @version 15/04/2014
 */
package modele.dao;

import modele.metier.Visiteur;
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
public class DaoVisiteur {

    /**
     * Extraction d'une adresse, sur son identifiant
     * @param visMatricule identifiant
     * @return objet Adresse
     * @throws SQLException 
     */
    public static Visiteur selectOne(String visMatricule) throws SQLException {
        Visiteur unVisiteur = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM VISITEUR WHERE VIS_MATRICULE= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, visMatricule);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String matricule = rs.getString("VIS_MATRICULE");
            String nom = rs.getString("VIS_NOM");
            String prenom = rs.getString("VIS_PRENOM");
            String adresse = rs.getString("VIS_ADRESSE");
            String cp = rs.getString("VIS_CP");
            String ville = rs.getString("VIS_VILLE");
            Date dateEmbauche = rs.getDate("VIS_DATEEMBAUCHE");
            String codeSec = rs.getString("SEC_CODE");
            String codeLab = rs.getString("LAB_CODE");
            unVisiteur = new Visiteur(matricule, nom, prenom, adresse, cp, ville, dateEmbauche, codeSec, codeLab);
        }
        return unVisiteur;
    }
    public static List<Visiteur> selectAll() throws SQLException {
        List<Visiteur> lesVisiteurs = new ArrayList<Visiteur>();
        Visiteur unVisiteur;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM VISITEUR";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            String matricule = rs.getString("VIS_MATRICULE");
            String nom = rs.getString("VIS_NOM");
            String prenom = rs.getString("VIS_PRENOM");
            String adresse = rs.getString("VIS_ADRESSE");
            String cp = rs.getString("VIS_CP");
            String ville = rs.getString("VIS_VILLE");
            Date dateEmbauche = rs.getDate("VIS_DATEEMBAUCHE");
            String codeSec = rs.getString("SEC_CODE");
            String codeLab = rs.getString("LAB_CODE");
            unVisiteur = new Visiteur(matricule, nom, prenom, adresse, cp, ville, dateEmbauche, codeSec, codeLab);
            lesVisiteurs.add(unVisiteur);
        }
        return lesVisiteurs;
    }
    
}
