/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Formateur {
    private int idformation;
    private int Salaireform;

    public Formateur(int Salaireform) {
        this.Salaireform = Salaireform;
    }

    public Formateur() {
    }

    public Formateur(int idformation, int Salaireform) {
        this.idformation = idformation;
        this.Salaireform = Salaireform;
    }
    

    public int getIdformation() {
        return idformation;
    }

    public void setIdformation(int idformation) {
        this.idformation = idformation;
    }

    public int getSalaireform() {
        return Salaireform;
    }

    public void setSalaireform(int Salaireform) {
        this.Salaireform = Salaireform;
    }

    @Override
    public String toString() {
        return "Formateur{" + "idformation=" + idformation + ", Salaireform=" + Salaireform + '}';
    }

   
   
    
    
     
    
    
    
        
}
