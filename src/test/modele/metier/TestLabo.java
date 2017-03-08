package test.modele.metier;

import modele.metier.Visiteur;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.metier.Labo;
import modele.metier.Secteur;

/**
 * Test unitaire de la classe Adresse
 *
 * @author btssio
 */
public class TestLabo {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Visiteur vis;
        Labo lab;
        Secteur sec;
        vis = null;
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        try {
            lab = new Labo( "TE","secteurTEST","chefTEST");
            sec = new Secteur( "NW","Nord Ouest");
            vis = new Visiteur("a17", "Andre", "David", "1 r Aimon de Chissée", "38100", "Grenoble", sdf.parse("15/04/20014"), sec, lab);
        } catch (ParseException ex) {
            Logger.getLogger(TestLabo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(vis);
        System.out.println("\nTest n°2 : mutateurs");
        vis.setAdresse("56 boulevard de la Prairie aux Ducs");
        vis.setCp("44265");
        vis.setVille("Nantes");
        System.out.println(vis);
    }
}
