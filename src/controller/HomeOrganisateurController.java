package controller;

import view.HomeOrganisateur;

public class HomeOrganisateurController implements Controller{

    @Override
    public void execute() {

        (new HomeOrganisateur()).print();
        
    }
    
}
