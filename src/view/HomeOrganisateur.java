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
        addChoix('c', "Gérer les cirques");
        addChoix('e', "Gérer les experts");
        addChoix('n', "Gérer les numéros");
        addChoix('t', "Gérer les thèmes");
        addChoix('a', "Gérer les artistes");
        addChoix('j', "Ajouter un jury");
        addChoix('d', "Demander l'affectation d'un jury");
        addChoix('f', "Afficher le programme du festival");
        addChoix('s', "Afficher le programme d'un spectacle");
        addChoix('r', "Affecter un numéro à un spectacle");
        System.out.print("Vous voulez faire : ");
        int res = ask();
        
        switch(res){
            case 'c' : 
                break;
            case 'e' :
                break;
            case 'n' :
                break;
            case 't' :
                break;
            case 'a' :
                break;
            case 'j' :
                break;
            case 'd' :
                break;
            case 'f' :
                break;
            case 's' :
                break;
            case 'r' :
                break;
        }
    }
    
}
