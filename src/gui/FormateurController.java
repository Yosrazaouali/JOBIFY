/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import services.Formateurservices;
import entities.Formateur;
import java.util.Optional;
import javafx.collections.ObservableList;

import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FormateurController implements Initializable {

    @FXML
    private TextField tfBio;
    @FXML
    private TextField tfStatus;
    @FXML
    private TextField tfTelephone;
    @FXML
    private TextField tfNomformateur;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfDiplome;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TableView<Formateur> tableformateur;
    @FXML
    private TableColumn<Formateur, String> nomformateur;
    @FXML
    private TableColumn<Formateur, String> tfprenom;
    @FXML
    private TableColumn<Formateur, String> tfstatus;
    @FXML
    private TableColumn<Formateur, String> tfdiplome;
    @FXML
    private TableColumn<Formateur, String> tftelephone;
    @FXML
    private TableColumn<Formateur, String> tfbio;
    @FXML
    private TableColumn<Formateur, String> tfemail;
    @FXML
    private Button ajouterformateur;
    @FXML
    private Button modifierformateur;
    @FXML
    private Button supprimerformateur;
    @FXML
    private Button afficherformateur;
    Formateurservices formateurservice = new Formateurservices();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<Formateur> list = formateurservice.afficherr();

        tableformateur.setItems(list);
        nomformateur.setCellValueFactory(new PropertyValueFactory<>("nomformateur"));
        tfprenom.setCellValueFactory(new PropertyValueFactory<>("prenomformateur"));
        tftelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        tfemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tfdiplome.setCellValueFactory(new PropertyValueFactory<>("diplome"));
        tfbio.setCellValueFactory(new PropertyValueFactory<>("bio"));

        // TODO
    }

    @FXML
    private void ajouterformateur(ActionEvent event) {

        String nom = tfNomformateur.getText();
        String prenom = tfPrenom.getText();
        String bio = tfBio.getText();
        String email = tfEmail.getText();
        String diplome = tfDiplome.getText();

        int telephone = Integer.parseInt(tfTelephone.getText());
        String status = tfStatus.getText();

        if (tfNomformateur.getText().equals("") || tfBio.getText().equals("") || tfPrenom.getText().equals("") || tfStatus.getText().equals("") || tfTelephone.getText().equals("") || tfemail.getText().equals("") || tfDiplome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "veuillez remplir tous le champs");
        } else {
            Formateur f = new Formateur(nom, prenom, bio, telephone, status, diplome, email);
            Formateurservices fc = new Formateurservices();
            fc.ajouter(f);

            JOptionPane.showMessageDialog(null, "formteur crée");
            //observable for real time list
            ObservableList<Formateur> list = formateurservice.afficherr();
            tableformateur.setItems(list);

            // Display col data
            nomformateur.setCellValueFactory(new PropertyValueFactory<>("nomformateur"));
            tfprenom.setCellValueFactory(new PropertyValueFactory<>("prenomformateur"));
            tftelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
            tfemail.setCellValueFactory(new PropertyValueFactory<>("email"));
            tfdiplome.setCellValueFactory(new PropertyValueFactory<>("diplome"));
            tfbio.setCellValueFactory(new PropertyValueFactory<>("bio"));
            tfstatus.setCellValueFactory(new PropertyValueFactory<>("status"));
            
            //refresh(list);

        }

    }

    @FXML
    private void modifierformateur(ActionEvent event) {
        Formateur selectedFormateur = tableformateur.getSelectionModel().getSelectedItem();
        if (selectedFormateur != null) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("ALERT ");
            alert.setHeaderText(null);
            alert.setContentText(" vous êtes sûr de modifier ce formateur ? ");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                Formateur f = new Formateur();
                f.setIdformateur(selectedFormateur.getIdformateur());
                f.setTelephone(Integer.parseInt(tfTelephone.getText()));
                f.setDiplome(tfdiplome.getText());
                f.setEmail(tfEmail.getText());
                f.setPrenomformateur(tfPrenom.getText());
                f.setStatus(tfstatus.getText());
                f.setNomformateur(tfNomformateur.getText());
                f.setBio(tfBio.getText());

                formateurservice.modifier(f);

                JOptionPane.showMessageDialog(null, "successfully modifiée!");
                //observable for real time list
                ObservableList<Formateur> list = formateurservice.afficherr();
                tableformateur.setItems(list);

                // Display col data
                nomformateur.setCellValueFactory(new PropertyValueFactory<>("nomformateur"));
                tfprenom.setCellValueFactory(new PropertyValueFactory<>("prenomformateur"));
                tftelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
                tfemail.setCellValueFactory(new PropertyValueFactory<>("email"));
                //tfdiplome.setCellValueFactory(new PropertyValueFactory<>("diplome"));
                tfdiplome.setCellValueFactory(new PropertyValueFactory<>("diplome"));
                tfbio.setCellValueFactory(new PropertyValueFactory<>("bio"));
                tfstatus.setCellValueFactory(new PropertyValueFactory<>("status"));

            } else {
                JOptionPane.showMessageDialog(null, " Failed to delete  ! ");
            }
        }
    }

    @FXML
    private void supprimerformateur(ActionEvent event) {
        Formateur f = tableformateur.getSelectionModel().getSelectedItem();
        if (f != null) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("ALERT ");
            alert.setHeaderText(null);
            alert.setContentText(" vous êtes sûr de supprimer ce formateur ? ");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                formateurservice.supprimer(f.getIdformateur());

                JOptionPane.showMessageDialog(null, "successfully deleted ! ");
                //observable for real time list
                ObservableList<Formateur> list = formateurservice.afficherr();
                tableformateur.setItems(list);

                // Display col data
                nomformateur.setCellValueFactory(new PropertyValueFactory<>("nomformateur"));
                tfprenom.setCellValueFactory(new PropertyValueFactory<>("prenomformateur"));
                tftelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
                tfemail.setCellValueFactory(new PropertyValueFactory<>("email"));
                tfdiplome.setCellValueFactory(new PropertyValueFactory<>("diplome"));
                tfbio.setCellValueFactory(new PropertyValueFactory<>("bio"));

            } else {
                JOptionPane.showMessageDialog(null, " Failed to delete  ! ");
            }
        }
    }

    @FXML
    private void afficherformateur(ActionEvent event) {
    }

}
