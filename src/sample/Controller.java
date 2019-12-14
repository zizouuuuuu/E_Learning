package sample;

import dateBase.Connecter;
import dateBase.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.scene.control.*;
import javafx.event.ActionEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.Label;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller{
    @FXML private Button log,rm,sm,bm,wm;
    @FXML private Pane black,green,red;
    @FXML private Parent avatar1;
    @FXML private TextField t;
    @FXML private PasswordField p;




   @FXML public void Connexion(ActionEvent event) {

       if (t.getText().isEmpty() || p.getText().isEmpty()) {
           Alert a = new Alert(Alert.AlertType.INFORMATION);
           a.setTitle("Informaton Dialog");
           a.setHeaderText("Look, an information Dialog");
           a.setContentText("Username or password wrong or empty");
           a.showAndWait();
       }
        else{
           int c = User.Connect(t.getText(), p.getText());
           System.out.println(c);
           if (c >= 0) {
               try {

                   Parent root = FXMLLoader.load(getClass().getResource("Accueil1.fxml"));
                   Scene scene = new Scene(root);
                   Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
                   s.setScene(scene);
                   s.show();
               } catch (Exception e) {
                   System.out.println(e.getMessage());
               }
           }

           else {
               Alert al = new Alert(Alert.AlertType.INFORMATION);
               al.setTitle("Informaton Dialog");
               al.setHeaderText("Look, an information Dialog");
               al.setContentText("Username or password not found");
               al.showAndWait();
           }
       }
   }



////////////////////////////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////////////

    @FXML public void Inscrire(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("Inscription.fxml"));
            Scene scene = new Scene(root);
            Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
            s.setScene(scene);
            s.show();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
