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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
            String requete = "INSERT INTO formateur(Nomformateur,Prenomformateur,Telephone,Bio,status,Diplome,Email) VALUES (?,?,?,?,?,?,?)";
           
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, t.getNomformateur());
            pst.setString(2, t.getPrenomformateur());
            pst.setString(3, t.getBio());
            pst.setInt(4, t.getTelephone());
            pst.setString(5, t.getStatus());
            pst.setString(6, t.getDiplome());
            pst.setString(7, t.getEmail());
            
            
            pst.executeUpdate();
            System.out.println("Formateur ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    //@Override
    public void supprimer(int id ) {
  

        try {
            String requete = "DELETE FROM formateur WHERE idformateur='" + id + "'";
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
            String requete = "UPDATE formateur SET Nomformateur=? ,Prenomformateur=? ,Telephone=? ,Bio=? ,status=?,Diplome=? ,Email=?   WHERE Idformateur=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(8, t.getIdformateur()) ;
            pst.setString(1, t.getNomformateur());

            pst.setString(2, t.getPrenomformateur());
            pst.setString(4, t.getBio());
            pst.setInt(3, t.getTelephone());
            pst.setString(5, t.getStatus());
            pst.setString(6, t.getDiplome());
            pst.setString(7, t.getEmail()); 
            pst.executeUpdate();
            System.out.println("Formateur modifiée!");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    //@Override
    public ObservableList<Formateur> afficherr() {
        
    ObservableList<Formateur> list = FXCollections.observableArrayList();;

        //List<Formateur> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM Formateur";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Formateur(rs.getInt(1), rs.getString(2), rs.getString(3) , rs.getString(4) ,rs.getInt(5), rs.getString(6),rs.getString(7) ,rs.getString(8) ));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }

    }
