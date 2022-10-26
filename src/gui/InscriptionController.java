/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Formation;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import services.Formationservices;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class InscriptionController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprix;
    @FXML
    private DatePicker tfdated;
    @FXML
    private DatePicker tddatef;
    @FXML
    private Button valideryosra;
    @FXML
    private Button supprimeryosra;
    @FXML
    private Button modifieryosra;
    @FXML
    private Button tfafficher;
    @FXML
    private TableView<Formation> tableviewrf;
    @FXML
    private TableColumn<Formation, String> tfnomf;
    @FXML
    private TableColumn<Formation, Integer> tfprixf;
    @FXML
    private TableColumn<Formation, Date> tfdatefd;
    @FXML
    private TableColumn<Formation, Date> tfdateff;

    Formationservices formationservice = new Formationservices();
    @FXML
    private TextField tfnombre;
    @FXML
    private Button formateurpage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //observable for real time list


        // Display col data
        tfnomf.setCellValueFactory(new PropertyValueFactory<>("nomfromation"));
        tfprixf.setCellValueFactory(new PropertyValueFactory<>("prixformation"));
        tfdatefd.setCellValueFactory(new PropertyValueFactory<>("datedebut"));
        tfdateff.setCellValueFactory(new PropertyValueFactory<>("datefin"));
        ObservableList<Formation> list = formationservice.afficher();
        tableviewrf.setItems(list);
        // TODO
    }

    @FXML
    private void saveformation(ActionEvent event) {
        String nom = tfnom.getText();
        int prix = Integer.parseInt(tfprix.getText());

        java.sql.Date datedebut = Date.valueOf((tfdated.getValue()));
        java.sql.Date datefin = Date.valueOf((tddatef.getValue()));
        //String datedebut = tfdated.getValue().toString();
        //String datefin = tfdatef.getValue().toString();
        if ((tfprix.getText().equals("")) | (tfnom.getText().equals("")) || (datedebut.equals("")) || (datefin.equals(""))) {
            JOptionPane.showMessageDialog(null, "veuillez remplir tous le champs");
        } else {
            
            Formation f = new Formation(nom, prix , datedebut, datefin);
            Formationservices fc = new Formationservices();
            fc.ajouter(f);

            JOptionPane.showMessageDialog(null, "formation crée");
            //observable for real time list
            ObservableList<Formation> list = formationservice.afficher();
            tableviewrf.setItems(list);

            // Display col data
            tfnomf.setCellValueFactory(new PropertyValueFactory<>("nomfromation"));
            tfprixf.setCellValueFactory(new PropertyValueFactory<>("prixformation"));
            tfdatefd.setCellValueFactory(new PropertyValueFactory<>("datedebut"));
            tfdateff.setCellValueFactory(new PropertyValueFactory<>("datefin"));

        }
         Notifications.create().title("NOTIFICATIONS")
                    .text("Formation Ajoutée")
                    .showInformation();


    }

    @FXML
    private void supprimerformation(ActionEvent event) {
        Formation f = tableviewrf.getSelectionModel().getSelectedItem();
        if (f != null) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("ALERT ");
            alert.setHeaderText(null);
            alert.setContentText(" vous êtes sûr de supprimer cette formation ? ");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                formationservice.supprimer(f.getIdformation());

                JOptionPane.showMessageDialog(null, "successfully deleted ! ");
                //observable for real time list
                ObservableList<Formation> list = formationservice.afficher();
                tableviewrf.setItems(list);

                // Display col data
                tfnomf.setCellValueFactory(new PropertyValueFactory<>("nomfromation"));
                tfprixf.setCellValueFactory(new PropertyValueFactory<>("prixformation"));
                tfdatefd.setCellValueFactory(new PropertyValueFactory<>("datedebut"));
                tfdateff.setCellValueFactory(new PropertyValueFactory<>("datefin"));

            } else {
                JOptionPane.showMessageDialog(null, " Failed to delete  ! ");
            }
        }
        Notifications.create().title("NOTIFICATIONS")
                    .text("Formation Ajoutée")
                    .showInformation();

    }

    @FXML
    private void afficherformation(ActionEvent event) {
    }

    @FXML
    private void modifierformation(ActionEvent event) {
        Formation selectedFormation = tableviewrf.getSelectionModel().getSelectedItem();
        if (selectedFormation != null) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("ALERT ");
            alert.setHeaderText(null);
            alert.setContentText(" vous êtes sûr de modifier cette formation ? ");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                Formation f = new Formation();
                f.setIdformation(selectedFormation.getIdformation());
                f.setDatedebut(Date.valueOf(tfdated.getValue()));
                f.setDatefin(Date.valueOf(tddatef.getValue()));
                f.setPrixformation(Integer.parseInt(tfprix.getText()));
                f.setNomfromation(tfnom.getText());
                
                        
                formationservice.modifier(f);

                JOptionPane.showMessageDialog(null, "successfully modifiée!");
                //observable for real time list
                ObservableList<Formation> list = formationservice.afficher();
                tableviewrf.setItems(list);

                // Display col data
                tfnomf.setCellValueFactory(new PropertyValueFactory<>("nomfromation"));
                tfprixf.setCellValueFactory(new PropertyValueFactory<>("prixformation"));
                tfdatefd.setCellValueFactory(new PropertyValueFactory<>("datedebut"));
                tfdateff.setCellValueFactory(new PropertyValueFactory<>("datefin"));

            } else {
                JOptionPane.showMessageDialog(null, " Failed to delete  ! ");
            }
        }
        Notifications.create().title("NOTIFICATIONS")
                    .text("Formation Modifiée")
                    .showInformation();

    }
     

    @FXML
    private void formateursuivant(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("formateur.fxml"));
         Scene rcScene= new Scene(root);
    	
  	     Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
	window.setScene(rcScene);
	window.show();
    }

}

//    @FXML
    /*
    private void getselected(MouseEvent event) {
 
         index = tableviewrf.getSelectionModel().getSelectedIndex();
        if(index<= -1){
            return ;
        }
        tfidyosra.setText(tfid.getCellData(index).toString());
        tfnom.setText(tfnomf.getCellData(index).toString());
        tfdated.setValue(tfdatefd.getCellData(index).toLocalDate());
        tddatef.setValue(tfdateff.getCellData(index).toLocalDate());
        txt_type.setText(col_type.getCellData(index).toString());
 
    }
*/
    
        
        

    
        
   
