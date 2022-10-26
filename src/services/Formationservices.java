
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Formation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import outils.Mydb;
import java.sql.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author HP
 */
public class Formationservices {

    Connection cnx;

    public Formationservices() {
        this.cnx = Mydb.getInstance().getCnx();
    }

    public void ajouter(Formation t) {

        try {
            String requete = "INSERT INTO formation(Nomform,Prixform,Datedebut,Datefin) VALUES (?,?,?,?)";
            PreparedStatement pst = new Mydb().getCnx().prepareStatement(requete);

            pst.setString(1, t.getNomfromation());
            pst.setDate(3, t.getDatedebut());
            pst.setDate(4, t.getDatefin());
            pst.setInt(2, t.getPrixformation());
            pst.executeUpdate();
            System.out.println("Formation ajoutée !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    //@Override
    public void supprimer(int id) {
        try {
            String requete = "DELETE FROM formation WHERE idFormation='" + id + "'";
            PreparedStatement pst = new Mydb().getCnx().prepareStatement(requete);
            /* pst.setInt(1, t.getIdform());*/
            pst.executeUpdate();
            System.out.println("formation supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void modifier(Formation t) {

        try {
            String requete = "UPDATE formation SET Nomform=?,Prixform=? , Datedebut=? , Datefin=?  WHERE idFormation=?";
            PreparedStatement pst = new Mydb().getCnx().prepareStatement(requete);
            java.sql.Date Datedebut = new java.sql.Date(t.getDatedebut().getTime());
             java.sql.Date Datefin = new java.sql.Date(t.getDatefin().getTime());

            pst.setDate(3, t.getDatedebut());
            pst.setInt(5, t.getIdformation());
            pst.setDate(4, t.getDatefin());
            pst.setString(1, t.getNomfromation());
            pst.setInt(2, t.getPrixformation());
            pst.executeUpdate();
            System.out.println("Formation modifiée!");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
//public List<Formation> afficher() {

    public ObservableList<Formation> afficher() {
//        ObservableList<Client> myList = FXCollections.observableArrayList();
//        List<Formation> list = new ArrayList<>();
        ObservableList<Formation> list = FXCollections.observableArrayList();;

        try {
            String requete = "SELECT * FROM Formation";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Formation(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDate(4)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
}
