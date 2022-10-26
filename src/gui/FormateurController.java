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
import java.io.IOException;
import java.security.Security;
import java.util.Optional;
import java.util.Properties;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FormateurController implements Initializable {

    private TextField tfBio;
    private TextField tfStatus;
    private TextField tfTelephone;
    private TextField tfNomformateur;
    private TextField tfEmail;
    private TextField tfDiplome;
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
    @FXML
    private Button formationpage;
    @FXML
    private TextField Anomf;
    @FXML
    private TextField Aprenomf;
    @FXML
    private TextField Astatus;
    @FXML
    private TextField Atlf;
    @FXML
    private TextField Amail;
    @FXML
    private TextField Adipkome;
    @FXML
    private TextField Abio;
    @FXML
    private Button tfenvoyer;
    @FXML
    private Label nbtf;

    public void setNbtf(String nbtf) {
        this.nbtf.setText(nbtf);
    }

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Formateurservices fs = new Formateurservices();

        ObservableList<Formateur> list = formateurservice.afficherr();

        tableformateur.setItems(list);
        nomformateur.setCellValueFactory(new PropertyValueFactory<>("nomformateur"));
        tfprenom.setCellValueFactory(new PropertyValueFactory<>("prenomformateur"));
        tftelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        tfemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tfdiplome.setCellValueFactory(new PropertyValueFactory<>("diplome"));
        tfbio.setCellValueFactory(new PropertyValueFactory<>("bio"));
        tfstatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        
        setNbtf(Integer.toString(fs.nbFormateur()));

        

        // TODO
    }

    @FXML
    private void ajouterformateur(ActionEvent event) {

        String nom = Anomf.getText();
        String prenom = Aprenomf.getText();
        String bio = Abio.getText();
        String email = Amail.getText();
        String diplome = Adipkome.getText();

        String telephone = Atlf.getText();
        String status = Astatus.getText();

        if (Anomf.getText().equals("") || Abio.getText().equals("") || Aprenomf.getText().equals("") || Astatus.getText().equals("") || Atlf.getText().equals("") || Amail.getText().equals("") || Adipkome.getText().equals("")) {
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
          Notifications.create().title("NOTIFICATIONS")
                    .text("Formation Ajoutée")
                    .showInformation();

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
                f.setTelephone(Atlf.getText());
                f.setDiplome(Adipkome.getText());
                f.setEmail(Amail.getText());
                f.setPrenomformateur(Anomf.getText());
                f.setStatus(Astatus.getText());
                f.setNomformateur(Aprenomf.getText());
                f.setBio(Abio.getText());
                
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
                tfdiplome.setCellValueFactory(new PropertyValueFactory<>("diplome"));
                tfbio.setCellValueFactory(new PropertyValueFactory<>("bio"));
                tfstatus.setCellValueFactory(new PropertyValueFactory<>("status"));

            } else {
                JOptionPane.showMessageDialog(null, " Failed to delete  ! ");
            }
        }
          Notifications.create().title("NOTIFICATIONS")
                    .text("Formation Modifiée")
                    .showInformation();
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
        Notifications.create().title("NOTIFICATIONS")
                    .text("Formation supprimée")
                    .showInformation();
    }

    @FXML
    private void afficherformateur(ActionEvent event) {
        
    }

    @FXML
    private void suivantformation(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("Inscription.fxml"));
         Scene rcScene= new Scene(root);
    	
  	     Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
	window.setScene(rcScene);
	window.show();
    }

    @FXML
    private void envoyermail(ActionEvent event) {
       
        String username = "bacem.mallek999@gmail.com";
                                String password = "tpqcsexqslpycdxf";
                                Properties props = new Properties();
                                Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                                props.put("mail.smtp.port", "465");
                                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                                props.put("mail.smtp.ssl.enable", true); 
                                props.put("mail.smtp.ssl.protocols", "TLSv1.2");
                                props.put("mail.smtp.socketFactory.port", "465");
                                props.put("mail.smtp.socketFactory.fallback", "false");
                                props.put("mail.smtp.host", "smtp.gmail.com");
                                props.put("mail.smtp.auth", "true");
                                props.setProperty("mail.debug", "true");
                                props.setProperty("mail.transport.protocol", "smtp");
                                props.put("mail.smtp.starttls.enable", "true"); 
                                Session session = Session.getInstance(props, new javax.mail.Authenticator() {

                                    protected PasswordAuthentication getPasswordAuthentication() {
                                        return new PasswordAuthentication(username, password);
                                    }
                                });

                                try {
                                    Address a = new InternetAddress("bacem.mallek999@gmail.com");
      
                                    Message message = new MimeMessage(session);
                                    message.setFrom(new InternetAddress("bacem.mallek999@gmail.com"));
                                    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("yosra.zaouali@esprit.tn") );
                                    message.setSubject("Formateur");
                                    String htmlcode ="<h1> Vous appartenez officiellement à notre entreprise! </h1>"
                                            
                                            ;
                                    message.setContent(htmlcode, "text/html");                   
                                    Transport.send(message);
                                } catch (MessagingException mex) {
                                    System.out.println(" failed, exception: " + mex.getMessage());
                                }
        
        
        
        
        
        
        
    }
    

    }


