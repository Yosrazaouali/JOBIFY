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
    private int Telephone;
    private String Bio;
    private String status;
    private String Diplome;
    private String Email;

    public Formateur() {
    }
    

    public Formateur(String Nomformateur, String Prenomformateur,  String Bio,int Telephone, String status, String Diplome, String Email) {
        this.Nomformateur = Nomformateur;
        this.Prenomformateur = Prenomformateur;
        this.Telephone = Telephone;
        this.Bio = Bio;
        this.status = status;
        this.Diplome = Diplome;
        this.Email = Email;
    }

    public Formateur(int idformateur) {
        this.idformateur = idformateur;
    }

    public Formateur(int idformateur, String Nomformateur, String Prenomformateur, String Bio, int Telephone, String status, String Diplome, String Email) {
        this.idformateur = idformateur;
        this.Nomformateur = Nomformateur;
        this.Prenomformateur = Prenomformateur;
        this.Telephone = Telephone;
        this.Bio = Bio;
        this.status = status;
        this.Diplome = Diplome;
        this.Email = Email;
    }

    public int getIdformateur() {
        return idformateur;
    }

    public void setIdformateur(int idformateur) {
        this.idformateur = idformateur;
    }

    public String getNomformateur() {
        return Nomformateur;
    }

    public void setNomformateur(String Nomformateur) {
        this.Nomformateur = Nomformateur;
    }

    public String getPrenomformateur() {
        return Prenomformateur;
    }

    public void setPrenomformateur(String Prenomformateur) {
        this.Prenomformateur = Prenomformateur;
    }

    public int getTelephone() {
        return Telephone;
    }

    public void setTelephone(int Telephone) {
        this.Telephone = Telephone;
    }

    public String getBio() {
        return Bio;
    }

    public void setBio(String Bio) {
        this.Bio = Bio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDiplome() {
        return Diplome;
    }

    public void setDiplome(String Diplome) {
        this.Diplome = Diplome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "Formateur{" + "idformateur=" + idformateur + ", Nomformateur=" + Nomformateur + ", Prenomformateur=" + Prenomformateur + ", Telephone=" + Telephone + ", Bio=" + Bio + ", status=" + status + ", Diplome=" + Diplome + ", Email=" + Email + '}';
    }
    
    

   

    
   
    
    

   

    
  
    
}