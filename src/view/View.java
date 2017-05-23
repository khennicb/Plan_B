package view;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Scanner;

public abstract class View {
    
    private final HashMap<Integer, String> choix = new HashMap<>();
    
    abstract public void print();
    
    public void addChoix(char cle, String description) {
        choix.put((int)cle, description);
        System.out.println("\t" + cle + " : " + description);
    }
    
    public int ask() {
        Reader reader = new InputStreamReader(System.in);
        
        int res = -1;
        boolean ok = false;
        
        while(!ok) {
            try {
                modeSync();
                res = System.in.read();
                modeDesync();
            } catch (Exception e) {
                System.err.println("Erreur de lecture.");
            }

            ok = choix.containsKey(res);

            if(!ok) {
                System.out.print("Saisir un choix valide : ");
            }
        }
        
        System.out.println("");
        
        return res;
    }
    
    public static void modeSync(){
        try {
            String[] cmd = {"/bin/sh", "-c", "stty raw </dev/tty"};
            Runtime.getRuntime().exec(cmd).waitFor();
        } catch(Exception e) { System.err.println("Erreur synchronisation inputs"); }
    }
    
    public static void modeDesync(){
        try {
            String[] cmd = {"/bin/sh", "-c", "stty -raw </dev/tty"};
            Runtime.getRuntime().exec(cmd).waitFor();
        } catch(Exception e) { System.err.println("Erreur desynchronisation inputs"); }
    }
}
