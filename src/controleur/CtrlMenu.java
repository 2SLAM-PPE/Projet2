package controleur;

import GUI.VueMenu;
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
public class CtrlMenu implements WindowListener, ActionListener {

    private VueMenu vue; // LA VUE
    private CtrlPrincipal ctrlPrincipal;

    public CtrlMenu(VueMenu vue, CtrlPrincipal ctrl) {
        this.vue = vue;
        this.ctrlPrincipal = ctrl;
        
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
        this.vue.getjButtonVisiteurs().addActionListener(this);
        this.vue.getjButtonMeds().addActionListener(this);
        this.vue.getjButtonPracticiens().addActionListener(this);
        this.vue.getjButtonQuitter().addActionListener(this);
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
    public VueMenu getVue() {
        return vue;
    }

    public void setVue(VueMenu vue) {
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
        if (e.getSource().equals(vue.getjButtonVisiteurs())) {
            ctrlPrincipal.afficherLesVisiteurs();
        } else if (e.getSource().equals(vue.getjButtonMeds())) {
        } else if (e.getSource().equals(vue.getjButtonPracticiens())) {
        } else if (e.getSource().equals(vue.getjButtonQuitter())) {
            this.quitter();
        }
    }

}
