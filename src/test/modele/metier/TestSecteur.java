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
public class TestSecteur {

    public static void main(String[] args) {
        Secteur sec;
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        sec = new Secteur("codeTEST", "secteurTEST");
        System.out.println(sec);
        System.out.println("\nTest n°2 : mutateurs");
        sec.setCodeSec("codeTEST2");
        sec.setLibSec("labTEST2");
        System.out.println(sec);
    }
}
