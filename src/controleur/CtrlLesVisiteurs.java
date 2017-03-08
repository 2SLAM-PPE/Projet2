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
import modele.dao.DaoLabo;
import modele.dao.DaoSecteur;
import modele.metier.Labo;
import modele.metier.Secteur;
import modele.metier.Visiteur;

/**
 * @author nbourgeois
 * @version octobre 2014 - révision octobre 2016 : vue passive
 */
public class CtrlLesVisiteurs implements WindowListener, ActionListener {

    private VueLesVisiteurs vue; // LA VUE
    private CtrlPrincipal ctrlPrincipal;
    private int leVisiteur = 0;
    private List<Visiteur> lesVisiteurs;
    private List<Secteur> lesSecteurs;
    private List<Labo> lesLabos;

    public CtrlLesVisiteurs(VueLesVisiteurs vue, CtrlPrincipal ctrl) {
        this.vue = vue;
        this.ctrlPrincipal = ctrl;
        try {
            lesVisiteurs = DaoVisiteur.selectAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlLesVisiteurs - échec de sélection des visiteurs");
        }
        try {
            lesSecteurs = DaoSecteur.selectAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlLesVisiteurs - échec de sélection des secteurs");
        }
        try {
            lesLabos = DaoLabo.selectAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlLesVisiteurs - échec de sélection des labos");
        }
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
        this.vue.getjButtonVisiteurOk().addActionListener(this);
        this.vue.getjButtonVisiteurFermer().addActionListener(this);
        this.vue.getjButtonVisiteurSuivant().addActionListener(this);
        this.vue.getjButtonVisiteurPrecedent().addActionListener(this);
        for (Secteur sct : lesSecteurs) {
            this.vue.getjComboBoxVisiteurSecteur().addItem(sct.getLibSec());
        }
        for (Labo lbo : lesLabos) {
            this.vue.getjComboBoxVisiteurLabo().addItem(lbo.getNomlab());
        }

        // préparer l'état initial de la vue
        for (Visiteur vst : lesVisiteurs) {
            String nomPrenom = vst.getNom() + " " + vst.getPrenom();
            this.vue.getjComboBoxVisiteurChercher().addItem(nomPrenom);
        }
        rechercherPremier();
    }

    // contrôle de la vue
    /**
     *
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
        if (unVisiteur.getSecteur() != null) {
            getVue().getjComboBoxVisiteurSecteur().setSelectedItem(unVisiteur.getSecteur().getCodeSec());
        }else{
            getVue().getjComboBoxVisiteurSecteur().setSelectedItem(null);
        }
        for (int i = 0; i < lesLabos.size(); i++) {
            if ((unVisiteur.getLabo().getCodeLab()).equals(lesLabos.get(i).getCodeLab())) {
                getVue().getjComboBoxVisiteurLabo().setSelectedIndex(i);
            }
        }
        for (int k = 0; k < lesSecteurs.size(); k++) {
            if (unVisiteur.getSecteur() != null) {
                if ((unVisiteur.getSecteur().getCodeSec()).equals(lesSecteurs.get(k).getCodeSec())) {
                    getVue().getjComboBoxVisiteurSecteur().setSelectedIndex(k);
                }
            }
        }

        leVisiteur = (leVisiteur + x);
        //}       
    }

    // méthodes d'action
    private void rechercherPremier() {
        leVisiteur = 0;
        afficherUnVisiteur(lesVisiteurs, 0);
    }

    /**
     * Quitter l'application, après demande de confirmation
     */
    private void quitter() {
        this.getVue().setVisible(false);
        ctrlPrincipal.afficherMenuGeneral();
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
            afficherUnVisiteur(lesVisiteurs, 1);
        } else if (e.getSource().equals(vue.getjButtonVisiteurPrecedent())) {
            afficherUnVisiteur(lesVisiteurs, -1);
        } else if (e.getSource().equals(vue.getjButtonVisiteurOk())) {
            leVisiteur = 0;
            afficherUnVisiteur(lesVisiteurs, (this.vue.getjComboBoxVisiteurChercher().getSelectedIndex()));
        } else if (e.getSource().equals(vue.getjButtonVisiteurFermer())) {
            this.quitter();
        }
    }

}
