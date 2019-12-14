package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        try {
            Parent loginRoot = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene login =new Scene (loginRoot);
            primaryStage.setTitle("Social Learning");
            primaryStage.setScene(login);
            primaryStage.show();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public static void main(String[] args) {
        launch(args);
    }
}
