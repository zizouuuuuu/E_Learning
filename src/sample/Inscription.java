package sample;


import dateBase.ProfilApprenantDB;
import dateBase.ProfilInstructorDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Inscription implements Initializable {
	

	@FXML RadioButton r1,r2;
	@FXML TextField t1,t2,t3,t4,grade,spec, level;
	@FXML Spinner<Integer> section;
	@FXML Button conf,ret;
	@FXML DatePicker d;
	@FXML PasswordField p;
	@FXML Label lb;
	SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10,1);


	
	public void r1(ActionEvent event) {
		
		if(r1.isSelected() == true && r2.isSelected()==false) {
		
			level.setDisable(true);
			section.setDisable(true);
			grade.setDisable(false);

			
		}		
	}
	
	public void r2(ActionEvent event) {
		   if(r2.isSelected() == true && r1.isSelected() == false) {
			  
			grade.setDisable(true);
			
			     t1.setDisable(false);
				 level.setDisable(false);
				 section.setDisable(false);
				 spec.setDisable(false);
		    }
		  
	}
	
	public void Return(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("login.fxml"));
			Scene scene = new Scene(root);
			Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
			s.setScene(scene);
			s.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void confirme(ActionEvent event) {
		
		if(r1.isSelected()) {
			if(t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty() || grade.getText().isEmpty() || spec.getText().isEmpty() || p.getText().isEmpty())
					{	
						lb.setVisible(true);	
						lb.setText("Un ou plusieurs champs sont irremplis");
					}
			else {			
		ProfilInstructorDB.Inscrire(Integer.parseInt(t1.getText()),t2.getText(), t3.getText(), java.sql.Date.valueOf(d.getValue()), t4.getText(), grade.getText(), spec.getText(),p.getText());
		t2.clear();
		t3.clear();
		t4.clear();
		spec.clear();
		grade.clear();
		p.clear();
			}
		
		}
		
		else if(r2.isSelected()) {
			
			if(t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty() || level.getText().isEmpty() || spec.getText().isEmpty() || p.getText().isEmpty())
			{	
				lb.setVisible(true);	
				lb.setText("Un ou plusieurs champs sont irremplis");
			}
			else {
			ProfilApprenantDB.Inscrire(Integer.parseInt(t1.getText()),t2.getText() ,t3.getText(), java.sql.Date.valueOf(d.getValue()),t4.getText(),spec.getText(), level.getText(),section.getValue(), p.getText());
			t1.clear();
			t2.clear();
			t3.clear();
			t4.clear();
			level.clear();
			spec.clear();
			p.clear();
			}
		}
		
		Alert al = new Alert(AlertType.INFORMATION);
		al.setTitle("Informaton Dialog");
		al.setHeaderText("Look, an information Dialog");
		al.setContentText("Inscription's done perfectly");
		al.showAndWait();
		
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("login.fxml"));
			Scene scene = new Scene(root);
			Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
			s.setScene(scene);
			s.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		section.setValueFactory(valueFactory);
	}
}
