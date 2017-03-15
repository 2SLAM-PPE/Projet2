package controleur;

import GUI.VueMenu;
import GUI.VueRapportVisite;
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
 * @author llusson
 * @version mars 2017
 */
public class CtrlRapportVisite implements WindowListener, ActionListener {

    private VueRapportVisite vue; // LA VUE
    private CtrlPrincipal ctrlPrincipal;

    public CtrlRapportVisite(VueRapportVisite vue, CtrlPrincipal ctrl) {
        this.vue = vue;
        this.ctrlPrincipal = ctrl;
        
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
        this.vue.getjButtonPrecedent().addActionListener(this);
        this.vue.getjButtonSuivant().addActionListener(this);
        this.vue.getjButtonNouveau().addActionListener(this);
        this.vue.getjButtonFermer().addActionListener(this);
        // préparer l'état initial de la vue
        
    }

    // contrôle de la vue

    /**
     * Quitter l'application, après demande de confirmation
     */
    private void quitter() {
        ctrlPrincipal.quitterApplication();
    }

    // ACCESSEURS et MUTATEURS
    public VueRapportVisite getVue() {
        return vue;
    }

    public void setVue(VueRapportVisite vue) {
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
        if (e.getSource().equals(vue.getjButtonPrecedent())) {
            ctrlPrincipal.afficherLesVisiteurs();
        } else if (e.getSource().equals(vue.getjButtonSuivant())) {
        } else if (e.getSource().equals(vue.getjButtonNouveau())) {
        } else if (e.getSource().equals(vue.getjButtonFermer())) {
            this.quitter();
        }
    }

}
