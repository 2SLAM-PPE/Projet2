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
import static modele.dao.DaoLabo.*;
import static modele.dao.DaoSecteur.*;
import modele.metier.Labo;
import modele.metier.Praticien;
import modele.metier.Secteur;

/**
 *
 * @author nicolas
 */
public class DaoPraticien {

    /**
     * Extraction d'un praticien, sur son identifiant
     *
     * @param pratMatricule identifiant
     * @return objet Praticien
     * @throws SQLException
     */
    public static Praticien selectOne(int pratMatricule) throws SQLException {
        Praticien unPraticien = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM PRATICIEN WHERE PRA_NUM= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, pratMatricule);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            int num = rs.getInt("PRA_NUM");
            String nom = rs.getString("PRA_NOM");
            String prenom = rs.getString("PRA_PRENOM");
            String adresse = rs.getString("PRA_ADRESSE");
            String cp = rs.getString("PRA_CP");
            String ville = rs.getString("PRA_VILLE");
            double coef = rs.getDouble("PRA_COEFNOTORIETE");
            String typeCode = rs.getString("TYP_CODE");
            unPraticien = new Praticien(num, nom, prenom, adresse, cp, ville, coef, typeCode);
        }
        return unPraticien;
    }

    public static List<Praticien> selectAll() throws SQLException {
        List<Praticien> lesPraticiens = new ArrayList<Praticien>();
        Praticien unPraticien;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM PRATICIEN";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int num = rs.getInt("PRA_NUM");
            String nom = rs.getString("PRA_NOM");
            String prenom = rs.getString("PRA_PRENOM");
            String adresse = rs.getString("PRA_ADRESSE");
            String cp = rs.getString("PRA_CP");
            String ville = rs.getString("PRA_VILLE");
            double coef = rs.getDouble("PRA_COEFNOTORIETE");
            String typeCode = rs.getString("TYP_CODE");
            unPraticien = new Praticien(num, nom, prenom, adresse, cp, ville, coef, typeCode);
            lesPraticiens.add(unPraticien);
        }
        return lesPraticiens;
    }

}
