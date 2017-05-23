package view;

import java.util.Scanner;

public class Home extends View {

    @Override
    public void print() {
        System.out.println("╔═════════════════════════╗");
        System.out.println("║ FESTIVAL SIMULATOR 2017 ║");
        System.out.println("╚═════════════════════════╝");
        System.out.println("Veuillez choisir votre rôle :");
        addChoix('o', "Un organisateur");
        addChoix('e', "Un expert");
        System.out.print("Vous êtes : ");
        int res = ask();
        
        switch(res){
            case 'o' : 
                // todo appeler controleur home organisateur
                break;
            case 'e' :
                // todo appeler controleur home expert
                break;
        }
    }
    
}
