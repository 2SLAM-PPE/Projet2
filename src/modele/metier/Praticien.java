package modele.metier;

import java.util.Date;

/**
 * Classe représentant les visiteurs medicaux de GSB
 *
 * @author btssio
 * @version 1.0 :
 *
 */
public class Praticien {

    private int numPraticien;
    private String nomPraticien;
    private String prenomPraticien;
    private String adressePraticien;
    private String cpPraticien;
    private String villePraticien;
    private double coefNotoriete;
    private String typeCode;

    public Praticien(int numPraticien, String nomPraticien, String prenomPraticien, String adressePraticien, String cpPraticien, String villePraticien, double coefNotoriete, String typeCode) {
        this.numPraticien = numPraticien;
        this.nomPraticien = nomPraticien;
        this.prenomPraticien = prenomPraticien;
        this.adressePraticien = adressePraticien;
        this.cpPraticien = cpPraticien;
        this.villePraticien = villePraticien;
        this.coefNotoriete = coefNotoriete;
        this.typeCode = typeCode;
    }

    public int getNumPraticien() {
        return numPraticien;
    }

    public void setNumPraticien(int numPraticien) {
        this.numPraticien = numPraticien;
    }

    public String getNomPraticien() {
        return nomPraticien;
    }

    public void setNomPraticien(String nomPraticien) {
        this.nomPraticien = nomPraticien;
    }

    public String getPrenomPraticien() {
        return prenomPraticien;
    }

    public void setPrenomPraticien(String prenomPraticien) {
        this.prenomPraticien = prenomPraticien;
    }

    public String getAdressePraticien() {
        return adressePraticien;
    }

    public void setAdressePraticien(String adressePraticien) {
        this.adressePraticien = adressePraticien;
    }

    public String getCpPraticien() {
        return cpPraticien;
    }

    public void setCpPraticien(String cpPraticien) {
        this.cpPraticien = cpPraticien;
    }

    public String getVillePraticien() {
        return villePraticien;
    }

    public void setVillePraticien(String villePraticien) {
        this.villePraticien = villePraticien;
    }

    public double getCoefNotoriete() {
        return coefNotoriete;
    }

    public void setCoefNotoriete(double coefNotoriete) {
        this.coefNotoriete = coefNotoriete;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    /**
     *
     * @return String attributs de l'adresse
     */
    @Override
    public String toString() {
        return ("Praticien{numero: " + this.getNumPraticien() + "\tnom: "
                + this.getNomPraticien() + "\tprenom: " + this.getPrenomPraticien() + "\tadresse: "
                + this.getAdressePraticien() + "\tcp: " + this.getCpPraticien() + "\tville: " + this.getVillePraticien()
                + "\tcoef de notoriété: " + this.getCoefNotoriete() + "\ttype code: "
                + this.getTypeCode() + "}");
    }

}
