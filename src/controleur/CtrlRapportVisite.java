package controleur;

import GUI.VueRapportVisite;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modele.dao.DaoPraticien;
import modele.dao.DaoRapport;
import modele.metier.Praticien;
import modele.metier.Rapport;

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
    private boolean editMode = false;

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

        getVue().getjTextFieldNumRapport().setText(unRapport.getNumeroRapport() + "");
        getVue().getjComboBoxPraticiens().setSelectedIndex(unRapport.getNumeroPraticien());
        getVue().getjTextFieldBilan().setText(unRapport.getBilanRapport());
        getVue().getjTextFieldMotif().setText(unRapport.getMotifRapport());
        getVue().getDateChooserComboBox().setSelectedDate(toCalendar(unRapport.getDateRapport()));

        leRapport = (leRapport + x);
    }

    private void rechercherPremier() {
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
        this.vue.getjComboBoxPraticiens().addItem("Sélectionnez un praticien");
        for (Praticien ptc : lesPraticiens) {
            this.vue.getjComboBoxPraticiens().addItem(ptc.getNomPraticien() + " " + ptc.getPrenomPraticien());

        }
        leRapport = 0;
        afficherUnRapport(lesRapports, 0);
    }

    private void formulaire() {
        getVue().getjTextFieldNumRapport().setText("");
        getVue().getjComboBoxPraticiens().setSelectedIndex(0);
        getVue().getjTextFieldBilan().setText("");
        getVue().getjTextFieldMotif().setText("");
        getVue().getDateChooserComboBox().setSelectedDate(null);
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
            if (editMode) {
                int rep = JOptionPane.showConfirmDialog(null, "Le formulaire n'a pas été enregistré \n Quitter malgré tout? ?", "Formulaire", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (rep == JOptionPane.YES_OPTION) {
                    editMode = false;
                    afficherUnRapport(lesRapports, -1);
                }
            } else {
                afficherUnRapport(lesRapports, -1);
            }
        } else if (e.getSource().equals(vue.getjButtonSuivant())) {
            if (editMode) {
                int rep = JOptionPane.showConfirmDialog(null, "Le formulaire n'a pas été enregistré \n Quitter malgré tout ?", "Formulaire", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (rep == JOptionPane.YES_OPTION) {
                    editMode = false;
                    afficherUnRapport(lesRapports, 1);
                }
            } else {
                afficherUnRapport(lesRapports, 1);
            }
        } else if (e.getSource().equals(vue.getjButtonNouveau())) {
            if (editMode) {
                int numPrat = vue.getjComboBoxPraticiens().getSelectedIndex();
                java.sql.Date dateRapport = new Date(vue.getDateChooserComboBox().getSelectedDate().getTimeInMillis());

                String bilanRapport = vue.getjTextFieldBilan().getText();
                String motifRapport = vue.getjTextFieldMotif().getText();
                //ici le matricule est d'office regle sur "zzz" car la page de connexion n'est pas faite
                //le numero de rapport n'est pas editable car auto incremente
                System.out.println("\"zzz\", 10, " + numPrat + "," + dateRapport + "," + bilanRapport + "," + motifRapport);
                try {
                    DaoRapport.addRapport("zzz", 10, numPrat, dateRapport, bilanRapport, motifRapport);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(getVue(), "Echec de l'ajout du rapport");
                }
                editMode = false;
                vue.getjButtonNouveau().setText("Nouveau");
                rechercherPremier();
            } else {
                editMode = true;
                vue.getjButtonNouveau().setText("Enregistrer");
                formulaire();
            }
        } else if (e.getSource().equals(vue.getjButtonFermer())) {
            ctrlPrincipal.quitterFenetre(vue);
        }
    }

}
