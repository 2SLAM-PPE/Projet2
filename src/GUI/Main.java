package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import modele.dao.Jdbc;
import controleur.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author btssio
 */
public class Main {
    CtrlPrincipal controleurPrincipal;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//Jdbc.creer("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:", "@localhost:1521:XE", "", "btssio", "btssio");
        Jdbc.creer("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:", "@localhost:1521:XE", "", "ppe", "ppe");
        try {
            Jdbc.getInstance().connecter();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Main - classe JDBC non trouvée");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Main - échec de connexion");
        }
        CtrlPrincipal controleurPrincipal = new CtrlPrincipal();
        
        VueMenu laVueMenu = new VueMenu();
        CtrlMenu  leControleurMenu = new CtrlMenu(laVueMenu, controleurPrincipal);
        controleurPrincipal.setCtrlMenu(leControleurMenu);
        
        controleurPrincipal.afficherMenuGeneral();
        
        // afficher la vue

    }

}
