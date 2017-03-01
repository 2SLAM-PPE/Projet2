package modele.metier;

import java.util.Date;

/**
 * Classe représentant les visiteurs medicaux de GSB
 *
 * @author btssio
 * @version 1.0 :
 *
 */
public class Labo {

    private String LAB_CODE;
    private String LAB_NOM;
    private String LAB_CHEFVENTE;
/**
 * 
 * @param matricule
 * @param nom
 * @param prenom
 */
    public Labo(String code, String nom, String chefvente) {
        this.LAB_CODE = code;
        this.LAB_NOM = nom;
        this.LAB_CHEFVENTE = chefvente;
    }

    public String getCodeLab() {
        return LAB_CODE;
    }

    public void setCodeLab(String LAB_CODE) {
        this.LAB_CODE = LAB_CODE;
    }

    public String getNomlab() {
        return LAB_NOM;
    }

    public void setNomLab(String LAB_NOM) {
        this.LAB_NOM = LAB_NOM;
    }

    public String getChefVenteLab() {
        return LAB_CHEFVENTE;
    }

    public void setChefVenteLab(String LAB_CHEFVENTE) {
        this.LAB_CHEFVENTE = LAB_CHEFVENTE;
    }
    
    /**
     *
     * @return String attributs de l'adresse
     */
    @Override
    public String toString() {
        return ("Labo{code: " + this.getCodeLab() + "\tnom: " + this.getNomlab() + "\tchef de vente: " + this.getChefVenteLab()+ "}");
    }

}
