/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.HomeOrganisateur;
/**
 *
 * @author khennicb
 */
public class HomeOrganisateurController implements Controller{

    @Override
    public void execute() {

        (new HomeOrganisateur()).print();
        
    }
    
}
