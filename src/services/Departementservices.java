/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Departement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import outils.Mydb;


/**
 *
 * @author HP
 */
public class Departementservices {
    Connection cnx;

    public Departementservices() {
        this.cnx = Mydb.getInstance().getCnx();
    
    }
    
    public void ajouter(Departement t ) {
        
         try {
            String requete = "INSERT INTO departement (Named) VALUES (?)";
            PreparedStatement pst = new Mydb().getCnx().prepareStatement(requete);
           pst.setString(1, t.getNamedepartement());
           
            pst.executeUpdate();
            System.out.println("departement ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
           
    }

    //@Override
    
    public void supprimer(int id) {
        try {
            String requete = "DELETE FROM departement WHERE idD='"+id+"'";
            PreparedStatement pst = new Mydb().getCnx().prepareStatement(requete);
         
            pst.executeUpdate();
            System.out.println("departement !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    

    
    
    public void modifier(Departement t) {
      
        try {
            String requete = "UPDATE departement SET Named=? WHERE idD=?";
             PreparedStatement pst = cnx.prepareStatement(requete);
             pst.setInt(2, t.getIddepartement());
             pst.setString(1, t.getNamedepartement());
          
            pst.executeUpdate();
            System.out.println("departement modifiée!");
        } catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
    }

    
    
    
  
   
    public List<Departement> afficher() {
   
        List<Departement> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM Departement";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                 list.add(new Departement(rs.getInt(1), rs.getString(2)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
}
   
   
    
    

