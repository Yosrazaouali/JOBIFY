/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.Formateur;
import entities.Formation;
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
public class Formateurservices {

    Connection cnx;

    public Formateurservices() {
        this.cnx = Mydb.getInstance().getCnx();
    }
    

    public void ajouter(Formateur t) {

         try {
            String requete = "INSERT INTO formateur(Salaireform) VALUES (?)";
           
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, t.getSalaireform());
            pst.executeUpdate();
            System.out.println("Formateur ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    //@Override
    public void supprimer(int id ) {
  

        try {
            String requete = "DELETE FROM formateur WHERE idF='" + id + "'";
            PreparedStatement pst = cnx.prepareStatement(requete);
            //pst.setInt(1, t.getIdF());
            pst.executeUpdate();
            System.out.println("Formateur supprimée !");

            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }

   // @Override
    public void modifier(Formateur t) {

         try {
            String requete = "UPDATE formateur SET Salaireform=? WHERE IdF=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(2, t.getIdformation()) ;
            pst.setInt(1, t.getSalaireform());
            pst.executeUpdate();
            System.out.println("Formateur modifiée!");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    //@Override
    public List<Formateur> afficher() {
   
        List<Formateur> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM Formateur";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Formateur(rs.getInt(1), rs.getInt(2)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }

    }
