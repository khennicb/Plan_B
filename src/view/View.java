package view;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public abstract class View {
    
    private final HashMap<Integer, ArrayList> choix = new HashMap<>();
    
    abstract public void print();
    
    public void addChoice(char cle, String description, Object controller) {
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(description);
        arr.add(controller);
        choix.put((int)cle, arr);
        System.out.println("\t" + cle + " : " + description);
    }
    
    public void askAndGo() {
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
        
        Controller next = choix.get(res).get(1);
        
        if(next == null){
            System.err.println("Erreur : Controlleur pour " + choix.get(res).get(0) + " pas encore implémenté !");
        } else {
            next.execute();
        }
        
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
