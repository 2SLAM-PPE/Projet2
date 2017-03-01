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
 * @version octobre 2014 - révision octobre 2016 : vue passive
 */
public class CtrlLesVisiteurs implements WindowListener, ActionListener {

    private VueLesVisiteurs vue; // LA VUE
    private CtrlPrincipal ctrlPrincipal;
    private int leVisiteur = 0;

    public CtrlLesVisiteurs(VueLesVisiteurs vue, CtrlPrincipal ctrl) {
        this.vue = vue;
        this.ctrlPrincipal = ctrl;
        List<Visiteur> lesVisiteurs = null;
        try {
            lesVisiteurs = DaoVisiteur.selectAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlLesVisiteurs - échec de sélection des visiteurs");
        }
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
        this.vue.getjButtonVisiteurOk().addActionListener(this);
        this.vue.getjButtonVisiteurFermer().addActionListener(this);
        this.vue.getjButtonVisiteurSuivant().addActionListener(this);
        this.vue.getjButtonVisiteurPrecedent().addActionListener(this);
        // préparer l'état iniitial de la vue
          for(Visiteur vst:lesVisiteurs){
              String nomPrenom = vst.getNom() + " " + vst.getPrenom();
              this.vue.getjComboBoxVisiteurChercher().addItem(nomPrenom);
          } 
        rechercherPremier();
    }

    // contrôle de la vue
    /**
     * Remplir le composant JTable avec les adresses
     *
     * @param desVisiteurs liste des visiteurs susceptibles d'être affichés
     */
    private final void afficherUnVisiteur(List<Visiteur> desVisiteurs, int x) {
        Visiteur unVisiteur = desVisiteurs.get(leVisiteur + x);
        //for (Visiteur unVisiteur : desVisiteurs) {
        getVue().getjTextFieldVisiteurNom().setText(unVisiteur.getNom());
        getVue().getjTextFieldVisiteurPrenom().setText(unVisiteur.getPrenom());
        getVue().getjTextFieldVisiteurAdresse().setText(unVisiteur.getAdresse());
        getVue().getjTextFieldVisiteurCP().setText(unVisiteur.getCp());
        getVue().getjTextFieldVisiteurVille().setText(unVisiteur.getVille());
        getVue().getjComboBoxVisiteurSecteur().setSelectedIndex(desVisiteurs.indexOf(unVisiteur.getCodeSec()));
        getVue().getjComboBoxVisiteurLabo().setSelectedIndex(desVisiteurs.indexOf(unVisiteur.getCodeLab()));
        leVisiteur = (leVisiteur + x);
        //}       
    }

    // méthodes d'action
    private void rechercherPremier() {
        leVisiteur = 0;
        List<Visiteur> lesVisiteurs = null;
        try {
            lesVisiteurs = DaoVisiteur.selectAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlLesVisiteurs - échec de sélection des visiteurs");
        }
        afficherUnVisiteur(lesVisiteurs, 0);
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
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        quitter();
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vue.getjButtonVisiteurSuivant())) {
            List<Visiteur> lesVisiteurs = null;
            try {
                lesVisiteurs = DaoVisiteur.selectAll();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(getVue(), "CtrlLesVisiteurs - échec de sélection des visiteurs");
            }
            afficherUnVisiteur(lesVisiteurs, 1);
        } else if (e.getSource().equals(vue.getjButtonVisiteurPrecedent())) {

            List<Visiteur> lesVisiteurs = null;
            try {
                lesVisiteurs = DaoVisiteur.selectAll();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(getVue(), "CtrlLesVisiteurs - échec de sélection des visiteurs");
            }
            afficherUnVisiteur(lesVisiteurs, -1);
        } else if (e.getSource().equals(vue.getjButtonVisiteurOk())) {
            leVisiteur = 0;
            List<Visiteur> lesVisiteurs = null;
            try {
                lesVisiteurs = DaoVisiteur.selectAll();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(getVue(), "CtrlLesVisiteurs - échec de sélection des visiteurs");
            }
            afficherUnVisiteur(lesVisiteurs, (this.vue.getjComboBoxVisiteurChercher().getSelectedIndex()));

        } else if (e.getSource().equals(vue.getjButtonVisiteurFermer())) {
            int rep = JOptionPane.showConfirmDialog(null, "Quitter l'application\nÊtes-vous sûr(e) ?", "GSB", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (rep == JOptionPane.YES_OPTION) {
                // mettre fin à l'application
                System.exit(0);
            }
        }
    }

}
