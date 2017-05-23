
package Model;

import java.util.ArrayList;
import java.util.Date;

public class Participant {
    
    private int id;
    
    private String nom;
    
    private String prenom;
    
    private Date dateNaissance;
    
    private String adresse;
    
    private ArrayList<String> pseudos;
    
    private String numeroTelephone;
    
    private Cirque cirque = null;
}
