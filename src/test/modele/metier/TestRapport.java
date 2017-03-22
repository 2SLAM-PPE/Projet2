package test.modele.metier;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.metier.Rapport;

/**
 * Test unitaire de la classe Rapport
 *
 * @author btssio
 */
public class TestRapport {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Rapport rapp = null;
        System.out.println("\nTest n°1 : instanciation et accesseurs");

        try {
            java.util.Date uDate = sdf.parse("15/12/1993");
            java.sql.Date sDate = new java.sql.Date(uDate.getTime());
            rapp = new Rapport("Matricule", 10, 10, sDate, "Bilan", "Motif");
        } catch (ParseException ex) {
            Logger.getLogger(TestVisiteur.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(rapp);
        System.out.println("\nTest n°2 : mutateurs");
        rapp.setMatriculeVisiteur("Matricule2");
        rapp.setNumeroRapport(11);
        rapp.setNumeroPraticien(12);

        try {
            java.util.Date uDate2 = sdf.parse("01/01/2001");
            java.sql.Date sDate2 = new java.sql.Date(uDate2.getTime());
            rapp.setDateRapport(sDate2);
        } catch (ParseException ex) {
            Logger.getLogger(TestVisiteur.class.getName()).log(Level.SEVERE, null, ex);
        }
        rapp.setBilanRapport("Bilan2");
        rapp.setMotifRapport("Motif2");
        System.out.println(rapp);
    }
}
