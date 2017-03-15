package test.modele.metier;

import modele.metier.Praticien;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Test unitaire de la classe Adresse
 *
 * @author btssio
 */
public class TestPraticien {

    public static void main(String[] args) {
        Praticien prat = null;
        System.out.println("\nTest n°1 : instanciation et accesseurs");

        prat = new Praticien(50, "nomPrat", "prenomPrat", "1 r Aimon de Chissée", "38100", "Grenoble", 40.2, "PH");

        System.out.println(prat);
        System.out.println("\nTest n°2 : mutateurs");
        prat.setAdressePraticien("56 boulevard de la Prairie aux Ducs");
        prat.setCpPraticien("44265");
        prat.setVillePraticien("Nantes");
        prat.setNomPraticien("Nemard");
        prat.setPrenomPraticien("Jean");
        prat.setCoefNotoriete(250.6);
        prat.setTypeCode("PO");
        System.out.println(prat);
    }
}
