package test.modele.metier;

import modele.metier.Visiteur;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Test unitaire de la classe Adresse
 *
 * @author btssio
 */
public class TestVisiteur {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Visiteur vis;
        vis = null;
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        try {
            vis = new Visiteur("a17", "Andre", "David", "1 r Aimon de Chissée", "38100", "Grenoble", sdf.parse("15/04/20014"), null, "Gyverny");
        } catch (ParseException ex) {
            Logger.getLogger(TestVisiteur.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(vis);
        System.out.println("\nTest n°2 : mutateurs");
        vis.setAdresse("56 boulevard de la Prairie aux Ducs");
        vis.setCp("44265");
        vis.setVille("Nantes");
        System.out.println(vis);
    }
}
