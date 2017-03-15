package modele.metier;

import java.util.Date;

/**
 * Classe représentant les rapports de visite
 *
 * @author btssio
 * @version 1.0 :
 *
 */
public class Rapport {

    private String matriculeVisiteur;
    private int numeroRapport;
    private int numeroPraticien;
    private Date dateRapport;
    private String bilanRapport;
    private String motifRapport;

    public Rapport(String matriculeVisiteur, int numeroRapport, int numeroPraticien, Date dateRapport, String bilanRapport, String motifRapport) {
        this.matriculeVisiteur = matriculeVisiteur;
        this.numeroRapport = numeroRapport;
        this.numeroPraticien = numeroPraticien;
        this.dateRapport = dateRapport;
        this.bilanRapport = bilanRapport;
        this.motifRapport = motifRapport;
    }

    public String getMatriculeVisiteur() {
        return matriculeVisiteur;
    }

    public void setMatriculeVisiteur(String matriculeVisiteur) {
        this.matriculeVisiteur = matriculeVisiteur;
    }

    public int getNumeroRapport() {
        return numeroRapport;
    }

    public void setNumeroRapport(int numeroRapport) {
        this.numeroRapport = numeroRapport;
    }

    public int getNumeroPraticien() {
        return numeroPraticien;
    }

    public void setNumeroPraticien(int numeroPraticien) {
        this.numeroPraticien = numeroPraticien;
    }

    public Date getDateRapport() {
        return dateRapport;
    }

    public void setDateRapport(Date dateRapport) {
        this.dateRapport = dateRapport;
    }

    public String getBilanRapport() {
        return bilanRapport;
    }

    public void setBilanRapport(String bilanRapport) {
        this.bilanRapport = bilanRapport;
    }

    public String getMotifRapport() {
        return motifRapport;
    }

    public void setMotifRapport(String motifRapport) {
        this.motifRapport = motifRapport;
    }

    /**
     *
     * @return String attributs du rapport
     */
    @Override
    public String toString() {
        return ("Rapport{visiteur: " + this.getMatriculeVisiteur() + "\tnum rapport: " + this.getNumeroRapport()
                + "\tnum praticien: " + this.getNumeroPraticien() + "\tdate: " + this.getDateRapport()
                + "\tbilan: " + this.getBilanRapport()+ "\tmotif: " + this.getMotifRapport()+ "}");
    }

}
