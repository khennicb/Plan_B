/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author violettn
 */
public class HomeOrganisateur extends View {

    @Override
    public void print() {
        System.out.println("Vous pouvez :");
        addChoice('c', "Gérer les cirques", null);
        addChoice('e', "Gérer les experts", null);
        addChoice('n', "Gérer les numéros", null);
        addChoice('t', "Gérer les thèmes", null);
        addChoice('a', "Gérer les artistes", null);
        addChoice('j', "Ajouter un jury", null);
        addChoice('d', "Demander l'affectation d'un jury", null);
        addChoice('f', "Afficher le programme du festival", null);
        addChoice('s', "Afficher le programme d'un spectacle", null);
        addChoice('r', "Affecter un numéro à un spectacle", null);
        System.out.print("Vous voulez faire : ");
        
        askAndGo();
    }
    
}
