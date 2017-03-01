package controleur;

import javax.swing.JOptionPane;

public class CtrlPrincipal {

    CtrlLesVisiteurs ctrlLesVisiteurs;
    //CtrlLesClients ctrlLesClients;

    public void afficherLesVisiteurs() {
    //    this.ctrlLesPraticiens.getVue().setVisible(false);
        this.ctrlLesVisiteurs.getVue().setVisible(true);
    }

    public void afficherLesPraticiens() {
    //    this.ctrlLesPraticiens.getVue().setVisible(true);
        this.ctrlLesVisiteurs.getVue().setVisible(false);
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

   
    
    

}
