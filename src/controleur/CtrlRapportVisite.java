package controleur;

import GUI.VueMenu;
import GUI.VueRapportVisite;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modele.dao.DaoVisiteur;
import modele.dao.DaoLabo;
import modele.dao.DaoPraticien;
import modele.dao.DaoRapport;
import modele.dao.DaoSecteur;
import modele.metier.Labo;
import modele.metier.Praticien;
import modele.metier.Rapport;
import modele.metier.Secteur;
import modele.metier.Visiteur;

/**
 * @author llusson
 * @version mars 2017
 */
public class CtrlRapportVisite implements WindowListener, ActionListener {

    private VueRapportVisite vue; // LA VUE
    private CtrlPrincipal ctrlPrincipal;
    private int leRapport = 0;
    private List<Praticien> lesPraticiens;
    private List<Rapport> lesRapports;

    public CtrlRapportVisite(VueRapportVisite vue, CtrlPrincipal ctrl) {
        this.vue = vue;
        this.ctrlPrincipal = ctrl;
        try {
            lesRapports = DaoRapport.selectAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlLesVisiteurs - échec de sélection des visiteurs");
        }
        try {
            lesPraticiens = DaoPraticien.selectAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlLesVisiteurs - échec de sélection des visiteurs");
        }
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
        this.vue.getjButtonPrecedent().addActionListener(this);
        this.vue.getjButtonSuivant().addActionListener(this);
        this.vue.getjButtonNouveau().addActionListener(this);
        this.vue.getjButtonFermer().addActionListener(this);
        // préparer l'état initial de la vue

        for (Praticien ptc : lesPraticiens) {
            this.vue.getjComboBoxPraticiens().addItem(ptc.getNomPraticien() + " " + ptc.getPrenomPraticien());
        }
        rechercherPremier();
    }

    public static Calendar toCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    // contrôle de la vue
    private final void afficherUnRapport(List<Rapport> desRapports, int x) {
        Rapport unRapport = desRapports.get(leRapport + x);
        //for (Visiteur unVisiteur : desVisiteurs) {
        getVue().getjTextFieldNumRapport().setText(unRapport.getNumeroRapport() + "");
        getVue().getjComboBoxPraticiens().setSelectedIndex(unRapport.getNumeroPraticien());
        getVue().getjTextFieldBilan().setText(unRapport.getBilanRapport());
        getVue().getjTextFieldMotif().setText(unRapport.getMotifRapport());
        getVue().getDateChooserComboBox().setCurrent(toCalendar(unRapport.getDateRapport()));
        //}   
        leRapport = (leRapport + x);
    }

    private void rechercherPremier() {
        leRapport = 0;
        afficherUnRapport(lesRapports, 0);
    }

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
            afficherUnRapport(lesRapports, -1);
        } else if (e.getSource().equals(vue.getjButtonSuivant())) {
            afficherUnRapport(lesRapports, 1);
        } else if (e.getSource().equals(vue.getjButtonNouveau())) {

        } else if (e.getSource().equals(vue.getjButtonFermer())) {
            ctrlPrincipal.quitterFenetre(vue);
        }
    }

}
