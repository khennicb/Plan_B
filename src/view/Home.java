package view;

import java.util.Scanner;

public class Home extends View {

    @Override
    public void print() {
        System.out.println("╔═════════════════════════╗");
        System.out.println("║ FESTIVAL SIMULATOR 2017 ║");
        System.out.println("╚═════════════════════════╝");
        System.out.println("Veuillez choisir votre rôle :");
        addChoice('o', "Un organisateur", null);
        addChoice('e', "Un expert", null);
        System.out.print("Vous êtes : ");
        
        askAndGo();
    }
    
}
