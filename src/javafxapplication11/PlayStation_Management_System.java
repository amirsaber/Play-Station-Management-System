/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication11;

import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import javafx.scene.image.Image;
import javafx.scene.transform.Scale;
import javafx.stage.Screen;

/**
 *
 * @author Amir
 */
public class PlayStation_Management_System extends Application {
    
    private Stage MySage = new Stage();
    
    @Override
    public void start(Stage stage) throws Exception {

        //this.MySage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        MySage.setScene(scene);
        
        MySage.getIcons().add(new Image("ps.png"));
        MySage.setTitle("TM PlayStation Cafe Managment System");
        
        MySage.setMaximized(false);
        MySage.setResizable(false);
        MySage.show();
        
        MySage.setOnCloseRequest(e -> {
            e.consume();
            Alert CreateNewUserAlert = new Alert(Alert.AlertType.CONFIRMATION);
            CreateNewUserAlert.setTitle("Confirmation dialog");
            CreateNewUserAlert.setContentText("Are you sure ?");
            CreateNewUserAlert.setHeaderText(null);
            Optional<ButtonType> action = CreateNewUserAlert.showAndWait();
            if (action.get() == ButtonType.OK) {
                
                Platform.exit();
            }
        });
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
