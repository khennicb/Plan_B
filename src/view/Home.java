package view;

import java.util.Scanner;

public class Home extends View {

    @Override
    public void print() {
        System.out.println("╔═════════════════════════╗");
        System.out.println("║ FESTIVAL SIMULATOR 2017 ║");
        System.out.println("╚═════════════════════════╝");
        System.out.println("Veuillez choisir votre rôle :");
        System.out.println("\t1 : Un organisateur");
        System.out.println("\t2 : Un expert");
        System.out.print("Vous êtes : ");
        int res = ask(1, 2);
        
        switch(res){
            case 1 : 
                break;
            case 2 :
                break;
            default : 
                break;
        }
    }
    
}
