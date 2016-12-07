package controleur;

import javax.swing.JOptionPane;

public class CtrlPrincipal {

    CtrlLesVisiteurs ctrlLesVisiteurs;
    //CtrlLesClients ctrlLesClients;

    public void afficherLesVisiteurs() {
        this.ctrlLesPra.getVue().setVisible(false);
        this.ctrlLesVisiteurs.getVue().setVisible(true);
    }

    public void afficherLesClients() {
        this.ctrlLesClients.getVue().setVisible(true);
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

    public CtrlLesAdresses getCtrlLesAdresses() {
        return ctrlLesAdresses;
    }

    public void setCtrlLesAdresses(CtrlLesAdresses ctrlLesAdresses) {
        this.ctrlLesAdresses = ctrlLesAdresses;
    }

    public CtrlLesClients getCtrlLesClients() {
        return ctrlLesClients;
    }

    public void setCtrlLesClients(CtrlLesClients ctrlLesClients) {
        this.ctrlLesClients = ctrlLesClients;
    }
    
    

}
