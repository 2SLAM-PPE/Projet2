package modele.metier;

import java.util.Date;

/**
 * Classe représentant les visiteurs medicaux de GSB
 *
 * @author btssio
 * @version 1.0 :
 *
 */
public class Secteur {

    private String SEC_CODE;
    private String SEC_LIBELLE;

/**
 * 
 * @param code
 * @param libelle
 */
    public Secteur(String code, String libelle) {
        this.SEC_CODE = code;
        this.SEC_LIBELLE = libelle;
    }

    public String getCodeSec() {
        return SEC_CODE;
    }

    public void setCodeSec(String SEC_CODE) {
        this.SEC_CODE = SEC_CODE;
    }

    public String getLibSec() {
        return SEC_LIBELLE;
    }

    public void setLibSec(String SEC_LIBELLE) {
        this.SEC_LIBELLE = SEC_LIBELLE;
    }

    /**
     *
     * @return String attributs de l'adresse
     */
    @Override
    public String toString() {
        return ("Secteur{code: " + this.getCodeSec() + "\tlibelle: " + this.getLibSec() + "}");
    }

}
