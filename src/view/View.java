package view;

import java.util.Scanner;

public abstract class View {
    
    abstract public void print();
    
    static public int ask(int min, int max){
        Scanner reader = new Scanner(System.in);
        
        int res = min-1;
        boolean ok = false;
        
        while(!ok) {
            try {
                res = reader.nextInt();
                ok = (min <= res && res <= max);
                
                if(!ok) {
                    System.out.print("Saisir un nombre entre " + min + " et " + max + " : ");
                }
            } catch (Exception e) {
                System.out.print("Saisir un nombre valide : ");
            }
        }
        
        return res;
    }
}
