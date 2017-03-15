package test.modele.metier;

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
            rapp = new Rapport("Matricule", 10, 10, sdf.parse("15/12/1993"), "Bilan", "Motif");
        } catch (ParseException ex) {
            Logger.getLogger(TestVisiteur.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(rapp);
        System.out.println("\nTest n°2 : mutateurs");
        rapp.setMatriculeVisiteur("Matricule2");
        rapp.setNumeroRapport(11);
        rapp.setNumeroPraticien(12);
        try {
            rapp.setDateRapport(sdf.parse("01/01/2001"));
        } catch (ParseException ex) {
            Logger.getLogger(TestVisiteur.class.getName()).log(Level.SEVERE, null, ex);
        }
        rapp.setBilanRapport("Bilan2");
        rapp.setMotifRapport("Motif2");
        System.out.println(rapp);
    }
}
