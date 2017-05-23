package view;

import java.util.Scanner;

public abstract class View {
    
    abstract public void print();
    
    static public int ask(int min, int max){
        Scanner sin = new Scanner(System.in);
        
        int res = min-1;
        boolean ok = false;
        
        while(!ok) {
            if (sin.hasNextInt()) {
                res = sin.nextInt();
                
                ok = (min <= res && res <= max);
                
                if(!ok) {
                    System.out.print("Saisir un nombre entre " + min + " et " + max + " : ");
                }
            } else {
                sin.nextLine();
                System.out.print("Saisir un nombre valide : ");
            }
        }
        
        return res;
    }
}
