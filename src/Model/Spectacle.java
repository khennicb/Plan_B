
package Model;

import java.util.ArrayList;
import java.util.Date;

public class Spectacle {
    
    private int id;
    
    private int numJour;
    
    private Date dateDebut;
    
    private Date dateFin;
    
    private Festival festival = null;
    
    private ArrayList<SpectacleNumero> numeros = null;
    
    private Theme theme = null;
    
    private Participant presentateur = null;
}
