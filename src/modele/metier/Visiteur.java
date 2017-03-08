package modele.metier;

import java.util.Date;

/**
 * Classe représentant les visiteurs medicaux de GSB
 *
 * @author btssio
 * @version 1.0 :
 *
 */
public class Visiteur {

    private String visMatricule;
    private String visNom;
    private String visPrenom;
    private String visAdresse;
    private String visCp;
    private String visVille;
    private Date visDateEmbauche;
    private Secteur leSecteur;
    private Labo leLabo;

/**
 * 
 * @param matricule
 * @param nom
 * @param prenom
 * @param adresse
 * @param cp
 * @param ville
 * @param dateembauche
 * @param secteur
 * @param labo 
 */
    public Visiteur(String matricule, String nom, String prenom, String adresse, String cp, String ville, Date dateembauche, Secteur secteur, Labo labo) {
        this.visMatricule = matricule;
        this.visNom = nom;
        this.visPrenom = prenom;
        this.visAdresse = adresse;
        this.visCp = cp;
        this.visVille = ville;
        this.visDateEmbauche = dateembauche;
        this.leSecteur = secteur;
        this.leLabo = labo;
    }
    /**
     * 
     * @return 
     */
    public String getMatricule() {
        return visMatricule;
    }
/**
 * 
 * @param VIS_MATRICULE 
 */
    public void setMatricule(String VIS_MATRICULE) {
        this.visMatricule = VIS_MATRICULE;
    }
/**
 * 
 * @return 
 */
    public String getNom() {
        return visNom;
    }
/**
 * 
 * @param VIS_NOM 
 */
    public void setNom(String VIS_NOM) {
        this.visNom = VIS_NOM;
    }

    public String getPrenom() {
        return visPrenom;
    }

    public void setPrenom(String VIS_PRENOM) {
        this.visPrenom = VIS_PRENOM;
    }

    public String getAdresse() {
        return visAdresse;
    }

    public void setAdresse(String VIS_ADRESSE) {
        this.visAdresse = VIS_ADRESSE;
    }

    public String getCp() {
        return visCp;
    }

    public void setCp(String VIS_CP) {
        this.visCp = VIS_CP;
    }

    public String getVille() {
        return visVille;
    }

    public void setVille(String VIS_VILLE) {
        this.visVille = VIS_VILLE;
    }

    public Date getDateEmbauche() {
        return visDateEmbauche;
    }

    public void setDateEmbauche(Date VIS_DATEEMBAUCHE) {
        this.visDateEmbauche = VIS_DATEEMBAUCHE;
    }

    public Secteur getSecteur() {
        return leSecteur;
    }

    public void setSecteur(Secteur leSecteur) {
        this.leSecteur = leSecteur;
    }

    public Labo getLabo() {
        return leLabo;
    }

    public void setLabo(Labo leLabo) {
        this.leLabo = leLabo;
    }


    /**
     *
     * @return String attributs de l'adresse
     */
    @Override
    public String toString() {
        return ("Visiteur{matricule: " + this.getMatricule() + "\tnom: " + this.getNom() + "\tprenom: " + this.getPrenom()+ "\tadresse: " + this.getAdresse()+ "\tcp: " + this.getCp()+ "\tville: " + this.getVille()+ "\tdate d'embauche: " + this.getDateEmbauche()+ "\tcode section: " + this.getSecteur().getCodeSec()+ "\tcode labo: " + this.getLabo().getCodeLab()) + "}";
    }

}
