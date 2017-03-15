package controleur;

import GUI.VueLesVisiteurs;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CtrlPrincipal {

    CtrlLesVisiteurs ctrlLesVisiteurs;
    CtrlMenu ctrlMenu;
    CtrlConnexion ControleurConnexion;
    JFrame currentView;
    //CtrlLesClients ctrlLesClients;

    public void afficherLesVisiteurs() {
        this.ctrlMenu.getVue().setVisible(false);
        if (ctrlLesVisiteurs == null) {
            VueLesVisiteurs laVueLesVisiteurs = new VueLesVisiteurs();
            CtrlLesVisiteurs leControleurLesVisiteurs = new CtrlLesVisiteurs(laVueLesVisiteurs, this);
            this.setCtrlLesVisiteurs(leControleurLesVisiteurs);
        }
        this.ctrlLesVisiteurs.getVue().setVisible(true);
        setCurrentView(this.ctrlLesVisiteurs.getVue());
    }

    public void afficherLesPraticiens() {
        //this.ctrlLesPraticiens.getVue().setVisible(true);
        this.ctrlLesVisiteurs.getVue().setVisible(false);
    }

    public void afficherMenuGeneral() {
        this.ctrlMenu.getVue().setVisible(true);
    }

    public void quitterApplication() {
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(null, "Quitter l'application\nEtes-vous sûr(e) ?", "AGENCEB", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            System.exit(0);
        }
    }

    public CtrlLesVisiteurs getCtrlLesVisiteurs() {
        return ctrlLesVisiteurs;
    }

    public void setCtrlLesVisiteurs(CtrlLesVisiteurs ctrlLesVisiteurs) {
        this.ctrlLesVisiteurs = ctrlLesVisiteurs;
    }

    public CtrlLesVisiteurs getCtrlMenu() {
        return ctrlLesVisiteurs;
    }

    public void setCtrlMenu(CtrlMenu ctrlMenu) {
        this.ctrlMenu = ctrlMenu;
    }

    private void setCurrentView(VueLesVisiteurs vue) {
        this.currentView = vue;
    }
    public void quitterFenetre(JFrame laVue) {
        laVue.setVisible(false);
        this.afficherMenuGeneral();
    }

}
