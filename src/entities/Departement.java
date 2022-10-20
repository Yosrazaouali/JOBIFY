/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author HP
 */
public class Departement {
    

    private int iddepartement;
    private String namedepartement;

    public Departement(String namedepartement) {
        this.namedepartement = namedepartement;
        
    }

    public Departement(int iddepartement) {
        this.iddepartement = iddepartement;
    }

    public Departement(int iddepartement, String namedepartement) {
        this.iddepartement = iddepartement;
        this.namedepartement = namedepartement;
    }
    

  

    public int getIddepartement() {
        return iddepartement;
    }

    public String getNamedepartement() {
        return namedepartement;
    }

    public void setIddepartement(int iddepartement) {
        this.iddepartement = iddepartement;
    }

    public void setNamedepartement(String namedepartement) {
        this.namedepartement = namedepartement;
    }

    @Override
    public String toString() {
        return "Departement{" + "iddepartement=" + iddepartement + ", namedepartement=" + namedepartement + '}';
    }

    public Departement() {
    }
    
    
    
    
    
    
}
   
