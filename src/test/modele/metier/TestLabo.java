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
        Labo lab;
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        lab = new Labo("codeTEST", "labTEST", "chefTEST");
        System.out.println(lab);
        System.out.println("\nTest n°2 : mutateurs");
        lab.setCodeLab("codeTEST2");
        lab.setNomLab("labTEST2");
        lab.setChefVenteLab("chefTEST2");
        System.out.println(lab);
    }
}
