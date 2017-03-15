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
import modele.metier.Rapport;

/**
 *
 * @author llusson
 */
public class DaoRapport {

    public static Rapport selectRapportByNum(int codeRapport) throws SQLException {
        Rapport unRapport = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM RAPPORT_VISITE WHERE RAP_NUM= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, codeRapport);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String matricule = rs.getString("VIS_MATRICULE");
            int numRapport = rs.getInt("RAP_NUM");
            int numPrat = rs.getInt("PRA_NUM");
            Date date = rs.getDate("RAP_DATE");
            String bilan = rs.getString("RAP_BILAN");
            String motif = rs.getString("RAP_MOTIF");
            unRapport = new Rapport(matricule, numRapport, numPrat, date, bilan, motif);
        }
        return unRapport;
    }

    public static List<Rapport> selectAll() throws SQLException {
        List<Rapport> lesRapports = new ArrayList<Rapport>();
        Rapport unRapport;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        //préparer la requête
        String requete = "SELECT * FROM RAPPORT_VISITE";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            String matricule = rs.getString("VIS_MATRICULE");
            int numRapport = rs.getInt("RAP_NUM");
            int numPrat = rs.getInt("PRA_NUM");
            Date date = rs.getDate("RAP_DATE");
            String bilan = rs.getString("RAP_BILAN");
            String motif = rs.getString("RAP_MOTIF");
            unRapport = new Rapport(matricule, numRapport, numPrat, date, bilan, motif);
            lesRapports.add(unRapport);
        }
        return lesRapports;
    }
//    
}
