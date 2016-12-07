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

    private String VIS_MATRICULE;
    private String VIS_NOM;
    private String VIS_PRENOM;
    private String VIS_ADRESSE;
    private String VIS_CP;
    private String VIS_VILLE;
    private Date VIS_DATEEMBAUCHE;
    private String SEC_CODE;
    private String LAB_CODE;

/**
 * 
 * @param matricule
 * @param nom
 * @param prenom
 * @param adresse
 * @param cp
 * @param ville
 * @param dateembauche
 * @param section
 * @param labo 
 */
    public Visiteur(String matricule, String nom, String prenom, String adresse, String cp, String ville, Date dateembauche, String section, String labo) {
        this.VIS_MATRICULE = matricule;
        this.VIS_NOM = nom;
        this.VIS_PRENOM = prenom;
        this.VIS_ADRESSE = adresse;
        this.VIS_CP = cp;
        this.VIS_VILLE = ville;
        this.VIS_DATEEMBAUCHE = dateembauche;
        this.SEC_CODE = section;
        this.LAB_CODE = labo;
    }
    /**
     * 
     * @return 
     */
    public String getMatricule() {
        return VIS_MATRICULE;
    }
/**
 * 
 * @param VIS_MATRICULE 
 */
    public void setMatricule(String VIS_MATRICULE) {
        this.VIS_MATRICULE = VIS_MATRICULE;
    }
/**
 * 
 * @return 
 */
    public String getNom() {
        return VIS_NOM;
    }
/**
 * 
 * @param VIS_NOM 
 */
    public void setNom(String VIS_NOM) {
        this.VIS_NOM = VIS_NOM;
    }

    public String getPrenom() {
        return VIS_PRENOM;
    }

    public void setPrenom(String VIS_PRENOM) {
        this.VIS_PRENOM = VIS_PRENOM;
    }

    public String getAdresse() {
        return VIS_ADRESSE;
    }

    public void setAdresse(String VIS_ADRESSE) {
        this.VIS_ADRESSE = VIS_ADRESSE;
    }

    public String getCp() {
        return VIS_CP;
    }

    public void setCp(String VIS_CP) {
        this.VIS_CP = VIS_CP;
    }

    public String getVille() {
        return VIS_VILLE;
    }

    public void setVille(String VIS_VILLE) {
        this.VIS_VILLE = VIS_VILLE;
    }

    public Date getDateEmbauche() {
        return VIS_DATEEMBAUCHE;
    }

    public void setDateEmbauche(Date VIS_DATEEMBAUCHE) {
        this.VIS_DATEEMBAUCHE = VIS_DATEEMBAUCHE;
    }

    public String getCodeSec() {
        return SEC_CODE;
    }

    public void setCodeSec(String SEC_CODE) {
        this.SEC_CODE = SEC_CODE;
    }

    public String getCodeLab() {
        return LAB_CODE;
    }

    public void setCodeLab(String LAB_CODE) {
        this.LAB_CODE = LAB_CODE;
    }


    /**
     *
     * @return String attributs de l'adresse
     */
    @Override
    public String toString() {
        return ("Visiteur{matricule: " + this.getMatricule() + "\tnom: " + this.getNom() + "\tprenom: " + this.getPrenom()+ "\tadresse: " + this.getAdresse()+ "\tcp: " + this.getCp()+ "\tville: " + this.getVille()+ "\tdate d'embauche: " + this.getDateEmbauche()+ "\tcode section: " + this.getCodeSec()+ "\tcode labo: " + this.getCodeLab()) + "}";
    }

}
