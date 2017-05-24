
package Model;

import java.sql.Time;
import java.util.ArrayList;

public class Spectacle {
    
    private int id;
    
    private int numJour;
    
    private Time heureDebut;
    
    private Time heureFin;
    
    private int prix;
    
    private Festival festival = null;
    
    private ArrayList<SpectacleNumero> numeros = null;
    
    private Theme theme = null;
    
    private Participant presentateur = null;
}
