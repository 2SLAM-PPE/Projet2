package controleur;

import GUI.VueLesVisiteurs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import modele.dao.DaoVisiteur;
import modele.metier.Visiteur;

/**
 * @author nbourgeois
 * @version octobre 2014
 *   - révision octobre 2016 : vue passive
 */
public class CtrlLesVisiteurs implements WindowListener, ActionListener {

    private VueLesVisiteurs vue; // LA VUE
    private CtrlPrincipal ctrlPrincipal;

    public CtrlLesVisiteurs(VueLesVisiteurs vue, CtrlPrincipal ctrl) {
        this.vue = vue;
        this.ctrlPrincipal = ctrl;
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
        this.vue.getjButtonVisiteurOk().addActionListener(this);
        this.vue.getjButtonVisiteurFermer().addActionListener(this);
        this.vue.getjButtonVisiteurSuivant().addActionListener(this);
        this.vue.getjButtonVisiteurPrecedent().addActionListener(this);
       // préparer l'état iniitial de la vue
        rechercherPremier();
    }

    // contrôle de la vue
    /**
     * Remplir le composant JTable avec les adresses
     * @param desAdresses liste des adresses à afficher
     */
    private final void afficherUnVisiteur(List<Visiteur> desVisiteurs) {
        getVue().getModeleTableVisiteurs().setRowCount(0);
        String[] titresColonnes = {"RUE", "CDP", "VILLE"};
        getVue().getModeleTableAdresses().setColumnIdentifiers(titresColonnes);
        String[] ligneDonnees = new String[3];
        for (Visiteur unVisiteur : desVisiteurs) {
            getVue().getjTextFieldVisiteurNom().setText(unVisiteur.getNom()) ;
            getVue().getjTextFieldVisiteurPrenom().setText(unVisiteur.getPrenom()) ;
            getVue().getjTextFieldVisiteurAdresse().setText(unVisiteur.getAdresse()) ;
            getVue().getjTextFieldVisiteurCP().setText(unVisiteur.getCp()) ;
            getVue().getjTextFieldVisiteurVille().setText(unVisiteur.getVille()) ;
            getVue().getjComboBoxVisiteurSecteur().setSelectedItem(unVisiteur.getCodeSec());
            getVue().getjComboBoxVisiteurLabo().setSelectedItem(unVisiteur.getCodeLab());         
        }       
    }

    // méthodes d'action
    private void rechercherPremier() {
        List<Visiteur> lesVisiteurs = null;
        try {
            lesVisiteurs = DaoVisiteur.selectAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlLesVisiteurs - échec de sélection des visiteurs");
        }
        afficherUnVisiteur(lesVisiteurs);
    }


    /**
     * Quitter l'application, après demande de confirmation
     */
    private void quitter() {
        ctrlPrincipal.quitterApplication();
    }

    // ACCESSEURS et MUTATEURS
    public VueLesVisiteurs getVue() {
        return vue;
    }

    public void setVue(VueLesVisiteurs vue) {
        this.vue = vue;
    }

    // REACTIONS EVENEMENTIELLES
    @Override
    public void windowOpened(WindowEvent e) {    }

    @Override
    public void windowClosing(WindowEvent e) { 
        quitter();
    }

    @Override
    public void windowClosed(WindowEvent e) {    }

    @Override
    public void windowIconified(WindowEvent e) {    }

    @Override
    public void windowDeiconified(WindowEvent e) {    }

    @Override
    public void windowActivated(WindowEvent e) {    }

    @Override
    public void windowDeactivated(WindowEvent e) {   }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vue.getjButtonRechercher()) || e.getSource().equals(vue.getjTextFieldVille())){
            String saisie = vue.getjTextFieldVille().getText();
            rechercherVilles(saisie);
        } else{
            if (e.getSource().equals(vue.getjButtonLesClients()) ){
                ctrlPrincipal.afficherLesClients();
            }
        }
    }

}
