/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

//import java.sql.Date;

import java.util.Date;


/**
 *
 * @author HP
 */
public class Formation {
    
    private int idformation ;
    private String nomfromation ;
    private int prixformation ;
    private Date datedebut ;
    private Date datefin ; 
    
        public Formation (){}

    public Formation(int idformation) {
        this.idformation = idformation;
    }
        


    public Formation(int idformation, String nomfromation, int prixformation , Date datedebut, Date datefin) {
        this.idformation = idformation;
        this.nomfromation = nomfromation;
        this.prixformation = prixformation;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    public Formation(String nomfromation, int prixformation, Date datedebut, Date datefin) {
        this.nomfromation = nomfromation;
        this.prixformation = prixformation;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

 
    public int getIdformation() {
        return idformation;
    }

    public String getNomfromation() {
        return nomfromation;
    }

    public int getPrixformation() {
        return prixformation;
    }

   public Date getDatedebut() {
        return datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setIdformation(int idformation) {
        this.idformation = idformation;
    }

    public void setNomfromation(String nomfromation) {
        this.nomfromation = nomfromation;
    }

    public void setPrixformation(int prixformation) {
        this.prixformation = prixformation;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    @Override
    public String toString() {
        return "Formation{" + "idformation=" + idformation + ", nomfromation=" + nomfromation + ", prixformation=" + prixformation + ", datedebut=" + datedebut + ", datefin=" + datefin + '}';
    }

  
    
    
    
        
    
    
      
}
