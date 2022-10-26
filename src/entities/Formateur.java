/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.logging.Logger;
import javafx.scene.control.TableColumn;

/**
 *
 * @author HP
 */
public class Formateur {
    private int idformateur ;
    private String Nomformateur ;
    private String Prenomformateur;
    private String Telephone;
    private String Bio;
    private String status;
    private String Diplome;
    private String Email;

    public Formateur() {
    }

    public int getIdformateur() {
        return idformateur;
    }

    public String getNomformateur() {
        return Nomformateur;
    }

    public String getPrenomformateur() {
        return Prenomformateur;
    }

    public String getTelephone() {
        return Telephone;
    }

    public String getBio() {
        return Bio;
    }

    public String getStatus() {
        return status;
    }

    public String getDiplome() {
        return Diplome;
    }

    public String getEmail() {
        return Email;
    }

    public Formateur(int idformateur, String Nomformateur, String Prenomformateur, String Telephone, String Bio, String status, String Diplome, String Email) {
        this.idformateur = idformateur;
        this.Nomformateur = Nomformateur;
        this.Prenomformateur = Prenomformateur;
        this.Telephone = Telephone;
        this.Bio = Bio;
        this.status = status;
        this.Diplome = Diplome;
        this.Email = Email;
    }
    
    public Formateur( String Nomformateur, String Prenomformateur, String Telephone, String Bio, String status, String Diplome, String Email) {
        this.Nomformateur = Nomformateur;
        this.Prenomformateur = Prenomformateur;
        this.Telephone = Telephone;
        this.Bio = Bio;
        this.status = status;
        this.Diplome = Diplome;
        this.Email = Email;
    }

    public void setIdformateur(int idformateur) {
        this.idformateur = idformateur;
    }

    public void setNomformateur(String Nomformateur) {
        this.Nomformateur = Nomformateur;
    }

    public void setPrenomformateur(String Prenomformateur) {
        this.Prenomformateur = Prenomformateur;
    }

    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    public void setBio(String Bio) {
        this.Bio = Bio;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDiplome(String Diplome) {
        this.Diplome = Diplome;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    

   

    
   
    
    

   

    
  
    
}